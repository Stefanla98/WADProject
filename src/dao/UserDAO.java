package dao;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utils.DBConnection;

public class UserDAO {
	
	private static UserDAO instance;
	
	public static UserDAO getInstance() {
		if(instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}
	
	private UserDAO() {}
	
	public boolean userExists(String username) throws ClassNotFoundException, SQLException {
		boolean status = false;
		String sql = "SELECT username FROM users WHERE username='"+username+"'";
		
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement prep = connection.prepareStatement(sql);
			){
			ResultSet rs = prep.executeQuery();
			if(rs.next())
				 status = true;
			 else status = false;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return status;
	}
	
	public boolean addUser(String username, String password, String email, String gender, String telephone, String restaurant, String subscribed) throws SQLException, ClassNotFoundException {
		
		String sql="INSERT INTO users (username," + 
				"password," + 
				"Email," + 
				"Gender," + 
				"Telephone," + 
				"restaurant," + 
				"Subscribed) values (?, ? , ?, ?, ?, ?, ?);";
		
		String secPass = getHash(password);
		
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement prep = connection.prepareStatement(sql);
			){
			prep.setString(1, username);
			prep.setString(2, secPass);
			prep.setString(3, email);
			prep.setString(4, gender);
			prep.setString(5, telephone);
			prep.setString(6, restaurant);
			prep.setString(7, subscribed);
			prep.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return true;
	}
	
	public boolean loginVerification(String username, String password) throws ClassNotFoundException, SQLException {
		boolean status1, status2 = false;
		
		String sql = "SELECT username FROM users WHERE username='"+username+"'";
		
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement prep = connection.prepareStatement(sql);
			){
			ResultSet rs = prep.executeQuery();
			if(rs.next())
				 status1 = true;
			 else status1 = false;
		}

		
		String sql2 = "SELECT password FROM users WHERE username='"+username+"'";
		
		String secPass = getHash(password);
		
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement prep2 = connection.prepareStatement(sql2);
			){
			ResultSet rs2 = prep2.executeQuery();
			while(rs2.next()) {
				if(rs2.getString("password").equals(secPass)) {
					status2 = true;
				} else status2 = false;
			}
		}
		 
		boolean finalStatus = status1 && status2;
		return finalStatus;
	}
	
	public boolean makeReservation(String fName, String lName, String email, String telephone, String date, 
			String noGuests, String timeF, String timeT) throws SQLException {
		
		String sql = "INSERT INTO reservations (firstName, lastName, email, telephone, date, noGuests, timeFrom, timeTo) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);"; 
		
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement prep = connection.prepareStatement(sql);
			){
			prep.setString(1, fName);
			prep.setString(2, lName);
			prep.setString(3, email);
			prep.setString(4, telephone);
			prep.setString(5, date);
			prep.setString(6, noGuests);
			prep.setString(7, timeF);
			prep.setString(8, timeT);
			prep.execute();
		}
		
		return true;
	}
	
	
	public static String getHash(String password) {
		MessageDigest digest=null;
		try {
			digest = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		digest.reset();
		try {
			digest.update(password.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}
			return new BigInteger(1, digest.digest()).toString(16);
		}
	
}
