package com.btg.work;

import java.sql.*;
import java.util.*;

public class ClientDAO {
	
	public List<Client> getAllClients() throws SQLException {
		Connection conn = ConnectionUtility.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * from clients");
		
		List<Client> list = new ArrayList<Client>() ;
		while(rs.next()) {
			Client c = new Client (rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			list.add(c);				
		}
		ConnectionUtility.closeConnection();
		return list;		
	}	
}