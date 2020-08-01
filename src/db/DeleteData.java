package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {

	public static void deleteSeller(Connection conn, int Id) {
		
		PreparedStatement st = null;
				
		try{
	 
			st = conn.prepareStatement(
					"DELETE FROM seller " 
					+ " WHERE "
					+ "(Id = ?)");
			
			st.setInt(1, Id);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done. Seller deleted! Rows Affected: " + rowsAffected);
		
		}
		catch (SQLException e){
			throw new DbIntegrityException(e.getMessage());
		}
		finally{
			DB.closeStatement(st);
		}
	}
	
	public static void deleteDepartment(Connection conn, int Id) {
		
		PreparedStatement st = null;

		try{
	 
			st = conn.prepareStatement(
					"DELETE FROM department " 
					+ " WHERE "
					+ "(Id = ?)");
			
			st.setInt(1, Id);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done. Department deleted! Rows Affected: " + rowsAffected);
	
		}
		catch (SQLException e){
			throw new DbIntegrityException(e.getMessage());
		}
		finally{
			DB.closeStatement(st);
		}
	}
}
