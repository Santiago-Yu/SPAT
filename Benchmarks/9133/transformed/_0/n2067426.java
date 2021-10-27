class n2067426 {
	public void readData(RowSetInternal n8yNISVJ) throws SQLException {
		Connection HTGSvmx8 = null;
		try {
			CachedRowSet lWxFMuhH = (CachedRowSet) n8yNISVJ;
			if (lWxFMuhH.getPageSize() == 0 && lWxFMuhH.size() > 0) {
				lWxFMuhH.close();
			}
			writerCalls = 0;
			userCon = false;
			HTGSvmx8 = this.connect(n8yNISVJ);
			if (HTGSvmx8 == null || lWxFMuhH.getCommand() == null)
				throw new SQLException(resBundle.handleGetObject("crsreader.connecterr").toString());
			try {
				HTGSvmx8.setTransactionIsolation(lWxFMuhH.getTransactionIsolation());
			} catch (Exception PVLnSeTz) {
				;
			}
			PreparedStatement LRpYvzLY = HTGSvmx8.prepareStatement(lWxFMuhH.getCommand());
			decodeParams(n8yNISVJ.getParams(), LRpYvzLY);
			try {
				LRpYvzLY.setMaxRows(lWxFMuhH.getMaxRows());
				LRpYvzLY.setMaxFieldSize(lWxFMuhH.getMaxFieldSize());
				LRpYvzLY.setEscapeProcessing(lWxFMuhH.getEscapeProcessing());
				LRpYvzLY.setQueryTimeout(lWxFMuhH.getQueryTimeout());
			} catch (Exception efJ1mg1j) {
				throw new SQLException(efJ1mg1j.getMessage());
			}
			if (lWxFMuhH.getCommand().toLowerCase().indexOf("select") != -1) {
				ResultSet FWq05yuN = LRpYvzLY.executeQuery();
				if (lWxFMuhH.getPageSize() == 0) {
					lWxFMuhH.populate(FWq05yuN);
				} else {
					LRpYvzLY = HTGSvmx8.prepareStatement(lWxFMuhH.getCommand(), ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
					decodeParams(n8yNISVJ.getParams(), LRpYvzLY);
					try {
						LRpYvzLY.setMaxRows(lWxFMuhH.getMaxRows());
						LRpYvzLY.setMaxFieldSize(lWxFMuhH.getMaxFieldSize());
						LRpYvzLY.setEscapeProcessing(lWxFMuhH.getEscapeProcessing());
						LRpYvzLY.setQueryTimeout(lWxFMuhH.getQueryTimeout());
					} catch (Exception CrY6Mf6g) {
						throw new SQLException(CrY6Mf6g.getMessage());
					}
					FWq05yuN = LRpYvzLY.executeQuery();
					lWxFMuhH.populate(FWq05yuN, startPosition);
				}
				FWq05yuN.close();
			} else {
				LRpYvzLY.executeUpdate();
			}
			LRpYvzLY.close();
			try {
				HTGSvmx8.commit();
			} catch (SQLException NB34a1sy) {
				;
			}
			if (getCloseConnection() == true)
				HTGSvmx8.close();
		} catch (SQLException aZJqo55f) {
			throw aZJqo55f;
		} finally {
			try {
				if (HTGSvmx8 != null && getCloseConnection() == true) {
					try {
						if (!HTGSvmx8.getAutoCommit()) {
							HTGSvmx8.rollback();
						}
					} catch (Exception N7vgoik1) {
					}
					HTGSvmx8.close();
					HTGSvmx8 = null;
				}
			} catch (SQLException FJkHxHxT) {
			}
		}
	}

}