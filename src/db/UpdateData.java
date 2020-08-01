package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UpdateData {

	public static void updateSeller(Connection conn, Double additionalAmountSalary, int department) {
				
		PreparedStatement st = null;
//		ResultSet rs = null;
				
		try{
	 
			st = conn.prepareStatement(
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE "
					+ "(DepartmentId = ?)");
//					+ Statement.RETURN_GENERATED_KEYS);
			
//			st.setDouble(1, 200.0);
//			st.setInt(2, 2);
			
			st.setDouble(1, additionalAmountSalary);
			st.setInt(2, department);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done. Seller updated! Rows Affected: " + rowsAffected);
		
//			if (rowsAffected > 0) {
//				rs = st.getGeneratedKeys();
//				while (rs.next()) {
//					int id = rs.getInt(1);
//					System.out.println("Done! Id: " + id);
//				}
//			}
//			else {
//				System.out.println("No Rows Affected!");
//			}
	
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally{
//			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}
	
	public static void updateDepartment(Connection conn, int Id, String newName) {
		
		PreparedStatement st = null;

		try{
	 
			st = conn.prepareStatement(
					"UPDATE department "
					+ "SET Name = ? "
					+ "WHERE "
					+ "(Id = ?)");

			st.setString(1, newName);
			st.setInt(2, Id);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done. Department updated! Rows Affected: " + rowsAffected);
	
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally{
			DB.closeStatement(st);
		}
	}
}
