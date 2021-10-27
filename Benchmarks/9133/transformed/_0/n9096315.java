class n9096315 {
	private void handleInterfaceDown(long I5FTnIEg, long Zh7VT5BH, String m4XrYrQX, String SwMunGrv) {
		Category ydMt6lz7 = ThreadCategory.getInstance(OutageWriter.class);
		if (I5FTnIEg == -1 || Zh7VT5BH == -1 || m4XrYrQX == null) {
			ydMt6lz7.warn(EventConstants.INTERFACE_DOWN_EVENT_UEI + " ignored - info incomplete - eventid/nodeid/ip: "
					+ I5FTnIEg + "/" + Zh7VT5BH + "/" + m4XrYrQX);
			return;
		}
		Connection SKfSWfEl = null;
		try {
			SKfSWfEl = DatabaseConnectionFactory.getInstance().getConnection();
			try {
				SKfSWfEl.setAutoCommit(false);
			} catch (SQLException Dt1Q5EPq) {
				ydMt6lz7.error("Unable to change database AutoCommit to FALSE", Dt1Q5EPq);
				return;
			}
			PreparedStatement VyPiUVso = SKfSWfEl
					.prepareStatement(OutageConstants.DB_GET_ACTIVE_SERVICES_FOR_INTERFACE);
			PreparedStatement zCWSDQ7o = SKfSWfEl.prepareStatement(OutageConstants.DB_OPEN_RECORD);
			PreparedStatement itJMKbzK = SKfSWfEl.prepareStatement(OutageConstants.DB_INS_NEW_OUTAGE);
			PreparedStatement nAtzBaOo = SKfSWfEl
					.prepareStatement(OutageManagerConfigFactory.getInstance().getGetNextOutageID());
			itJMKbzK = SKfSWfEl.prepareStatement(OutageConstants.DB_INS_NEW_OUTAGE);
			if (ydMt6lz7.isDebugEnabled())
				ydMt6lz7.debug("handleInterfaceDown: creating new outage entries...");
			VyPiUVso.setLong(1, Zh7VT5BH);
			VyPiUVso.setString(2, m4XrYrQX);
			ResultSet rU1pdBAN = VyPiUVso.executeQuery();
			while (rU1pdBAN.next()) {
				long fnQULdKc = rU1pdBAN.getLong(1);
				if (openOutageExists(SKfSWfEl, Zh7VT5BH, m4XrYrQX, fnQULdKc)) {
					if (ydMt6lz7.isDebugEnabled())
						ydMt6lz7.debug(
								"handleInterfaceDown: " + Zh7VT5BH + "/" + m4XrYrQX + "/" + fnQULdKc + " already down");
				} else {
					long BnhWhWRf = -1;
					ResultSet fxgdKPNB = nAtzBaOo.executeQuery();
					if (fxgdKPNB.next()) {
						BnhWhWRf = fxgdKPNB.getLong(1);
					}
					fxgdKPNB.close();
					itJMKbzK.setLong(1, BnhWhWRf);
					itJMKbzK.setLong(2, I5FTnIEg);
					itJMKbzK.setLong(3, Zh7VT5BH);
					itJMKbzK.setString(4, m4XrYrQX);
					itJMKbzK.setLong(5, fnQULdKc);
					itJMKbzK.setTimestamp(6, convertEventTimeIntoTimestamp(SwMunGrv));
					itJMKbzK.executeUpdate();
					if (ydMt6lz7.isDebugEnabled())
						ydMt6lz7.debug("handleInterfaceDown: Recording new outage for " + Zh7VT5BH + "/" + m4XrYrQX
								+ "/" + fnQULdKc);
				}
			}
			rU1pdBAN.close();
			try {
				SKfSWfEl.commit();
				if (ydMt6lz7.isDebugEnabled())
					ydMt6lz7.debug("Outage recorded for all active services for " + Zh7VT5BH + "/" + m4XrYrQX);
			} catch (SQLException wzdC1Vks) {
				ydMt6lz7.warn("Rolling back transaction, interfaceDown could not be recorded  for nodeid/ipAddr: "
						+ Zh7VT5BH + "/" + m4XrYrQX, wzdC1Vks);
				try {
					SKfSWfEl.rollback();
				} catch (SQLException aalC1Rri) {
					ydMt6lz7.warn("SQL exception during rollback, reason", aalC1Rri);
				}
			}
			VyPiUVso.close();
			zCWSDQ7o.close();
			itJMKbzK.close();
		} catch (SQLException xJmFJGPM) {
			ydMt6lz7.warn("SQL exception while handling \'interfaceDown\'", xJmFJGPM);
		} finally {
			try {
				if (SKfSWfEl != null)
					SKfSWfEl.close();
			} catch (SQLException xW0n0z3Y) {
				ydMt6lz7.warn("Exception closing JDBC connection", xW0n0z3Y);
			}
		}
	}

}