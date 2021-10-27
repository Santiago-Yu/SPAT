class n10960896 {
	public static void executeUpdate(Database Rs1DkPzu, String... n5YHZlzv) throws SQLException {
		Connection dLb2Xn2H = null;
		Statement gC4KYDQk = null;
		try {
			dLb2Xn2H = getConnection(Rs1DkPzu);
			dLb2Xn2H.setAutoCommit(false);
			gC4KYDQk = dLb2Xn2H.createStatement();
			for (String HBSV2FJ1 : n5YHZlzv) {
				gC4KYDQk.executeUpdate(HBSV2FJ1);
			}
			dLb2Xn2H.commit();
		} catch (SQLException e56gL4X1) {
			try {
				dLb2Xn2H.rollback();
			} catch (SQLException k7KDnJ5d) {
			}
			throw e56gL4X1;
		} finally {
			closeStatement(gC4KYDQk);
			closeConnection(dLb2Xn2H);
		}
	}

}