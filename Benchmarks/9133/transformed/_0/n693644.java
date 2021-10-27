class n693644 {
	public static void refreshSession(int Tzw57qOS) {
		Connection PR1fNYno = null;
		try {
			PR1fNYno = getConnection();
			PreparedStatement V6ZeBxmx = PR1fNYno.prepareStatement(
					"UPDATE customer SET c_login = NOW(), c_expiration = DATE_ADD(NOW(), INTERVAL 2 HOUR) WHERE c_id = ?");
			V6ZeBxmx.setInt(1, Tzw57qOS);
			V6ZeBxmx.executeUpdate();
			PR1fNYno.commit();
			V6ZeBxmx.close();
			returnConnection(PR1fNYno);
		} catch (java.lang.Exception BbWzbqJS) {
			try {
				PR1fNYno.rollback();
				BbWzbqJS.printStackTrace();
			} catch (Exception maRaIP6M) {
				System.err.println("Transaction rollback failed.");
			}
		}
	}

}