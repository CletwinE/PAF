package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Beans.PaymentBean;
import DB_Config.DBConnection;

public class Payment {

	public String readPayment() {
		String output = "";
		try {

			Connection con = DBConnection.connect();

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed

			output = "<table border=\"1\">" + "<tr>" + "<th>Card No</th>" + "<th>Name On Card</th>"
					+ "<th>Expiry Date</th>" + "<th>CVC No</th>";

			String query = "select * from payment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {

				String paymentid = Integer.toString(rs.getInt("paymentID"));
				String cardno = Integer.toString(rs.getInt("cardNo"));
				String nameoncard = rs.getString("nameOnCard");
				String expdate = rs.getString("expDate");
				String cvcno = Integer.toString(rs.getInt("cvc"));

				// Add into the html table
				output += "<tr>" + "<td>" + cardno + "</td>";
				output += "<td>" + nameoncard + "</td>";
				output += "<td>" + expdate + "</td>";
				output += "<td>" + cvcno + "</td>";

			}

			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String insertPayment(PaymentBean doc) {

		String output = "";
		try {

			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = "insert into payment" + "(`paymentID`,`cardNo`,`nameOnCard`,`expDate`,`cvc`)"
					+ " values (?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setInt(2, doc.getCardNo());
			preparedStmt.setString(3, doc.getNameOnCard());
			preparedStmt.setString(4, doc.getExpDate());
			preparedStmt.setInt(5, doc.getCvc());

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted Payment successfully";
		} catch (Exception e) {
			output = "Error while inserting Payment Info";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deletePayment(String paymentID) {
		String output = "";
		try {

			Connection con = DBConnection.connect();

			if (con == null) {

				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from payment where paymentID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(paymentID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted Payment successfully";

		} catch (Exception e) {
			output = "Error while deleting the payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updatePayment(PaymentBean doc) {

		String output = "";

		try {

			Connection con = DBConnection.connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE payment SET cardNo = ?, nameOnCard = ?, expDate = ?, cvc = ? WHERE paymentID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, doc.getCardNo());
			preparedStmt.setString(2, doc.getNameOnCard());
			preparedStmt.setString(3, doc.getExpDate());
			preparedStmt.setInt(4, doc.getCvc());
			preparedStmt.setInt(5, doc.getPaymentID());

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
