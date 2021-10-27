class n9016775 {
	private int saveToTempTable(ArrayList cons, String tempTableName, boolean truncateFirst) throws SQLException {
		if (truncateFirst) {
			this.executeUpdate("TRUNCATE TABLE " + tempTableName);
			Categories.dataDb().debug("TABLE " + tempTableName + " TRUNCATED.");
		}
		PreparedStatement ps = null;
		int rows = 0;
		try {
			String insert = "INSERT INTO " + tempTableName + " VALUES (?)";
			ps = this.conn.prepareStatement(insert);
			int x3aqU = 0;
			while (x3aqU < cons.size()) {
				ps.setLong(1, ((Long) cons.get(x3aqU)).longValue());
				rows = ps.executeUpdate();
				if ((x3aqU % 500) == 0) {
					this.conn.commit();
				}
				x3aqU++;
			}
			this.conn.commit();
		} catch (SQLException sqle) {
			this.conn.rollback();
			throw sqle;
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
		return rows;
	}

}