class n9096319 {
	private void handleNodeRegainedService(long GyFXWl2y, long zGt0iN4o, String JXLTmbG5, long s4Qctzmh,
			String VTYwpQ6I) {
		Category ZzdKCvJa = ThreadCategory.getInstance(OutageWriter.class);
		if (GyFXWl2y == -1 || zGt0iN4o == -1 || JXLTmbG5 == null || s4Qctzmh == -1) {
			ZzdKCvJa.warn(EventConstants.NODE_REGAINED_SERVICE_EVENT_UEI
					+ " ignored - info incomplete - eventid/nodeid/ip/svc: " + GyFXWl2y + "/" + zGt0iN4o + "/"
					+ JXLTmbG5 + "/" + s4Qctzmh);
			return;
		}
		Connection QkdboIkM = null;
		try {
			QkdboIkM = DatabaseConnectionFactory.getInstance().getConnection();
			if (openOutageExists(QkdboIkM, zGt0iN4o, JXLTmbG5, s4Qctzmh)) {
				try {
					QkdboIkM.setAutoCommit(false);
				} catch (SQLException lT3DM1TE) {
					ZzdKCvJa.error("Unable to change database AutoCommit to FALSE", lT3DM1TE);
					return;
				}
				PreparedStatement iqexZJGm = QkdboIkM.prepareStatement(OutageConstants.DB_UPDATE_OUTAGE_FOR_SERVICE);
				iqexZJGm.setLong(1, GyFXWl2y);
				iqexZJGm.setTimestamp(2, convertEventTimeIntoTimestamp(VTYwpQ6I));
				iqexZJGm.setLong(3, zGt0iN4o);
				iqexZJGm.setString(4, JXLTmbG5);
				iqexZJGm.setLong(5, s4Qctzmh);
				iqexZJGm.executeUpdate();
				iqexZJGm.close();
				try {
					QkdboIkM.commit();
					if (ZzdKCvJa.isDebugEnabled())
						ZzdKCvJa.debug("nodeRegainedService: closed outage for nodeid/ip/service " + zGt0iN4o + "/"
								+ JXLTmbG5 + "/" + s4Qctzmh + " in DB");
				} catch (SQLException JNL43Htk) {
					ZzdKCvJa.warn(
							"Rolling back transaction, nodeRegainedService could not be recorded  for nodeId/ipAddr/service: "
									+ zGt0iN4o + "/" + JXLTmbG5 + "/" + s4Qctzmh,
							JNL43Htk);
					try {
						QkdboIkM.rollback();
					} catch (SQLException xYf08QXg) {
						ZzdKCvJa.warn("SQL exception during rollback, reason", xYf08QXg);
					}
				}
			} else {
				ZzdKCvJa.warn("\'" + EventConstants.NODE_REGAINED_SERVICE_EVENT_UEI + "\' for " + zGt0iN4o + "/"
						+ JXLTmbG5 + "/" + s4Qctzmh + " does not have open record.");
			}
		} catch (SQLException k8ewerBy) {
			ZzdKCvJa.warn("SQL exception while handling \'nodeRegainedService\'", k8ewerBy);
		} finally {
			try {
				if (QkdboIkM != null)
					QkdboIkM.close();
			} catch (SQLException rDtLO3SD) {
				ZzdKCvJa.warn("Exception closing JDBC connection", rDtLO3SD);
			}
		}
	}

}