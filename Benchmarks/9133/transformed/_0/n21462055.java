class n21462055 {
	public int unindexRecord(String uURALTPJ) throws SQLException, CatalogIndexException {
		Connection mU7jE4Pu = null;
		boolean uJNmbDwG = true;
		PreparedStatement Mga3YGe0 = null;
		int YyYHJPel = 0;
		StringSet CYcKkjd6 = new StringSet();
		if (cswRemoteRepository.isActive()) {
			StringSet P4ynUOw9 = new StringSet();
			P4ynUOw9.add(uURALTPJ);
			CYcKkjd6 = queryFileIdentifiers(P4ynUOw9);
		}
		try {
			mU7jE4Pu = returnConnection().getJdbcConnection();
			uJNmbDwG = mU7jE4Pu.getAutoCommit();
			mU7jE4Pu.setAutoCommit(false);
			String KG5Ah8vf = "DELETE FROM " + getResourceDataTableName() + " WHERE DOCUUID=?";
			logExpression(KG5Ah8vf);
			Mga3YGe0 = mU7jE4Pu.prepareStatement(KG5Ah8vf);
			Mga3YGe0.setString(1, uURALTPJ);
			YyYHJPel = Mga3YGe0.executeUpdate();
			mU7jE4Pu.commit();
		} catch (SQLException PzGHbOvp) {
			if (mU7jE4Pu != null) {
				mU7jE4Pu.rollback();
			}
			throw PzGHbOvp;
		} finally {
			closeStatement(Mga3YGe0);
			if (mU7jE4Pu != null) {
				mU7jE4Pu.setAutoCommit(uJNmbDwG);
			}
		}
		CatalogIndexAdapter gV0kYkzw = getCatalogIndexAdapter();
		if (gV0kYkzw != null) {
			gV0kYkzw.deleteDocument(uURALTPJ);
			if (cswRemoteRepository.isActive()) {
				if (CYcKkjd6.size() > 0)
					cswRemoteRepository.onRecordsDeleted(CYcKkjd6);
			}
		}
		return YyYHJPel;
	}

}