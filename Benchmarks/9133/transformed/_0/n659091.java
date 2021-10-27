class n659091 {
	public static void main(String GEpfrwCR[]) {
		String fggsGAWV = "jdbc:mySubprotocol:myDataSource";
		Connection tD0FejUB = null;
		Statement df6oIpqw;
		PreparedStatement aLe4AhZq;
		PreparedStatement dRI2DiyC;
		String PSY0Ado2 = "update COFFEES " + "set SALES = ? where COF_NAME = ?";
		String LVsqv5Bu = "update COFFEES " + "set TOTAL = TOTAL + ? where COF_NAME = ?";
		String tOuwo5Rt = "select COF_NAME, SALES, TOTAL from COFFEES";
		try {
			Class.forName("myDriver.ClassName");
		} catch (java.lang.ClassNotFoundException L2iGnYsx) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(L2iGnYsx.getMessage());
		}
		try {
			tD0FejUB = DriverManager.getConnection(fggsGAWV, "myLogin", "myPassword");
			aLe4AhZq = tD0FejUB.prepareStatement(PSY0Ado2);
			dRI2DiyC = tD0FejUB.prepareStatement(LVsqv5Bu);
			int[] QpJ6Rukl = { 175, 150, 60, 155, 90 };
			String[] mMKli3CN = { "Colombian", "French_Roast", "Espresso", "Colombian_Decaf", "French_Roast_Decaf" };
			int p9F6T5Vj = mMKli3CN.length;
			tD0FejUB.setAutoCommit(false);
			for (int djZryi66 = 0; djZryi66 < p9F6T5Vj; djZryi66++) {
				aLe4AhZq.setInt(1, QpJ6Rukl[djZryi66]);
				aLe4AhZq.setString(2, mMKli3CN[djZryi66]);
				aLe4AhZq.executeUpdate();
				dRI2DiyC.setInt(1, QpJ6Rukl[djZryi66]);
				dRI2DiyC.setString(2, mMKli3CN[djZryi66]);
				dRI2DiyC.executeUpdate();
				tD0FejUB.commit();
			}
			tD0FejUB.setAutoCommit(true);
			aLe4AhZq.close();
			dRI2DiyC.close();
			df6oIpqw = tD0FejUB.createStatement();
			ResultSet K68OuqrV = df6oIpqw.executeQuery(tOuwo5Rt);
			while (K68OuqrV.next()) {
				String uTp6PiIU = K68OuqrV.getString("COF_NAME");
				int OUCP3kns = K68OuqrV.getInt("SALES");
				int iwzwCsC7 = K68OuqrV.getInt("TOTAL");
				System.out.println(uTp6PiIU + "     " + OUCP3kns + "    " + iwzwCsC7);
			}
			df6oIpqw.close();
			tD0FejUB.close();
		} catch (SQLException P2BSWBJW) {
			System.err.println("SQLException: " + P2BSWBJW.getMessage());
			if (tD0FejUB != null) {
				try {
					System.err.print("Transaction is being ");
					System.err.println("rolled back");
					tD0FejUB.rollback();
				} catch (SQLException iRyVHRUz) {
					System.err.print("SQLException: ");
					System.err.println(iRyVHRUz.getMessage());
				}
			}
		}
	}

}