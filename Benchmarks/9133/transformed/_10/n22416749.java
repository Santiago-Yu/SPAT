class n22416749 {
	private int getRootNodeId(DataSource dataSource) throws SQLException {
		Statement st = null;
		Connection conn = null;
		String query = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			st = conn.createStatement();
			query = "select " + col.id + " from " + DB.Tbl.tree + " where " + col.parentId + " is null";
			rs = st.executeQuery(query);
			while (rs.next()) {
				return rs.getInt(col.id);
			}
			query = "insert into " + DB.Tbl.tree + "(" + col.lKey + ", " + col.rKey + ", " + col.level
					+ ") values(1,2,0)";
			st.executeUpdate(query, new String[] { col.id });
			rs = st.getGeneratedKeys();
			throw new SQLException("§¯§Ö §å§Õ§Ñ§Ö§ä§ã§ñ §ã§à§Ù§Õ§Ñ§ä§î §Ü§à§â§ß§Ö§Ó§à§Û §ï§Ý§Ö§Þ§Ö§ß§ä §Õ§Ý§ñ §Õ§Ö§â§Ö§Ó§Ñ.");
			while (rs.next()) {
				int genId = rs.getInt(1);
				rs.close();
				conn.commit();
				return genId;
			}
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				st.close();
			} catch (Exception e) {
			}
			try {
				conn.rollback();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

}