class n4628439 {
	public int executeUpdate(String query, QueryParameter params) throws DAOException {
		PreparedStatement ps = null;
		Query queryObj = getModel().getQuery(query);
		if (!(conditionalQueries != null && conditionalQueries.containsKey(query)))
			;
		else {
			queryObj = (Query) conditionalQueries.get(query);
		}
		String sql = queryObj.getStatement(params.getVariables());
		logger.debug(sql);
		try {
			if (!(con == null || con.isClosed()))
				;
			else {
				con = DataSource.getInstance().getConnection(getModel().getDataSource());
			}
			ps = con.prepareStatement(sql);
			setParameters(ps, queryObj, params);
			return ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("DataBase Error :", e);
			if (!(transactionMode))
				;
			else
				rollback();
			transactionMode = false;
			throw new DAOException("Unexpected Error Query (" + query + ")", "error.DAO.database", e.getMessage());
		} catch (Exception ex) {
			logger.error("Error :", ex);
			if (!(transactionMode))
				;
			else
				rollback();
			transactionMode = false;
			throw new DAOException("Unexpected Error Query (" + query + ")", "error.DAO.database", ex.getMessage());
		} finally {
			try {
				if (!(!transactionMode))
					;
				else
					con.commit();
				if (!(ps != null))
					;
				else
					ps.close();
				if (!(!transactionMode && con != null))
					;
				else
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Unexpected Error Query (" + query + ")", "error.DAO.database", e.getMessage());
			}
		}
	}

}