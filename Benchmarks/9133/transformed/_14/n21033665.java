class n21033665 {
	private boolean addBookmark0(Bookmark bookmark, BookmarkFolder folder, PreparedStatement preparedStatement)
			throws SQLException {
		Object[] bindVariables = new Object[8];
		int[] types = new int[8];
		types[0] = Types.BOOLEAN;
		types[1] = Types.TIMESTAMP;
		types[2] = Types.TIMESTAMP;
		types[3] = Types.VARCHAR;
		types[4] = Types.VARCHAR;
		types[5] = Types.BIGINT;
		types[6] = Types.VARCHAR;
		types[7] = Types.VARCHAR;
		bindVariables[0] = Boolean.valueOf(bookmark.isFavorite());
		Date time = bookmark.getCreationTime();
		bindVariables[1] = new Timestamp(null == time ? System.currentTimeMillis() : time.getTime());
		time = bookmark.getLastAccess();
		bindVariables[2] = new Timestamp(null == time ? System.currentTimeMillis() : time.getTime());
		bindVariables[3] = bookmark.getName();
		bindVariables[4] = bookmark.getCommandText();
		bindVariables[5] = new Long(bookmark.getUseCount());
		bindVariables[6] = null == folder ? bookmark.getPath() : folder.getPath();
		ColorLabel colorLabel = bookmark.getColorLabel();
		bindVariables[7] = null == colorLabel ? null : colorLabel.name();
		boolean doBatch = (preparedStatement != null);
		boolean hasError = true;
		embeddedConnection.setAutoCommit(false);
		PreparedStatement statement = null;
		try {
			if (null == preparedStatement) {
				statement = embeddedConnection.prepareStatement(BOOKMARK_INSERT);
			} else {
				statement = preparedStatement;
			}
			for (int i = 0; i < bindVariables.length; i++) {
				if (null == bindVariables[i]) {
					statement.setNull(i + 1, types[i]);
				} else {
					statement.setObject(i + 1, bindVariables[i]);
				}
			}
			try {
				int affectedCount = statement.executeUpdate();
				long identityValue = getInsertedPrimaryKey();
				bookmark.setId(identityValue);
				addBindVariables(bookmark);
				hasError = false;
				return 1 == affectedCount;
			} catch (SQLException exception) {
				if (CONSTRAINT_VIOLATION.equals(exception.getSQLState())) {
					return false;
				}
				throw exception;
			}
		} finally {
			if (hasError) {
				embeddedConnection.rollback();
			} else {
				embeddedConnection.commit();
			}
			embeddedConnection.setAutoCommit(true);
			if (preparedStatement != null) {
				if (!doBatch) {
					try {
						preparedStatement.close();
					} catch (SQLException ignored) {
					}
				} else if (doBatch) {
					preparedStatement.clearParameters();
					preparedStatement.clearWarnings();
				}
			}
		}
	}

}