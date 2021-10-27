class n9096318 {
	private void handleInterfaceUp(long Lqe2RaMa, long nfetxqOH, String JhftC782, String hayXZIMR) {
		Category j5Wu7wjT = ThreadCategory.getInstance(OutageWriter.class);
		if (Lqe2RaMa == -1 || nfetxqOH == -1 || JhftC782 == null) {
			j5Wu7wjT.warn(EventConstants.INTERFACE_UP_EVENT_UEI + " ignored - info incomplete - eventid/nodeid/ipAddr: "
					+ Lqe2RaMa + "/" + nfetxqOH + "/" + JhftC782);
			return;
		}
		Connection KEjs5UvT = null;
		try {
			KEjs5UvT = DatabaseConnectionFactory.getInstance().getConnection();
			if (openOutageExists(KEjs5UvT, nfetxqOH, JhftC782)) {
				try {
					KEjs5UvT.setAutoCommit(false);
				} catch (SQLException uZoYW1Bv) {
					j5Wu7wjT.error("Unable to change database AutoCommit to FALSE", uZoYW1Bv);
					return;
				}
				PreparedStatement JGVhwOaQ = KEjs5UvT.prepareStatement(OutageConstants.DB_UPDATE_OUTAGES_FOR_INTERFACE);
				JGVhwOaQ.setLong(1, Lqe2RaMa);
				JGVhwOaQ.setTimestamp(2, convertEventTimeIntoTimestamp(hayXZIMR));
				JGVhwOaQ.setLong(3, nfetxqOH);
				JGVhwOaQ.setString(4, JhftC782);
				int lkfTifzR = JGVhwOaQ.executeUpdate();
				JGVhwOaQ.close();
				try {
					KEjs5UvT.commit();
					if (j5Wu7wjT.isDebugEnabled())
						j5Wu7wjT.debug("handleInterfaceUp: interfaceUp closed " + lkfTifzR + " outages for nodeid/ip "
								+ nfetxqOH + "/" + JhftC782 + " in DB");
				} catch (SQLException fPPadO5R) {
					j5Wu7wjT.warn("Rolling back transaction, interfaceUp could not be recorded for nodeId/ipaddr: "
							+ nfetxqOH + "/" + JhftC782, fPPadO5R);
					try {
						KEjs5UvT.rollback();
					} catch (SQLException AcMJJEcm) {
						j5Wu7wjT.warn("SQL exception during rollback, reason: ", AcMJJEcm);
					}
				}
			} else {
				j5Wu7wjT.warn("\'" + EventConstants.INTERFACE_UP_EVENT_UEI + "\' for " + nfetxqOH + "/" + JhftC782
						+ " ignored.");
			}
		} catch (SQLException LDxykkCz) {
			j5Wu7wjT.warn("SQL exception while handling \'interfaceUp\'", LDxykkCz);
		} finally {
			try {
				if (KEjs5UvT != null)
					KEjs5UvT.close();
			} catch (SQLException WYXVuELJ) {
				j5Wu7wjT.warn("Exception closing JDBC connection", WYXVuELJ);
			}
		}
	}

}