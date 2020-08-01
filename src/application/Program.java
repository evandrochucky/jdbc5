package application;

import java.sql.Connection;

import db.DB;
import db.InsertData;
import db.UpdateData;

public class Program {

	public static void main(String[] args) {

		Connection conn= null;

		conn = DB.getConnection();

		
		InsertData.insertSeller(conn, "Joana", "joana@gmail.com", "23/12/1985", 1100.30, 2);

		InsertData.insertDepartment(conn, "Dept11", "Dept12");
		
		
		UpdateData.updateSeller(conn, 200.00, 2);

		UpdateData.updateDepartment(conn, 15, "Franquias");

		DB.closeConnection();
	}
}