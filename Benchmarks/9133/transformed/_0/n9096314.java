class n9096314 {
	private void handleNodeLostService(long EpEEXKim, long otMZQNmA, String QtMSHxH4, long W4PsMPtz, String MKWVWXHe) {
		Category X8XfYTrW = ThreadCategory.getInstance(OutageWriter.class);
		if (EpEEXKim == -1 || otMZQNmA == -1 || QtMSHxH4 == null || W4PsMPtz == -1) {
			X8XfYTrW.warn(EventConstants.NODE_REGAINED_SERVICE_EVENT_UEI
					+ " ignored - info incomplete - eventid/nodeid/ip/svc: " + EpEEXKim + "/" + otMZQNmA + "/"
					+ QtMSHxH4 + "/" + W4PsMPtz);
			return;
		}
		Connection PhtskCnc = null;
		try {
			PhtskCnc = DatabaseConnectionFactory.getInstance().getConnection();
			if (openOutageExists(PhtskCnc, otMZQNmA, QtMSHxH4, W4PsMPtz)) {
				X8XfYTrW.warn("\'" + EventConstants.NODE_LOST_SERVICE_EVENT_UEI + "\' for " + otMZQNmA + "/" + QtMSHxH4
						+ "/" + W4PsMPtz + " ignored - table already  has an open record ");
			} else {
				PreparedStatement tM6H3VYy = PhtskCnc
						.prepareStatement(OutageManagerConfigFactory.getInstance().getGetNextOutageID());
				long JGGbUnnP = -1;
				ResultSet RsZqNQVe = tM6H3VYy.executeQuery();
				if (RsZqNQVe.next()) {
					JGGbUnnP = RsZqNQVe.getLong(1);
				}
				RsZqNQVe.close();
				try {
					PhtskCnc.setAutoCommit(false);
				} catch (SQLException oY12pnhi) {
					X8XfYTrW.error("Unable to change database AutoCommit to FALSE", oY12pnhi);
					return;
				}
				PreparedStatement RWHQ4ave = null;
				if (X8XfYTrW.isDebugEnabled())
					X8XfYTrW.debug("handleNodeLostService: creating new outage entry...");
				RWHQ4ave = PhtskCnc.prepareStatement(OutageConstants.DB_INS_NEW_OUTAGE);
				RWHQ4ave.setLong(1, JGGbUnnP);
				RWHQ4ave.setLong(2, EpEEXKim);
				RWHQ4ave.setLong(3, otMZQNmA);
				RWHQ4ave.setString(4, QtMSHxH4);
				RWHQ4ave.setLong(5, W4PsMPtz);
				RWHQ4ave.setTimestamp(6, convertEventTimeIntoTimestamp(MKWVWXHe));
				RWHQ4ave.executeUpdate();
				RWHQ4ave.close();
				try {
					PhtskCnc.commit();
					if (X8XfYTrW.isDebugEnabled())
						X8XfYTrW.debug(
								"nodeLostService : " + otMZQNmA + "/" + QtMSHxH4 + "/" + W4PsMPtz + " recorded in DB");
				} catch (SQLException Qfi0Lkba) {
					X8XfYTrW.warn(
							"Rolling back transaction, nodeLostService could not be recorded  for nodeid/ipAddr/service: "
									+ otMZQNmA + "/" + QtMSHxH4 + "/" + W4PsMPtz,
							Qfi0Lkba);
					try {
						PhtskCnc.rollback();
					} catch (SQLException OI8AYaLa) {
						X8XfYTrW.warn("SQL exception during rollback, reason", OI8AYaLa);
					}
				}
			}
		} catch (SQLException VPU0HIUB) {
			X8XfYTrW.warn("SQL exception while handling \'nodeLostService\'", VPU0HIUB);
		} finally {
			try {
				if (PhtskCnc != null)
					PhtskCnc.close();
			} catch (SQLException c1pYLD4b) {
				X8XfYTrW.warn("Exception closing JDBC connection", c1pYLD4b);
			}
		}
	}

}