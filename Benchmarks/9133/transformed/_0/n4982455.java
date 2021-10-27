class n4982455 {
	static final void saveStatus(JWAIMStatus ZaeUZx2D, DBConnector mvHS4Z80) throws IOException {
		Connection UfuXUXze = null;
		PreparedStatement jlBDbQzD = null;
		Statement xIfb9e82 = null;
		try {
			UfuXUXze = mvHS4Z80.getDB();
			UfuXUXze.setAutoCommit(false);
			xIfb9e82 = UfuXUXze.createStatement();
			xIfb9e82.executeUpdate("DELETE FROM status");
			jlBDbQzD = UfuXUXze.prepareStatement("INSERT INTO status VALUES (?, ?)");
			jlBDbQzD.setString(1, "jwaim.status");
			jlBDbQzD.setBoolean(2, ZaeUZx2D.getJWAIMStatus());
			jlBDbQzD.addBatch();
			jlBDbQzD.setString(1, "logging.status");
			jlBDbQzD.setBoolean(2, ZaeUZx2D.getLoggingStatus());
			jlBDbQzD.addBatch();
			jlBDbQzD.setString(1, "stats.status");
			jlBDbQzD.setBoolean(2, ZaeUZx2D.getStatsStatus());
			jlBDbQzD.addBatch();
			jlBDbQzD.executeBatch();
			UfuXUXze.commit();
		} catch (SQLException bwODFK9S) {
			try {
				UfuXUXze.rollback();
			} catch (SQLException OWRlx3P0) {
				OWRlx3P0.printStackTrace();
			}
			throw new IOException(bwODFK9S.getMessage());
		} finally {
			if (xIfb9e82 != null) {
				try {
					xIfb9e82.close();
				} catch (SQLException hkzfXad5) {
				}
			}
			if (jlBDbQzD != null) {
				try {
					jlBDbQzD.close();
				} catch (SQLException x4aSqArf) {
				}
			}
			if (UfuXUXze != null) {
				try {
					UfuXUXze.close();
				} catch (SQLException i6qBFN2g) {
				}
			}
		}
	}

}