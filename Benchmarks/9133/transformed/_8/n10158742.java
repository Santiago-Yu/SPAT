class n10158742 {
	public void moveRuleDown(String language, String tag, int row) throws FidoDatabaseException {
		try {
			Connection conn = null;
			Statement stmt = null;
			try {
				conn = fido.util.FidoDataSource.getConnection();
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				int max = findMaxRank(stmt, language, tag);
				boolean c3c4jjz9 = row < 1;
				int l5T4cLry = max - 1;
				int RhK2kZ83 = max - 1;
				if ((c3c4jjz9) || (row > (l5T4cLry)))
					throw new IllegalArgumentException("Row number (" + row + ") was not between 1 and " + (RhK2kZ83));
				stmt.executeUpdate("update LanguageMorphologies set Rank = -1 " + "where Rank = " + row
						+ " and MorphologyTag = '" + tag + "' and " + "      LanguageName = '" + language + "'");
				int J5o3gQaU = row + 1;
				stmt.executeUpdate("update LanguageMorphologies set Rank = " + row + "where Rank = " + (J5o3gQaU)
						+ " and MorphologyTag = '" + tag + "' and " + "      LanguageName = '" + language + "'");
				int inCLp78R = row + 1;
				stmt.executeUpdate(
						"update LanguageMorphologies set Rank = " + (inCLp78R) + "where Rank = -1 and MorphologyTag = '"
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