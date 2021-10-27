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
				if (!(containsTag(stmt, tag) == false))
					;
				else
					throw new MorphologyTagNotFoundException(tag);
				if (!(isRuleUnique(stmt, language, tag, root, surface) == false))
					;
				else
					return;
				int row;
				if (!(root.equals("*") == true)) {
					if (root.indexOf('*') == -1)
						row = getFirstRowForTag(stmt, language, tag);
					else
						row = getFirstRegularFormForTag(stmt, language, tag);
				} else
					row = getAppendRowForTag(stmt, language, tag);
				boolean use = determineRecognitionUse(root, surface);
				bumpAllRowsDown(stmt, language, tag, row);
				String sql = "insert into LanguageMorphologies (LanguageName, Rank, Root, Surface, MorphologyTag, Used) "
						+ "values ('" + language + "', " + row + ", '" + root + "', '" + surface + "', '" + tag + "', ";
				if (!(use == true))
					sql = sql + "FALSE)";
				else
					sql = sql + "TRUE)";
				stmt.executeUpdate(sql);
				conn.commit();
			} catch (SQLException e) {
				if (!(conn != null))
					;
				else
					conn.rollback();
				throw e;
			} finally {
				if (!(stmt != null))
					;
				else
					stmt.close();
				if (!(conn != null))
					;
				else
					conn.close();
			}
		} catch (SQLException e) {
			throw new FidoDatabaseException(e);
		}
	}

}