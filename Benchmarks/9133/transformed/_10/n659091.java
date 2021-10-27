class n659091 {
	public static void main(String args[]) {
		Connection con = null;
		String url = "jdbc:mySubprotocol:myDataSource";
		PreparedStatement updateSales;
		Statement stmt;
		String updateString = "update COFFEES " + "set SALES = ? where COF_NAME = ?";
		PreparedStatement updateTotal;
		String updateStatement = "update COFFEES " + "set TOTAL = TOTAL + ? where COF_NAME = ?";
		try {
			Class.forName("myDriver.ClassName");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		String query = "select COF_NAME, SALES, TOTAL from COFFEES";
		try {
			con = DriverManager.getConnection(url, "myLogin", "myPassword");
			updateSales = con.prepareStatement(updateString);
			int[] salesForWeek = { 175, 150, 60, 155, 90 };
			updateTotal = con.prepareStatement(updateStatement);
			String[] coffees = { "Colombian", "French_Roast", "Espresso", "Colombian_Decaf", "French_Roast_Decaf" };
			int len = coffees.length;
			con.setAutoCommit(false);
			for (int i = 0; i < len; i++) {
				updateSales.setInt(1, salesForWeek[i]);
				updateSales.setString(2, coffees[i]);
				updateSales.executeUpdate();
				updateTotal.setInt(1, salesForWeek[i]);
				updateTotal.setString(2, coffees[i]);
				updateTotal.executeUpdate();
				con.commit();
			}
			con.setAutoCommit(true);
			updateSales.close();
			updateTotal.close();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String c = rs.getString("COF_NAME");
				int s = rs.getInt("SALES");
				int t = rs.getInt("TOTAL");
				System.out.println(c + "     " + s + "    " + t);
			}
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			if (con != null) {
				try {
					System.err.print("Transaction is being ");
					System.err.println("rolled back");
					con.rollback();
				} catch (SQLException excep) {
					System.err.print("SQLException: ");
					System.err.println(excep.getMessage());
				}
			}
		}
	}

}