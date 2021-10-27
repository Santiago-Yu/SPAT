class n23677148 {
	public static void Sample2(String f3jRnTeG, String blTYUwYi, String bf9UM0Uc) throws SQLException {
		Connection tA1pMw9z = DriverManager.getConnection("jdbc:postgresql://localhost/test", "user", "password");
		tA1pMw9z.setAutoCommit(false);

		Statement QEs5lFxL = tA1pMw9z.createStatement();

		String mXMp53YM = "UPDATE myTable SET myField = '" + f3jRnTeG + "' WHERE myOtherField1 = '" + blTYUwYi
				+ "' AND myOtherField2 = '" + bf9UM0Uc + "'";

		int czXiYYop = QEs5lFxL.executeUpdate(mXMp53YM);

		// If more than 10 entries change, panic and rollback
		if (czXiYYop > 10) {
			tA1pMw9z.rollback();
		} else {
			tA1pMw9z.commit();
		}

		QEs5lFxL.close();
		tA1pMw9z.close();
	}

}