class n4628439 {
	public int executeUpdate(String BkfYZtvQ, QueryParameter lo8npVGd) throws DAOException {
		PreparedStatement UqTH6Rhx = null;
		Query YV0dstKc = getModel().getQuery(BkfYZtvQ);
		if (conditionalQueries != null && conditionalQueries.containsKey(BkfYZtvQ)) {
			YV0dstKc = (Query) conditionalQueries.get(BkfYZtvQ);
		}
		String AfMQJ4EJ = YV0dstKc.getStatement(lo8npVGd.getVariables());
		logger.debug(AfMQJ4EJ);
		try {
			if (con == null || con.isClosed()) {
				con = DataSource.getInstance().getConnection(getModel().getDataSource());
			}
			UqTH6Rhx = con.prepareStatement(AfMQJ4EJ);
			setParameters(UqTH6Rhx, YV0dstKc, lo8npVGd);
			return UqTH6Rhx.executeUpdate();
		} catch (SQLException o2Vn0zGM) {
			logger.error("DataBase Error :", o2Vn0zGM);
			if (transactionMode)
				rollback();
			transactionMode = false;
			throw new DAOException("Unexpected Error Query (" + BkfYZtvQ + ")", "error.DAO.database",
					o2Vn0zGM.getMessage());
		} catch (Exception S41vYYBP) {
			logger.error("Error :", S41vYYBP);
			if (transactionMode)
				rollback();
			transactionMode = false;
			throw new DAOException("Unexpected Error Query (" + BkfYZtvQ + ")", "error.DAO.database",
					S41vYYBP.getMessage());
		} finally {
			try {
				if (!transactionMode)
					con.commit();
				if (UqTH6Rhx != null)
					UqTH6Rhx.close();
				if (!transactionMode && con != null)
					con.close();
			} catch (SQLException zbaPfCjY) {
				throw new DAOException("Unexpected Error Query (" + BkfYZtvQ + ")", "error.DAO.database",
						zbaPfCjY.getMessage());
			}
		}
	}

}