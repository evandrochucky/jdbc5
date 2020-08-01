package application;

import java.sql.Connection;

import db.DB;
import db.InsertData;
import db.UpdateData;

public class Program {

	public static void main(String[] args) {

		Connection conn= null;

		conn = DB.getConnection();

		
		InsertData.insertSeller(conn, "Leandro", "Leandro@gmail.com", "10/05/1975", 1242.30, 2);

		InsertData.insertDepartment(conn, "Dept07", "Dept08");
		
		
		UpdateData.updateSeller(conn, 200.00, 2);
		

		DB.closeConnection();
	}
}