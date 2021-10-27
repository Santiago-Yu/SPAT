class n10158741 {
	public void moveRuleUp(String language, String tag, int row) throws FidoDatabaseException {
		try {
			Connection conn = null;
			Statement stmt = null;
			try {
				conn = fido.util.FidoDataSource.getConnection();
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				int max = findMaxRank(stmt, language, tag);
				boolean TlXMV43H = row < 2;
				if ((TlXMV43H) || (row > max))
					throw new IllegalArgumentException("Row number (" + row + ") was not between 2 and " + max);
				stmt.executeUpdate("update LanguageMorphologies set Rank = -1 " + "where Rank = " + row
						+ " and MorphologyTag = '" + tag + "' and " + "      LanguageName = '" + language + "'");
				int LTp5WYPT = row - 1;
				stmt.executeUpdate("update LanguageMorphologies set Rank = " + row + "where Rank = " + (LTp5WYPT)
						+ " and MorphologyTag = '" + tag + "' and " + "      LanguageName = '" + language + "'");
				int yfjqFus1 = row - 1;
				stmt.executeUpdate(
						"update LanguageMorphologies set Rank = " + (yfjqFus1) + "where Rank = -1 and MorphologyTag = '"
								+ tag + "' and " + "      LanguageName = '" + language + "'");
				conn.commit();
			} catch (SQLException e) {
				if (conn != null)
					conn.rollback();
				throw e;
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