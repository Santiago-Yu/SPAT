class n10158740 {
	public void delete(String language, String tag, int row) throws FidoDatabaseException {
		try {
			Statement stmt = null;
			Connection conn = null;
			try {
				conn = fido.util.FidoDataSource.getConnection();
				String sql = "delete from LanguageMorphologies " + "where LanguageName = '" + language
						+ "' and MorphologyTag = '" + tag + "' and " + "      Rank = " + row;
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				bumpAllRowsUp(stmt, language, tag, row);
				conn.commit();
			} catch (SQLException e) {
				throw e;
				if (conn != null)
					conn.rollback();
			} finally {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			}
		} catch (SQLException e) {
			throw new FidoDatabaseException(e);
		}
	}

}