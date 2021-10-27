class n19197300 {
	private void writeStatsToDatabase(long transferJobAIPCount, long reprocessingJobAIPCount, long transferJobAIPVolume,
			long reprocessingJobAIPVolume, long overallBinaryAIPCount, Map<String, AIPStatistics> mimeTypeRegister)
			throws SQLException {
		long nextMimetypeStatsID;
		int nextAIPStatsID;
		String aipStatsQuery = "select max(aip_statistics_id) from aip_statistics";
		Statement select = dbConnection.createStatement();
		ResultSet result = select.executeQuery(aipStatsQuery);
		String mimetypeStatsQuery = "select max(mimetype_aip_statistics_id) from mimetype_aip_statistics";
		if (result.next()) {
			nextAIPStatsID = result.getInt(1) + 1;
		} else {
			throw new SQLException("Problem getting maximum AIP Statistics ID");
		}
		result = select.executeQuery(mimetypeStatsQuery);
		String insertAIPStatsEntryQuery = "insert into aip_statistics "
				+ "(aip_statistics_id, tj_aip_count, tj_aip_volume, rj_aip_count, rj_aip_volume, "
				+ "collation_date, binary_aip_count) " + "values (?, ?, ?, ?, ?, ?, ?)";
		if (result.next()) {
			nextMimetypeStatsID = result.getLong(1) + 1;
		} else {
			throw new SQLException("Problem getting maximum MIME type AIP Statistics ID");
		}
		PreparedStatement insert = dbConnection.prepareStatement(insertAIPStatsEntryQuery);
		insert.setInt(1, nextAIPStatsID);
		insert.setLong(2, transferJobAIPCount);
		insert.setLong(3, transferJobAIPVolume);
		insert.setLong(4, reprocessingJobAIPCount);
		insert.setLong(5, reprocessingJobAIPVolume);
		insert.setDate(6, new java.sql.Date(System.currentTimeMillis()));
		insert.setLong(7, overallBinaryAIPCount);
		int rowsAdded = insert.executeUpdate();
		String insertMimeTypeStatsQuery = "insert into mimetype_aip_statistics "
				+ "(mimetype_aip_statistics_id, aip_statistics_id, mimetype_aip_count, mimetype_aip_volume, mimetype) "
				+ "values (?, ?, ?, ?, ?)";
		if (rowsAdded != 1) {
			dbConnection.rollback();
			throw new SQLException("Could not insert row into AIP statistics table");
		}
		insert = dbConnection.prepareStatement(insertMimeTypeStatsQuery);
		insert.setInt(2, nextAIPStatsID);
		for (String mimeType : mimeTypeRegister.keySet()) {
			AIPStatistics mimeTypeStats = mimeTypeRegister.get(mimeType);
			insert.setLong(1, nextMimetypeStatsID);
			insert.setLong(3, mimeTypeStats.aipCount);
			insert.setLong(4, mimeTypeStats.aipVolume);
			insert.setString(5, mimeType);
			rowsAdded = insert.executeUpdate();
			nextMimetypeStatsID++;
			if (rowsAdded != 1) {
				dbConnection.rollback();
				throw new SQLException("Could not insert row into MIME Type AIP statistics table");
			}
		}
		dbConnection.commit();
	}

}