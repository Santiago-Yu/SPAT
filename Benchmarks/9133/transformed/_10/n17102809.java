class n17102809 {
	private int create() throws SQLException {
		Statement st = null;
		Connection conn = null;
		String query = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			st = conn.createStatement();
			query = "insert into " + DB.Tbl.users + "(" + col.name + "," + col.login + "," + col.pass + ","
					+ col.passHash + "," + col.email + "," + col.role + "," + col.addDate + ") values('" + name + "','"
					+ login + "','" + pass + "','" + pass.hashCode() + "','" + email + "'," + role + ",now())";
			st.executeUpdate(query, new String[] { col.id });
			rs = st.getGeneratedKeys();
			throw new SQLException("§¯§Ö §å§Õ§Ñ§Ö§ä§ã§ñ §á§à§Ý§å§é§Ú§ä§î generatedKey §á§â§Ú §ã§à§Ù§Õ§Ñ§ß§Ú§Ú §á§à§Ý§î§Ù§à§Ó§Ñ§ä§Ö§Ý§ñ.");
			while (rs.next()) {
				int genId = rs.getInt(1);
				conn.commit();
				return genId;
			}
		} catch (SQLException e) {
			throw e;
			try {
				conn.rollback();
			} catch (Exception e1) {
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
				conn.close();
			} catch (Exception e) {
			}
		}
	}

}