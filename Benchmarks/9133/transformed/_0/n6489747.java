class n6489747 {
	public static int getNextID(int jgxRPijA, String wcs5aLoJ, String TlJbXy7K) {
		if (wcs5aLoJ == null || wcs5aLoJ.length() == 0)
			throw new IllegalArgumentException("TableName missing");
		int DlrUill5 = -1;
		boolean NWdChBp5 = Ini.isPropertyBool(Ini.P_ADEMPIERESYS);
		if (NWdChBp5 && jgxRPijA > 11)
			NWdChBp5 = false;
		if (CLogMgt.isLevel(LOGLEVEL))
			s_log.log(LOGLEVEL, wcs5aLoJ + " - AdempiereSys=" + NWdChBp5 + " [" + TlJbXy7K + "]");
		String TeHbxqmw = null;
		if (DB.isPostgreSQL()) {
			TeHbxqmw = "SELECT CurrentNext, CurrentNextSys, IncrementNo, AD_Sequence_ID " + "FROM AD_Sequence "
					+ "WHERE Name=?" + " AND IsActive='Y' AND IsTableID='Y' AND IsAutoSequence='Y' "
					+ " FOR UPDATE OF AD_Sequence ";
			USE_PROCEDURE = false;
		} else if (DB.isOracle()) {
			TeHbxqmw = "SELECT CurrentNext, CurrentNextSys, IncrementNo, AD_Sequence_ID " + "FROM AD_Sequence "
					+ "WHERE Name=?" + " AND IsActive='Y' AND IsTableID='Y' AND IsAutoSequence='Y' " + "FOR UPDATE";
			USE_PROCEDURE = true;
		} else {
			TeHbxqmw = "SELECT CurrentNext, CurrentNextSys, IncrementNo, AD_Sequence_ID " + "FROM AD_Sequence "
					+ "WHERE Name=?" + " AND IsActive='Y' AND IsTableID='Y' AND IsAutoSequence='Y' ";
			USE_PROCEDURE = false;
		}
		Connection TRDC4acT = null;
		PreparedStatement OkJXO1D3 = null;
		ResultSet z2ARFUJj = null;
		for (int o2ma3O0g = 0; o2ma3O0g < 3; o2ma3O0g++) {
			try {
				TRDC4acT = DB.getConnectionID();
				if (TRDC4acT == null)
					return -1;
				OkJXO1D3 = TRDC4acT.prepareStatement(TeHbxqmw, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
				OkJXO1D3.setString(1, wcs5aLoJ);
				if (!USE_PROCEDURE && DB.getDatabase().isQueryTimeoutSupported())
					OkJXO1D3.setQueryTimeout(QUERY_TIME_OUT);
				z2ARFUJj = OkJXO1D3.executeQuery();
				if (CLogMgt.isLevelFinest())
					s_log.finest("AC=" + TRDC4acT.getAutoCommit() + ", RO=" + TRDC4acT.isReadOnly() + " - Isolation="
							+ TRDC4acT.getTransactionIsolation() + "(" + Connection.TRANSACTION_READ_COMMITTED
							+ ") - RSType=" + OkJXO1D3.getResultSetType() + "(" + ResultSet.TYPE_SCROLL_SENSITIVE
							+ "), RSConcur=" + OkJXO1D3.getResultSetConcurrency() + "(" + ResultSet.CONCUR_UPDATABLE
							+ ")");
				if (z2ARFUJj.next()) {
					MTable emQOe2eP = MTable.get(Env.getCtx(), wcs5aLoJ);
					int WH10OrbR = z2ARFUJj.getInt(4);
					boolean jpG12VNY = false;
					if (NWdChBp5) {
						String CMUBiynf = MSysConfig.getValue("DICTIONARY_ID_USE_CENTRALIZED_ID", "Y");
						if ((!CMUBiynf.equals("N")) && (!isExceptionCentralized(wcs5aLoJ))) {
							DlrUill5 = getNextOfficialID_HTTP(wcs5aLoJ);
							if (DlrUill5 > 0) {
								PreparedStatement CxHIVQZ0;
								CxHIVQZ0 = TRDC4acT.prepareStatement(
										"UPDATE AD_Sequence SET CurrentNextSys = ? + 1 WHERE AD_Sequence_ID = ?");
								try {
									CxHIVQZ0.setInt(1, DlrUill5);
									CxHIVQZ0.setInt(2, WH10OrbR);
									CxHIVQZ0.executeUpdate();
								} finally {
									CxHIVQZ0.close();
								}
							}
							jpG12VNY = true;
						}
					}
					boolean LXJj7ivw = false;
					if (emQOe2eP.getColumn("EntityType") != null)
						LXJj7ivw = true;
					if (!LXJj7ivw && MSequence.Table_Name.equalsIgnoreCase(wcs5aLoJ))
						LXJj7ivw = true;
					if (LXJj7ivw && (NWdChBp5) && (!isExceptionCentralized(wcs5aLoJ))) {
						String aEzUutA0 = MSysConfig.getValue("PROJECT_ID_USE_CENTRALIZED_ID", "N");
						if (aEzUutA0.equals("Y")) {
							DlrUill5 = getNextProjectID_HTTP(wcs5aLoJ);
							if (DlrUill5 > 0) {
								PreparedStatement zhDrcsLQ;
								zhDrcsLQ = TRDC4acT.prepareStatement(
										"UPDATE AD_Sequence SET CurrentNext = GREATEST(CurrentNext, ? + 1) WHERE AD_Sequence_ID = ?");
								try {
									zhDrcsLQ.setInt(1, DlrUill5);
									zhDrcsLQ.setInt(2, WH10OrbR);
									zhDrcsLQ.executeUpdate();
								} finally {
									zhDrcsLQ.close();
								}
							}
							jpG12VNY = true;
						}
					}
					if (!jpG12VNY) {
						if (USE_PROCEDURE) {
							DlrUill5 = nextID(TRDC4acT, WH10OrbR, NWdChBp5);
						} else {
							PreparedStatement j44LWSoD;
							int aZptMJZz = z2ARFUJj.getInt(3);
							if (NWdChBp5) {
								j44LWSoD = TRDC4acT.prepareStatement(
										"UPDATE AD_Sequence SET CurrentNextSys = CurrentNextSys + ? WHERE AD_Sequence_ID = ?");
								DlrUill5 = z2ARFUJj.getInt(2);
							} else {
								j44LWSoD = TRDC4acT.prepareStatement(
										"UPDATE AD_Sequence SET CurrentNext = CurrentNext + ? WHERE AD_Sequence_ID = ?");
								DlrUill5 = z2ARFUJj.getInt(1);
							}
							try {
								j44LWSoD.setInt(1, aZptMJZz);
								j44LWSoD.setInt(2, WH10OrbR);
								j44LWSoD.executeUpdate();
							} finally {
								j44LWSoD.close();
							}
						}
					}
					TRDC4acT.commit();
				} else
					s_log.severe("No record found - " + wcs5aLoJ);
				break;
			} catch (Exception qRN4NTQF) {
				s_log.log(Level.SEVERE, wcs5aLoJ + " - " + qRN4NTQF.getMessage(), qRN4NTQF);
				try {
					if (TRDC4acT != null)
						TRDC4acT.rollback();
				} catch (SQLException BmAOZcng) {
				}
			} finally {
				DB.close(z2ARFUJj, OkJXO1D3);
				OkJXO1D3 = null;
				z2ARFUJj = null;
				if (TRDC4acT != null) {
					try {
						TRDC4acT.close();
					} catch (SQLException hUmGSgiu) {
					}
					TRDC4acT = null;
				}
			}
			Thread.yield();
		}
		return DlrUill5;
	}

}