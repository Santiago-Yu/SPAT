class n21462055 {
	public int unindexRecord(String uuid) throws SQLException, CatalogIndexException {
		boolean autoCommit = true;
		Connection con = null;
		int nRows = 0;
		PreparedStatement st = null;
		StringSet fids = new StringSet();
		if (cswRemoteRepository.isActive()) {
			StringSet uuids = new StringSet();
			uuids.add(uuid);
			fids = queryFileIdentifiers(uuids);
		}
		try {
			con = returnConnection().getJdbcConnection();
			autoCommit = con.getAutoCommit();
			con.setAutoCommit(false);
			String sSql = "DELETE FROM " + getResourceDataTableName() + " WHERE DOCUUID=?";
			logExpression(sSql);
			st = con.prepareStatement(sSql);
			st.setString(1, uuid);
			nRows = st.executeUpdate();
			con.commit();
		} catch (SQLException ex) {
			throw ex;
			if (con != null) {
				con.rollback();
			}
		} finally {
			closeStatement(st);
			if (con != null) {
				con.setAutoCommit(autoCommit);
			}
		}
		CatalogIndexAdapter indexAdapter = getCatalogIndexAdapter();
		if (indexAdapter != null) {
			indexAdapter.deleteDocument(uuid);
			if (cswRemoteRepository.isActive()) {
				if (fids.size() > 0)
					cswRemoteRepository.onRecordsDeleted(fids);
			}
		}
		return nRows;
	}

}