package application;

import java.sql.Connection;
import java.sql.SQLException;

import db.DB;
import db.DbException;
import db.DeleteData;
import db.InsertData;
import db.UpdateData;

public class Program {

	public static void main(String[] args) {

		Connection conn= null;

		try {
			
			conn = DB.getConnection();
			
			conn.setAutoCommit(false);
			// Setamos para FALSE para controlar o commit para a transa��o completa.
			// S� vai commitar no banco quando terminar todas as execu��es em tabelas
			// Caso contr�rio, executamos rollback na transa��o
			
			InsertData.insertSeller(conn, "Paulo", "paulo@gmail.com", "23/11/1976", 3500.30, 4);
	
			InsertData.insertDepartment(conn, "Dept11", "Dept12");
			
			
			UpdateData.updateSeller(conn, 200.00, 2);
	
			UpdateData.updateDepartment(conn, 23, "Natural Parks");
			
			DeleteData.deleteSeller(conn, 11);
			DeleteData.deleteDepartment(conn, 25);

			//As altera��es no banco de dados ser�o efetivadas somente no final do processo, garantindo integridade relacional
			conn.commit();
			
		}
		catch (SQLException e){
			try {
				conn.rollback();
				throw new DbException("Transaction Rolled back! Caused by: " + e.getMessage());
			} 
			catch (SQLException e1) {
				throw new DbException("Error trying rollback! Caused by: " + e1.getMessage());
			}
		}
		finally {
			DB.closeConnection();
		}

	}
}