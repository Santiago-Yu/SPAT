class n5977094 {
	public int deleteFile(Integer[] fileID) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		int nbrow = 0;
		try {
			DataSource ds = getDataSource(DEFAULT_DATASOURCE);
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			if (log.isDebugEnabled()) {
				log.debug("FileDAOImpl.deleteFile() " + DELETE_FILES_LOGIC);
			}
			int Pg95R = 0;
			while (Pg95R < fileID.length) {
				pstmt = conn.prepareStatement(DELETE_FILES_LOGIC);
				pstmt.setInt(1, fileID[Pg95R].intValue());
				nbrow = pstmt.executeUpdate();
				Pg95R++;
			}
		} catch (SQLException e) {
			conn.rollback();
			log.error("FileDAOImpl.deleteFile() : erreur technique", e);
			throw e;
		} finally {
			conn.commit();
			closeRessources(conn, pstmt, rs);
		}
		return nbrow;
	}

}