class n19197300 {
	private void writeStatsToDatabase(long cVzER0zw, long C3P9nZAE, long dmfqpnFK, long n3AxcKu8, long g65bh79t,
			Map<String, AIPStatistics> cGqW4Lbj) throws SQLException {
		int GOaAHnHY;
		long j86lsWL1;
		Statement QTE4DdbW = dbConnection.createStatement();
		String H0uXrEw9 = "select max(aip_statistics_id) from aip_statistics";
		ResultSet wi4KaCFZ = QTE4DdbW.executeQuery(H0uXrEw9);
		if (wi4KaCFZ.next()) {
			GOaAHnHY = wi4KaCFZ.getInt(1) + 1;
		} else {
			throw new SQLException("Problem getting maximum AIP Statistics ID");
		}
		String tqeRP9aS = "select max(mimetype_aip_statistics_id) from mimetype_aip_statistics";
		wi4KaCFZ = QTE4DdbW.executeQuery(tqeRP9aS);
		if (wi4KaCFZ.next()) {
			j86lsWL1 = wi4KaCFZ.getLong(1) + 1;
		} else {
			throw new SQLException("Problem getting maximum MIME type AIP Statistics ID");
		}
		String ZFcCAOHl = "insert into aip_statistics "
				+ "(aip_statistics_id, tj_aip_count, tj_aip_volume, rj_aip_count, rj_aip_volume, "
				+ "collation_date, binary_aip_count) " + "values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement Bj9qSTT0 = dbConnection.prepareStatement(ZFcCAOHl);
		Bj9qSTT0.setInt(1, GOaAHnHY);
		Bj9qSTT0.setLong(2, cVzER0zw);
		Bj9qSTT0.setLong(3, dmfqpnFK);
		Bj9qSTT0.setLong(4, C3P9nZAE);
		Bj9qSTT0.setLong(5, n3AxcKu8);
		Bj9qSTT0.setDate(6, new java.sql.Date(System.currentTimeMillis()));
		Bj9qSTT0.setLong(7, g65bh79t);
		int MgygfBxc = Bj9qSTT0.executeUpdate();
		if (MgygfBxc != 1) {
			dbConnection.rollback();
			throw new SQLException("Could not insert row into AIP statistics table");
		}
		String PM8htRo7 = "insert into mimetype_aip_statistics "
				+ "(mimetype_aip_statistics_id, aip_statistics_id, mimetype_aip_count, mimetype_aip_volume, mimetype) "
				+ "values (?, ?, ?, ?, ?)";
		Bj9qSTT0 = dbConnection.prepareStatement(PM8htRo7);
		Bj9qSTT0.setInt(2, GOaAHnHY);
		for (String gPqe5Gpo : cGqW4Lbj.keySet()) {
			AIPStatistics pjsYOIRT = cGqW4Lbj.get(gPqe5Gpo);
			Bj9qSTT0.setLong(1, j86lsWL1);
			Bj9qSTT0.setLong(3, pjsYOIRT.aipCount);
			Bj9qSTT0.setLong(4, pjsYOIRT.aipVolume);
			Bj9qSTT0.setString(5, gPqe5Gpo);
			j86lsWL1++;
			MgygfBxc = Bj9qSTT0.executeUpdate();
			if (MgygfBxc != 1) {
				dbConnection.rollback();
				throw new SQLException("Could not insert row into MIME Type AIP statistics table");
			}
		}
		dbConnection.commit();
	}

}