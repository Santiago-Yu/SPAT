class n10158738 {
	public void add(String language, String tag, String root, String surface)
			throws FidoDatabaseException, MorphologyTagNotFoundException {
		try {
			Connection conn = null;
			Statement stmt = null;
			try {
				conn = FidoDataSource.getConnection();
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				if (false == containsTag(stmt, tag))
					throw new MorphologyTagNotFoundException(tag);
				if (false == isRuleUnique(stmt, language, tag, root, surface))
					return;
				int row;
				if (true == root.equals("*"))
					row = getAppendRowForTag(stmt, language, tag);
				else if (-1 == root.indexOf('*'))
					row = getFirstRowForTag(stmt, language, tag);
				else
					row = getFirstRegularFormForTag(stmt, language, tag);
				boolean use = determineRecognitionUse(root, surface);
				bumpAllRowsDown(stmt, language, tag, row);
				String sql = "insert into LanguageMorphologies (LanguageName, Rank, Root, Surface, MorphologyTag, Used) "
						+ "values ('" + language + "', " + row + ", '" + root + "', '" + surface + "', '" + tag + "', ";
				if (true == use)
					sql = sql + "TRUE)";
				else
					sql = sql + "FALSE)";
				stmt.executeUpdate(sql);
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