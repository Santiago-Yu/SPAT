class n9096320 {
	private void handleInterfaceReparented(String A8dPR7d7, Parms IsV44O9k) {
		Category KzWUMq4E = ThreadCategory.getInstance(OutageWriter.class);
		if (KzWUMq4E.isDebugEnabled())
			KzWUMq4E.debug("interfaceReparented event received...");
		if (A8dPR7d7 == null || IsV44O9k == null) {
			KzWUMq4E.warn(EventConstants.INTERFACE_REPARENTED_EVENT_UEI + " ignored - info incomplete - ip/parms: "
					+ A8dPR7d7 + "/" + IsV44O9k);
			return;
		}
		long dnTk3FGP = -1;
		long R2qPvm1h = -1;
		String pHcAIL54 = null;
		Value uNSee0M8 = null;
		String JTrpd4hd = null;
		Enumeration lnNag09A = IsV44O9k.enumerateParm();
		while (lnNag09A.hasMoreElements()) {
			Parm nQRtsgvl = (Parm) lnNag09A.nextElement();
			pHcAIL54 = nQRtsgvl.getParmName();
			uNSee0M8 = nQRtsgvl.getValue();
			if (uNSee0M8 == null)
				continue;
			else
				JTrpd4hd = uNSee0M8.getContent();
			if (pHcAIL54.equals(EventConstants.PARM_OLD_NODEID)) {
				try {
					dnTk3FGP = Integer.valueOf(JTrpd4hd).intValue();
				} catch (NumberFormatException CYMOdwcS) {
					KzWUMq4E.warn("Parameter " + EventConstants.PARM_OLD_NODEID + " cannot be non-numeric");
					dnTk3FGP = -1;
				}
			} else if (pHcAIL54.equals(EventConstants.PARM_NEW_NODEID)) {
				try {
					R2qPvm1h = Integer.valueOf(JTrpd4hd).intValue();
				} catch (NumberFormatException kKDJ9ZLN) {
					KzWUMq4E.warn("Parameter " + EventConstants.PARM_NEW_NODEID + " cannot be non-numeric");
					R2qPvm1h = -1;
				}
			}
		}
		if (R2qPvm1h == -1 || dnTk3FGP == -1) {
			KzWUMq4E.warn("Unable to process 'interfaceReparented' event, invalid event parm.");
			return;
		}
		Connection UNmtj13u = null;
		try {
			UNmtj13u = DatabaseConnectionFactory.getInstance().getConnection();
			try {
				UNmtj13u.setAutoCommit(false);
			} catch (SQLException LGe4yz6z) {
				KzWUMq4E.error("Unable to change database AutoCommit to FALSE", LGe4yz6z);
				return;
			}
			PreparedStatement cG0rhkCU = UNmtj13u.prepareStatement(OutageConstants.DB_REPARENT_OUTAGES);
			cG0rhkCU.setLong(1, R2qPvm1h);
			cG0rhkCU.setLong(2, dnTk3FGP);
			cG0rhkCU.setString(3, A8dPR7d7);
			int vkPAlcXz = cG0rhkCU.executeUpdate();
			try {
				UNmtj13u.commit();
				if (KzWUMq4E.isDebugEnabled())
					KzWUMq4E.debug("Reparented " + vkPAlcXz + " outages - ip: " + A8dPR7d7 + " reparented from "
							+ dnTk3FGP + " to " + R2qPvm1h);
			} catch (SQLException az1kCOd3) {
				KzWUMq4E.warn("Rolling back transaction, reparent outages failed for newNodeId/ipAddr: " + R2qPvm1h
						+ "/" + A8dPR7d7);
				try {
					UNmtj13u.rollback();
				} catch (SQLException SEXiMQp7) {
					KzWUMq4E.warn("SQL exception during rollback, reason", SEXiMQp7);
				}
			}
			cG0rhkCU.close();
		} catch (SQLException Aykfbed5) {
			KzWUMq4E.warn("SQL exception while handling \'interfaceReparented\'", Aykfbed5);
		} finally {
			try {
				if (UNmtj13u != null)
					UNmtj13u.close();
			} catch (SQLException mUOrmxpG) {
				KzWUMq4E.warn("Exception closing JDBC connection", mUOrmxpG);
			}
		}
	}

}