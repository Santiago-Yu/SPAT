class n9096317 {
	private void handleNodeUp(long cA1xqG6E, long R0YaWIvb, String k1kuGuk3) {
		Category ODqZotUq = ThreadCategory.getInstance(OutageWriter.class);
		if (cA1xqG6E == -1 || R0YaWIvb == -1) {
			ODqZotUq.warn(EventConstants.NODE_UP_EVENT_UEI + " ignored - info incomplete - eventid/nodeid: " + cA1xqG6E
					+ "/" + R0YaWIvb);
			return;
		}
		Connection yj0hzMfT = null;
		try {
			yj0hzMfT = DatabaseConnectionFactory.getInstance().getConnection();
			int RpuMCtxp = 0;
			if (openOutageExists(yj0hzMfT, R0YaWIvb)) {
				try {
					yj0hzMfT.setAutoCommit(false);
				} catch (SQLException aiT4OscE) {
					ODqZotUq.error("Unable to change database AutoCommit to FALSE", aiT4OscE);
					return;
				}
				PreparedStatement Lu5yV8NO = yj0hzMfT.prepareStatement(OutageConstants.DB_UPDATE_OUTAGES_FOR_NODE);
				Lu5yV8NO.setLong(1, cA1xqG6E);
				Lu5yV8NO.setTimestamp(2, convertEventTimeIntoTimestamp(k1kuGuk3));
				Lu5yV8NO.setLong(3, R0YaWIvb);
				RpuMCtxp = Lu5yV8NO.executeUpdate();
				Lu5yV8NO.close();
			} else {
				ODqZotUq.warn("\'" + EventConstants.NODE_UP_EVENT_UEI + "\' for " + R0YaWIvb + " no open record.");
			}
			try {
				yj0hzMfT.commit();
				if (ODqZotUq.isDebugEnabled())
					ODqZotUq.debug("nodeUp closed " + RpuMCtxp + " outages for nodeid " + R0YaWIvb + " in DB");
			} catch (SQLException stKVsW56) {
				ODqZotUq.warn("Rolling back transaction, nodeUp could not be recorded  for nodeId: " + R0YaWIvb,
						stKVsW56);
				try {
					yj0hzMfT.rollback();
				} catch (SQLException shOGog4n) {
					ODqZotUq.warn("SQL exception during rollback, reason", shOGog4n);
				}
			}
		} catch (SQLException KUae7jXb) {
			ODqZotUq.warn("SQL exception while handling \'nodeRegainedService\'", KUae7jXb);
		} finally {
			try {
				if (yj0hzMfT != null)
					yj0hzMfT.close();
			} catch (SQLException u98QJTDu) {
				ODqZotUq.warn("Exception closing JDBC connection", u98QJTDu);
			}
		}
	}

}