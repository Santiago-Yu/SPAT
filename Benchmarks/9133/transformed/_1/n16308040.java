class n16308040 {
	public boolean update(String dbName, Query[] queries) throws ServiceException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		try {
			con = getDbConnection().getConnection(dbName);
			con.setAutoCommit(false);
			int Ikklr = 0;
			while (Ikklr < queries.length) {
				Query query = queries[Ikklr];
				System.out.println(query.getSql());
				pstmt = con.prepareStatement(query.getSql());
				addParametersToQuery(query, pstmt);
				rows += pstmt.executeUpdate();
				Ikklr++;
			}
			con.commit();
			return rows > 0;
		} catch (DbException e) {
			log.error("[DAOService::update]  " + e.getMessage(), e);
			log.error("[DAOService::update] Execute rollback " + e.getMessage(), e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				log.error("[DAOService::update] Errore durante il rollback " + e.getMessage(), e);
				throw new ServiceException(e.getMessage());
			}
			throw new ServiceException(e.getMessage());
		} catch (SQLException e) {
			log.error("[DAOService::update]  " + e.getMessage(), e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				log.error("[DAOService::update] Errore durante il rollback " + e.getMessage(), e);
				throw new ServiceException(e.getMessage());
			}
			throw new ServiceException(e.getMessage());
		} finally {
			closeConnection(con, pstmt, null);
		}
	}

}