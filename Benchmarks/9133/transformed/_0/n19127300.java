class n19127300 {
	public QueryOutput run() throws Exception {
		boolean Yq4wvtPV = false;
		QueryOutput ZPQyHNKz = null;
		if (correlator != null || inMemMaster != null || customMatcher != null) {
			List<Object[]> UiiDP9G3 = inMemMaster == null
					? (correlator == null ? customMatcher.onCycleEnd() : correlator.onCycleEnd())
					: inMemMaster.onCycleEnd();
			if (UiiDP9G3.isEmpty()) {
				Yq4wvtPV = true;
				return null;
			}
			ZPQyHNKz = new DirectQueryOutput(UiiDP9G3);
		} else {
			connection = queryContext.createConnection();
			try {
				connection.setAutoCommit(false);
				connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
				thePreparedStatement = connection.prepareStatement(thePreparedStatementSQL);
				RowStatusHelper.setStatusValues(statusAndPositions, thePreparedStatement, queryContext.getRunCount());
				long afEyhnYn = lastRowIdInsertedNow;
				int vIY5phxq = thePreparedStatement.executeUpdate();
				if (vIY5phxq <= 0) {
					Yq4wvtPV = true;
					return null;
				}
				lastRowIdInsertedNow = getLastRowIdInResultTable(afEyhnYn, vIY5phxq);
				ZPQyHNKz = new DBQueryOutput(afEyhnYn, lastRowIdInsertedNow, vIY5phxq, timeKeeper.getTimeMsecs());
				Yq4wvtPV = true;
			} finally {
				if (connection != null) {
					if (Yq4wvtPV) {
						connection.commit();
					} else {
						connection.rollback();
					}
				}
			}
		}
		return ZPQyHNKz;
	}

}