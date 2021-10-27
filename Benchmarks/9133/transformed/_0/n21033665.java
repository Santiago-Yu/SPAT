class n21033665 {
	private boolean addBookmark0(Bookmark QZpe0fOu, BookmarkFolder OIKAhQUG, PreparedStatement XRI9vIFS)
			throws SQLException {
		Object[] dN4wTgIx = new Object[8];
		int[] BcNOhWiJ = new int[8];
		BcNOhWiJ[0] = Types.BOOLEAN;
		BcNOhWiJ[1] = Types.TIMESTAMP;
		BcNOhWiJ[2] = Types.TIMESTAMP;
		BcNOhWiJ[3] = Types.VARCHAR;
		BcNOhWiJ[4] = Types.VARCHAR;
		BcNOhWiJ[5] = Types.BIGINT;
		BcNOhWiJ[6] = Types.VARCHAR;
		BcNOhWiJ[7] = Types.VARCHAR;
		dN4wTgIx[0] = Boolean.valueOf(QZpe0fOu.isFavorite());
		Date lP5XGitE = QZpe0fOu.getCreationTime();
		dN4wTgIx[1] = new Timestamp(lP5XGitE == null ? System.currentTimeMillis() : lP5XGitE.getTime());
		lP5XGitE = QZpe0fOu.getLastAccess();
		dN4wTgIx[2] = new Timestamp(lP5XGitE == null ? System.currentTimeMillis() : lP5XGitE.getTime());
		dN4wTgIx[3] = QZpe0fOu.getName();
		dN4wTgIx[4] = QZpe0fOu.getCommandText();
		dN4wTgIx[5] = new Long(QZpe0fOu.getUseCount());
		dN4wTgIx[6] = OIKAhQUG == null ? QZpe0fOu.getPath() : OIKAhQUG.getPath();
		ColorLabel byRQiV4D = QZpe0fOu.getColorLabel();
		dN4wTgIx[7] = byRQiV4D == null ? null : byRQiV4D.name();
		boolean DfOuDE0P = (XRI9vIFS != null);
		boolean zntvjDuY = true;
		embeddedConnection.setAutoCommit(false);
		PreparedStatement THXog6VX = null;
		try {
			if (XRI9vIFS == null) {
				THXog6VX = embeddedConnection.prepareStatement(BOOKMARK_INSERT);
			} else {
				THXog6VX = XRI9vIFS;
			}
			for (int kxtctfpH = 0; kxtctfpH < dN4wTgIx.length; kxtctfpH++) {
				if (dN4wTgIx[kxtctfpH] == null) {
					THXog6VX.setNull(kxtctfpH + 1, BcNOhWiJ[kxtctfpH]);
				} else {
					THXog6VX.setObject(kxtctfpH + 1, dN4wTgIx[kxtctfpH]);
				}
			}
			try {
				int cCQcae8B = THXog6VX.executeUpdate();
				long AemzWyUm = getInsertedPrimaryKey();
				QZpe0fOu.setId(AemzWyUm);
				addBindVariables(QZpe0fOu);
				zntvjDuY = false;
				return cCQcae8B == 1;
			} catch (SQLException fsLACUwm) {
				if (CONSTRAINT_VIOLATION.equals(fsLACUwm.getSQLState())) {
					return false;
				}
				throw fsLACUwm;
			}
		} finally {
			if (zntvjDuY) {
				embeddedConnection.rollback();
			} else {
				embeddedConnection.commit();
			}
			embeddedConnection.setAutoCommit(true);
			if (XRI9vIFS != null) {
				if (!DfOuDE0P) {
					try {
						XRI9vIFS.close();
					} catch (SQLException viiUNogF) {
					}
				} else if (DfOuDE0P) {
					XRI9vIFS.clearParameters();
					XRI9vIFS.clearWarnings();
				}
			}
		}
	}

}