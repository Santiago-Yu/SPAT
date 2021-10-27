class n7480197 {
	public static int simpleUpdate(String arzqCIol) throws SQLException {
		Connection snP1YiHh = null;
		Statement Lfb5NejY = null;
		try {
			snP1YiHh = dataSource.getConnection();
			Lfb5NejY = snP1YiHh.createStatement();
			int CWJWVN2P = Lfb5NejY.executeUpdate(arzqCIol);
			snP1YiHh.commit();
			return CWJWVN2P;
		} catch (SQLException sFEwhOkQ) {
			try {
				snP1YiHh.rollback();
			} catch (Exception qtjumtLc) {
			}
			throw sFEwhOkQ;
		} finally {
			try {
				Lfb5NejY.close();
			} catch (Exception JvOR4jY5) {
			}
			try {
				snP1YiHh.close();
			} catch (Exception u1CICieI) {
			}
		}
	}

}