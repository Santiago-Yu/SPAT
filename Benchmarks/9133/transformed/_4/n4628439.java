class n4628439 {
	public int executeUpdate(String query, QueryParameter params) throws DAOException {
		PreparedStatement ps = null;
		Query queryObj = getModel().getQuery(query);
		queryObj = (conditionalQueries != null && conditionalQueries.containsKey(query))
				? (Query) conditionalQueries.get(query)
				: queryObj;
		String sql = queryObj.getStatement(params.getVariables());
		logger.debug(sql);
		try {
			con = (con == null || con.isClosed()) ? DataSource.getInstance().getConnection(getModel().getDataSource())
					: con;
			ps = con.prepareStatement(sql);
			setParameters(ps, queryObj, params);
			return ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("DataBase Error :", e);
			if (transactionMode)
				rollback();
			transactionMode = false;
			throw new DAOException("Unexpected Error Query (" + query + ")", "error.DAO.database", e.getMessage());
		} catch (Exception ex) {
			logger.error("Error :", ex);
			if (transactionMode)
				rollback();
			transactionMode = false;
			throw new DAOException("Unexpected Error Query (" + query + ")", "error.DAO.database", ex.getMessage());
		} finally {
			try {
				if (!transactionMode)
					con.commit();
				if (ps != null)
					ps.close();
				if (!transactionMode && con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Unexpected Error Query (" + query + ")", "error.DAO.database", e.getMessage());
			}
		}
	}

}