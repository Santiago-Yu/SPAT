class n9096316 {
	private void handleNodeDown(long kZsOwy6s, long zjfQxTsr, String gk7ZN3XE) {
		Category lgW84ndd = ThreadCategory.getInstance(OutageWriter.class);
		if (kZsOwy6s == -1 || zjfQxTsr == -1) {
			lgW84ndd.warn(EventConstants.NODE_DOWN_EVENT_UEI + " ignored - info incomplete - eventid/nodeid: "
					+ kZsOwy6s + "/" + zjfQxTsr);
			return;
		}
		Connection NsVRwVNq = null;
		try {
			NsVRwVNq = DatabaseConnectionFactory.getInstance().getConnection();
			try {
				NsVRwVNq.setAutoCommit(false);
			} catch (SQLException UfxVWlQR) {
				lgW84ndd.error("Unable to change database AutoCommit to FALSE", UfxVWlQR);
				return;
			}
			PreparedStatement p2U7gB7c = NsVRwVNq.prepareStatement(OutageConstants.DB_GET_ACTIVE_SERVICES_FOR_NODE);
			PreparedStatement DfyXyKp9 = NsVRwVNq.prepareStatement(OutageConstants.DB_OPEN_RECORD);
			PreparedStatement sV00nhf0 = NsVRwVNq.prepareStatement(OutageConstants.DB_INS_NEW_OUTAGE);
			PreparedStatement Jz8TumN5 = NsVRwVNq
					.prepareStatement(OutageManagerConfigFactory.getInstance().getGetNextOutageID());
			sV00nhf0 = NsVRwVNq.prepareStatement(OutageConstants.DB_INS_NEW_OUTAGE);
			if (lgW84ndd.isDebugEnabled())
				lgW84ndd.debug("handleNodeDown: creating new outage entries...");
			p2U7gB7c.setLong(1, zjfQxTsr);
			ResultSet LVCMtOa1 = p2U7gB7c.executeQuery();
			while (LVCMtOa1.next()) {
				String YbAONIJY = LVCMtOa1.getString(1);
				long XQqEaAFS = LVCMtOa1.getLong(2);
				if (openOutageExists(NsVRwVNq, zjfQxTsr, YbAONIJY, XQqEaAFS)) {
					if (lgW84ndd.isDebugEnabled())
						lgW84ndd.debug(
								"handleNodeDown: " + zjfQxTsr + "/" + YbAONIJY + "/" + XQqEaAFS + " already down");
				} else {
					long HymHuJDp = -1;
					ResultSet CfmaYek3 = Jz8TumN5.executeQuery();
					if (CfmaYek3.next()) {
						HymHuJDp = CfmaYek3.getLong(1);
					}
					CfmaYek3.close();
					sV00nhf0.setLong(1, HymHuJDp);
					sV00nhf0.setLong(2, kZsOwy6s);
					sV00nhf0.setLong(3, zjfQxTsr);
					sV00nhf0.setString(4, YbAONIJY);
					sV00nhf0.setLong(5, XQqEaAFS);
					sV00nhf0.setTimestamp(6, convertEventTimeIntoTimestamp(gk7ZN3XE));
					sV00nhf0.executeUpdate();
					if (lgW84ndd.isDebugEnabled())
						lgW84ndd.debug(
								"handleNodeDown: Recording outage for " + zjfQxTsr + "/" + YbAONIJY + "/" + XQqEaAFS);
				}
			}
			LVCMtOa1.close();
			try {
				NsVRwVNq.commit();
				if (lgW84ndd.isDebugEnabled())
					lgW84ndd.debug("Outage recorded for all active services for " + zjfQxTsr);
			} catch (SQLException Gl6yalpK) {
				lgW84ndd.warn("Rolling back transaction, nodeDown could not be recorded  for nodeId: " + zjfQxTsr,
						Gl6yalpK);
				try {
					NsVRwVNq.rollback();
				} catch (SQLException k3ahmKWp) {
					lgW84ndd.warn("SQL exception during rollback, reason", k3ahmKWp);
				}
			}
			p2U7gB7c.close();
			DfyXyKp9.close();
			sV00nhf0.close();
		} catch (SQLException Y7TgGMG1) {
			lgW84ndd.warn("SQL exception while handling \'nodeDown\'", Y7TgGMG1);
		} finally {
			try {
				if (NsVRwVNq != null)
					NsVRwVNq.close();
			} catch (SQLException UuB2w9Is) {
				lgW84ndd.warn("Exception closing JDBC connection", UuB2w9Is);
			}
		}
	}

}