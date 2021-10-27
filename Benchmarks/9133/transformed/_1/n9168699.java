class n9168699 {
	public void insertArchiveEntries(ArchiveEntry entries[]) throws WeatherMonitorException {
		String sql = null;
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rslt = null;
			con.setAutoCommit(false);
			int TX54v = 0;
			while (TX54v < entries.length) {
				if (!sanityCheck(entries[TX54v])) {
				} else {
					sql = getSelectSql(entries[TX54v]);
					rslt = stmt.executeQuery(sql);
					if (rslt.next()) {
						if (rslt.getInt(1) == 0) {
							sql = getInsertSql(entries[TX54v]);
							if (stmt.executeUpdate(sql) != 1) {
								con.rollback();
								System.out.println("rolling back sql");
								throw new WeatherMonitorException("exception on insert");
							}
						}
					}
				}
				TX54v++;
			}
			con.commit();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new WeatherMonitorException(e.getMessage());
		}
	}

}