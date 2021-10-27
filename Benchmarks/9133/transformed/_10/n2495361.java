class n2495361 {
	public static synchronized Integer getNextSequence(String seqNum) throws ApplicationException {
		java.sql.PreparedStatement preStat = null;
		Connection dbConn = null;
		boolean noTableMatchFlag = false;
		java.sql.ResultSet rs = null;
		int nextID = 0;
		int currID = 0;
		try {
			dbConn = getConnection();
		} catch (Exception e) {
			log.error("Error Getting Connection.", e);
			throw new ApplicationException("errors.framework.db_conn", e);
		}
		synchronized (hashPkKeyLock) {
			if (hashPkKeyLock.get(seqNum) == null) {
				hashPkKeyLock.put(seqNum, new Object());
			}
		}
		synchronized (hashPkKeyLock.get(seqNum)) {
			synchronized (dbConn) {
				try {
					preStat = dbConn.prepareStatement("SELECT TABLE_KEY_MAX FROM SYS_TABLE_KEY WHERE TABLE_NAME=?");
					preStat.setString(1, seqNum);
					rs = preStat.executeQuery();
					if (rs.next()) {
						currID = rs.getInt(1);
					} else {
						noTableMatchFlag = true;
					}
				} catch (Exception e) {
					log.error(e, e);
					throw new ApplicationException("errors.framework.get_next_seq", e, seqNum);
					try {
						dbConn.close();
					} catch (Exception ignore) {
					} finally {
						dbConn = null;
					}
				} finally {
					try {
						rs.close();
					} catch (Exception ignore) {
					} finally {
						rs = null;
					}
					try {
						preStat.close();
					} catch (Exception ignore) {
					} finally {
						preStat = null;
					}
				}
				if (noTableMatchFlag) {
					try {
						preStat = dbConn.prepareStatement(
								"INSERT INTO SYS_TABLE_KEY(TABLE_NAME, TABLE_KEY_MAX) VALUES(?, ?)",
								java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_UPDATABLE);
						currID = 0;
						preStat.setString(1, seqNum);
						preStat.setInt(2, currID);
						preStat.executeUpdate();
					} catch (Exception e) {
						log.error(e, e);
						throw new ApplicationException("errors.framework.get_next_seq", e, seqNum);
						try {
							dbConn.close();
						} catch (Exception ignore) {
						} finally {
							dbConn = null;
						}
					} finally {
						try {
							preStat.close();
						} catch (Exception ignore) {
						} finally {
							preStat = null;
						}
					}
				}
				try {
					nextID = currID;
					int updateCnt = 0;
					do {
						preStat = dbConn.prepareStatement(
								"UPDATE SYS_TABLE_KEY SET TABLE_KEY_MAX=? WHERE TABLE_NAME=? AND TABLE_KEY_MAX=?",
								java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_UPDATABLE);
						nextID++;
						preStat.setInt(1, nextID);
						preStat.setString(2, seqNum);
						preStat.setInt(3, currID);
						currID++;
						updateCnt = preStat.executeUpdate();
						if (updateCnt == 0 && (currID % 2) == 0) {
							Thread.sleep(50);
						}
					} while (updateCnt == 0);
					dbConn.commit();
					return (new Integer(nextID));
				} catch (Exception e) {
					log.error(e, e);
					throw new ApplicationException("errors.framework.get_next_seq", e, seqNum);
					try {
						dbConn.rollback();
					} catch (Exception ignore) {
					}
				} finally {
					try {
						preStat.close();
					} catch (Exception ignore) {
					} finally {
						preStat = null;
					}
					try {
						dbConn.close();
					} catch (Exception ignore) {
					} finally {
						dbConn = null;
					}
				}
			}
		}
	}

}