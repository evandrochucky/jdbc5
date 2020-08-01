package application;

import java.sql.Connection;

import db.DB;
import db.DeleteData;
import db.InsertData;
import db.UpdateData;

public class Program {

	public static void main(String[] args) {

		Connection conn= null;

		conn = DB.getConnection();

		
		InsertData.insertSeller(conn, "Paulo", "paulo@gmail.com", "23/11/1976", 3500.30, 4);

		InsertData.insertDepartment(conn, "Dept11", "Dept12");
		
		
		UpdateData.updateSeller(conn, 200.00, 2);

		UpdateData.updateDepartment(conn, 16, "Natural");
		
		DeleteData.deleteSeller(conn, 10);
		DeleteData.deleteDepartment(conn, 2);

		DB.closeConnection();
	}
}