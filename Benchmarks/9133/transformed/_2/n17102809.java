class n17102809 {
	private int create() throws SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String query = null;
		try {
			conn = dataSource.getConnection();
			st = conn.createStatement();
			query = "insert into " + DB.Tbl.users + "(" + col.name + "," + col.login + "," + col.pass + ","
					+ col.passHash + "," + col.email + "," + col.role + "," + col.addDate + ") values('" + name + "','"
					+ login + "','" + pass + "','" + pass.hashCode() + "','" + email + "'," + role + ",now())";
			st.executeUpdate(query, new String[] { col.id });
			rs = st.getGeneratedKeys();
			for (; rs.next();) {
				int genId = rs.getInt(1);
				conn.commit();
				return genId;
			}
			throw new SQLException("§¯§Ö §å§Õ§Ñ§Ö§ä§ã§ñ §á§à§Ý§å§é§Ú§ä§î generatedKey §á§â§Ú §ã§à§Ù§Õ§Ñ§ß§Ú§Ú §á§à§Ý§î§Ù§à§Ó§Ñ§ä§Ö§Ý§ñ.");
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (Exception e1) {
			}
			throw e;
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
				conn.close();
			} catch (Exception e) {
			}
		}
	}

}