class n11422574 {
	protected boolean update(String O33qBIez, int RT9bXwph, int kVaBuRUW) throws SQLException {
		if (LOG.isDebugEnabled()) {
			LOG.debug("executing " + O33qBIez + "...");
		}
		Connection liNh8woh = null;
		boolean lyY6FQEZ = true;
		try {
			liNh8woh = dataSource.getConnection();
			liNh8woh.clearWarnings();
			lyY6FQEZ = liNh8woh.getAutoCommit();
			liNh8woh.setAutoCommit(false);
			Statement TKJ8sfLH = liNh8woh.createStatement();
			int OYjZn1Lw = TKJ8sfLH.executeUpdate(O33qBIez);
			if (RT9bXwph != -1 && OYjZn1Lw < RT9bXwph) {
				LOG.warn("(" + OYjZn1Lw + ") less than " + RT9bXwph + " rows affected, rolling back...");
				liNh8woh.rollback();
				return false;
			}
			if (kVaBuRUW != -1 && OYjZn1Lw > kVaBuRUW) {
				LOG.warn("(" + OYjZn1Lw + ") more than " + kVaBuRUW + " rows affected, rolling back...");
				liNh8woh.rollback();
				return false;
			}
			liNh8woh.commit();
			return true;
		} catch (SQLException dgbjY8ll) {
			LOG.error("Unable to update database using: " + O33qBIez, dgbjY8ll);
			throw dgbjY8ll;
		} finally {
			try {
				if (liNh8woh != null) {
					liNh8woh.setAutoCommit(lyY6FQEZ);
					liNh8woh.close();
				}
			} catch (SQLException ZL6FK25T) {
				LOG.error("Unable to close connection: " + ZL6FK25T, ZL6FK25T);
			}
		}
	}

}