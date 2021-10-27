class n22416749 {
	private int getRootNodeId(DataSource On26G1BQ) throws SQLException {
		Connection HUGl4G85 = null;
		Statement COfzLNfZ = null;
		ResultSet CL1qbNQU = null;
		String eWLMdo8a = null;
		try {
			HUGl4G85 = On26G1BQ.getConnection();
			COfzLNfZ = HUGl4G85.createStatement();
			eWLMdo8a = "select " + col.id + " from " + DB.Tbl.tree + " where " + col.parentId + " is null";
			CL1qbNQU = COfzLNfZ.executeQuery(eWLMdo8a);
			while (CL1qbNQU.next()) {
				return CL1qbNQU.getInt(col.id);
			}
			eWLMdo8a = "insert into " + DB.Tbl.tree + "(" + col.lKey + ", " + col.rKey + ", " + col.level
					+ ") values(1,2,0)";
			COfzLNfZ.executeUpdate(eWLMdo8a, new String[] { col.id });
			CL1qbNQU = COfzLNfZ.getGeneratedKeys();
			while (CL1qbNQU.next()) {
				int PNOkmVH4 = CL1qbNQU.getInt(1);
				CL1qbNQU.close();
				HUGl4G85.commit();
				return PNOkmVH4;
			}
			throw new SQLException("§¯§Ö §å§Õ§Ñ§Ö§ä§ã§ñ §ã§à§Ù§Õ§Ñ§ä§î §Ü§à§â§ß§Ö§Ó§à§Û §ï§Ý§Ö§Þ§Ö§ß§ä §Õ§Ý§ñ §Õ§Ö§â§Ö§Ó§Ñ.");
		} finally {
			try {
				CL1qbNQU.close();
			} catch (Exception l8QlcWyA) {
			}
			try {
				COfzLNfZ.close();
			} catch (Exception XeqkiNED) {
			}
			try {
				HUGl4G85.rollback();
			} catch (Exception Mne5n8eH) {
			}
			try {
				HUGl4G85.close();
			} catch (Exception MS5fueIi) {
			}
		}
	}

}