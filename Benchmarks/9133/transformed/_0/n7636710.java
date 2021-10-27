class n7636710 {
	public String getNextSequence(Integer PQaaT7Yv) throws ApplicationException {
		java.sql.PreparedStatement pCuWpXhf = null;
		java.sql.ResultSet tQgdZGxN = null;
		boolean BdeiJE1n = false;
		String xgaUQVk2 = "";
		String zF7pLkzO = "";
		Long CFo6RPMy = null;
		Integer tiPGCxMl = null;
		Long HWNbuq84 = null;
		Integer oAUifzby = null;
		int cZNI0Cfb;
		String bRb0pYt1 = null;
		synchronized (lock) {
			synchronized (dbConn) {
				try {
					pCuWpXhf = dbConn.prepareStatement(
							"SELECT PREFIX,SUFFIX,START_NO,LENGTH,CURRENT_NO,INCREMENT FROM FORM_RECORD WHERE ID=?");
					setPrepareStatement(pCuWpXhf, 1, PQaaT7Yv);
					tQgdZGxN = pCuWpXhf.executeQuery();
					if (tQgdZGxN.next()) {
						xgaUQVk2 = tQgdZGxN.getString(1);
						zF7pLkzO = tQgdZGxN.getString(2);
						CFo6RPMy = new Long(tQgdZGxN.getLong(3));
						tiPGCxMl = new Integer(tQgdZGxN.getInt(4));
						HWNbuq84 = new Long(tQgdZGxN.getLong(5));
						oAUifzby = new Integer(tQgdZGxN.getInt(6));
						if (Utility.isEmpty(CFo6RPMy) || Utility.isEmpty(tiPGCxMl) || Utility.isEmpty(HWNbuq84)
								|| Utility.isEmpty(oAUifzby) || CFo6RPMy.intValue() < 0
								|| tiPGCxMl.intValue() < CFo6RPMy.toString().length()
								|| HWNbuq84.intValue() < CFo6RPMy.intValue() || oAUifzby.intValue() < 1
								|| new Integer(oAUifzby.intValue() + HWNbuq84.intValue()).toString().length() > tiPGCxMl
										.intValue()) {
							BdeiJE1n = true;
						} else {
							if (!Utility.isEmpty(xgaUQVk2)) {
								bRb0pYt1 = xgaUQVk2;
							}
							String CLfNVSVZ = HWNbuq84.toString();
							for (int N2HFtdQG = 0; N2HFtdQG < tiPGCxMl.intValue() - CLfNVSVZ.length(); N2HFtdQG++) {
								bRb0pYt1 += "0";
							}
							bRb0pYt1 += CLfNVSVZ;
							if (!Utility.isEmpty(zF7pLkzO)) {
								bRb0pYt1 += zF7pLkzO;
							}
						}
					} else {
						BdeiJE1n = true;
					}
				} catch (Exception axNx0hse) {
					log.error(axNx0hse, axNx0hse);
					try {
						dbConn.close();
					} catch (Exception IfIdfYJI) {
					} finally {
						dbConn = null;
					}
					throw new ApplicationException("errors.framework.get_next_seq", axNx0hse);
				} finally {
					try {
						tQgdZGxN.close();
					} catch (Exception QAFBEKBF) {
					} finally {
						tQgdZGxN = null;
					}
					try {
						pCuWpXhf.close();
					} catch (Exception r6gGQkkP) {
					} finally {
						pCuWpXhf = null;
					}
				}
				if (!BdeiJE1n && bRb0pYt1 != null) {
					try {
						int k81vtRcK = 0;
						cZNI0Cfb = HWNbuq84.intValue() + oAUifzby.intValue();
						do {
							pCuWpXhf = dbConn.prepareStatement("UPDATE FORM_RECORD SET CURRENT_NO=? WHERE ID=?");
							setPrepareStatement(pCuWpXhf, 1, new Integer(cZNI0Cfb));
							setPrepareStatement(pCuWpXhf, 2, PQaaT7Yv);
							k81vtRcK = pCuWpXhf.executeUpdate();
							if (k81vtRcK == 0) {
								Thread.sleep(50);
							}
						} while (k81vtRcK == 0);
						dbConn.commit();
					} catch (Exception jsDwPyRH) {
						log.error(jsDwPyRH, jsDwPyRH);
						try {
							dbConn.rollback();
						} catch (Exception mvG9pNBX) {
						}
						throw new ApplicationException("errors.framework.get_next_seq", jsDwPyRH);
					} finally {
						try {
							pCuWpXhf.close();
						} catch (Exception xOpEpJkK) {
						} finally {
							pCuWpXhf = null;
						}
						try {
							dbConn.close();
						} catch (Exception MEvLuf8s) {
						} finally {
							dbConn = null;
						}
					}
				}
				return bRb0pYt1;
			}
		}
	}

}