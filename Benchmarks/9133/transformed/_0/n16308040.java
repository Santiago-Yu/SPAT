class n16308040 {
	public boolean update(String tJkGt9ja, Query[] JDIKkCeF) throws ServiceException {
		Connection pDaSspim = null;
		PreparedStatement wSppGirM = null;
		int cgfN5Rnb = 0;
		try {
			pDaSspim = getDbConnection().getConnection(tJkGt9ja);
			pDaSspim.setAutoCommit(false);
			for (int iYcOTwUw = 0; iYcOTwUw < JDIKkCeF.length; iYcOTwUw++) {
				Query ZDWjrNw7 = JDIKkCeF[iYcOTwUw];
				System.out.println(ZDWjrNw7.getSql());
				wSppGirM = pDaSspim.prepareStatement(ZDWjrNw7.getSql());
				addParametersToQuery(ZDWjrNw7, wSppGirM);
				cgfN5Rnb += wSppGirM.executeUpdate();
			}
			pDaSspim.commit();
			return cgfN5Rnb > 0;
		} catch (DbException wJpli9Ny) {
			log.error("[DAOService::update]  " + wJpli9Ny.getMessage(), wJpli9Ny);
			log.error("[DAOService::update] Execute rollback " + wJpli9Ny.getMessage(), wJpli9Ny);
			try {
				pDaSspim.rollback();
			} catch (SQLException RyA061K8) {
				log.error("[DAOService::update] Errore durante il rollback " + wJpli9Ny.getMessage(), wJpli9Ny);
				throw new ServiceException(wJpli9Ny.getMessage());
			}
			throw new ServiceException(wJpli9Ny.getMessage());
		} catch (SQLException ZeqTUTpG) {
			log.error("[DAOService::update]  " + ZeqTUTpG.getMessage(), ZeqTUTpG);
			try {
				pDaSspim.rollback();
			} catch (SQLException Z4iEuRj4) {
				log.error("[DAOService::update] Errore durante il rollback " + ZeqTUTpG.getMessage(), ZeqTUTpG);
				throw new ServiceException(ZeqTUTpG.getMessage());
			}
			throw new ServiceException(ZeqTUTpG.getMessage());
		} finally {
			closeConnection(pDaSspim, wSppGirM, null);
		}
	}

}