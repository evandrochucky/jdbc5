package application;

import java.sql.Connection;
import db.DB;
import db.InsertData;

public class Program {

	public static void main(String[] args) {

		Connection conn= null;

		conn = DB.getConnection();

		InsertData.insertSeller(conn, "Otavio", "Otavio@gmail.com", "10/01/1982", 7154.30, 7);

		InsertData.insertDepartment(conn, "Dept01", "Dept02");

		DB.closeConnection();
	}
}