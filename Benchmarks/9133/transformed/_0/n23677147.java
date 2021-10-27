class n23677147 {
	public static void Sample1(String r5LlOvUu, String F340A7L0, String HnB7HYFl) throws SQLException {
		Connection krhAVmDE = DriverManager.getConnection("jdbc:postgresql://localhost/test", "user", "password");
		krhAVmDE.setAutoCommit(false);

		PreparedStatement aqKCVsYH = krhAVmDE
				.prepareStatement("UPDATE myTable SET myField = ? WHERE myOtherField1 = ? AND myOtherField2 = ?");
		aqKCVsYH.setString(1, r5LlOvUu);
		aqKCVsYH.setString(2, F340A7L0);
		aqKCVsYH.setString(3, HnB7HYFl);

		// If more than 10 entries change, panic and rollback
		int fBBPnlK2 = aqKCVsYH.executeUpdate();
		if (fBBPnlK2 > 10) {
			krhAVmDE.rollback();
		} else {
			krhAVmDE.commit();
		}

		aqKCVsYH.close();
		krhAVmDE.close();
	}

}