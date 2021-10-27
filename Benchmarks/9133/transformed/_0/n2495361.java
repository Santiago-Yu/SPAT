class n2495361 {
	public static synchronized Integer getNextSequence(String HMUfnrgv) throws ApplicationException {
		Connection ClyRh64g = null;
		java.sql.PreparedStatement C1ED85UM = null;
		java.sql.ResultSet YvI4F8sD = null;
		boolean b7gSm2mW = false;
		int g2ZQesvR = 0;
		int PpKEAJUq = 0;
		try {
			ClyRh64g = getConnection();
		} catch (Exception z1nD6VJa) {
			log.error("Error Getting Connection.", z1nD6VJa);
			throw new ApplicationException("errors.framework.db_conn", z1nD6VJa);
		}
		synchronized (hashPkKeyLock) {
			if (hashPkKeyLock.get(HMUfnrgv) == null) {
				hashPkKeyLock.put(HMUfnrgv, new Object());
			}
		}
		synchronized (hashPkKeyLock.get(HMUfnrgv)) {
			synchronized (ClyRh64g) {
				try {
					C1ED85UM = ClyRh64g.prepareStatement("SELECT TABLE_KEY_MAX FROM SYS_TABLE_KEY WHERE TABLE_NAME=?");
					C1ED85UM.setString(1, HMUfnrgv);
					YvI4F8sD = C1ED85UM.executeQuery();
					if (YvI4F8sD.next()) {
						g2ZQesvR = YvI4F8sD.getInt(1);
					} else {
						b7gSm2mW = true;
					}
				} catch (Exception YNT6fpbB) {
					log.error(YNT6fpbB, YNT6fpbB);
					try {
						ClyRh64g.close();
					} catch (Exception cNofwJuE) {
					} finally {
						ClyRh64g = null;
					}
					throw new ApplicationException("errors.framework.get_next_seq", YNT6fpbB, HMUfnrgv);
				} finally {
					try {
						YvI4F8sD.close();
					} catch (Exception LwEqvSFm) {
					} finally {
						YvI4F8sD = null;
					}
					try {
						C1ED85UM.close();
					} catch (Exception nogCNvuG) {
					} finally {
						C1ED85UM = null;
					}
				}
				if (b7gSm2mW) {
					try {
						g2ZQesvR = 0;
						C1ED85UM = ClyRh64g.prepareStatement(
								"INSERT INTO SYS_TABLE_KEY(TABLE_NAME, TABLE_KEY_MAX) VALUES(?, ?)",
								java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_UPDATABLE);
						C1ED85UM.setString(1, HMUfnrgv);
						C1ED85UM.setInt(2, g2ZQesvR);
						C1ED85UM.executeUpdate();
					} catch (Exception e32dcLyO) {
						log.error(e32dcLyO, e32dcLyO);
						try {
							ClyRh64g.close();
						} catch (Exception ii2ikQvC) {
						} finally {
							ClyRh64g = null;
						}
						throw new ApplicationException("errors.framework.get_next_seq", e32dcLyO, HMUfnrgv);
					} finally {
						try {
							C1ED85UM.close();
						} catch (Exception DpYZllsu) {
						} finally {
							C1ED85UM = null;
						}
					}
				}
				try {
					int Rw1d6pi7 = 0;
					PpKEAJUq = g2ZQesvR;
					do {
						PpKEAJUq++;
						C1ED85UM = ClyRh64g.prepareStatement(
								"UPDATE SYS_TABLE_KEY SET TABLE_KEY_MAX=? WHERE TABLE_NAME=? AND TABLE_KEY_MAX=?",
								java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_UPDATABLE);
						C1ED85UM.setInt(1, PpKEAJUq);
						C1ED85UM.setString(2, HMUfnrgv);
						C1ED85UM.setInt(3, g2ZQesvR);
						Rw1d6pi7 = C1ED85UM.executeUpdate();
						g2ZQesvR++;
						if (Rw1d6pi7 == 0 && (g2ZQesvR % 2) == 0) {
							Thread.sleep(50);
						}
					} while (Rw1d6pi7 == 0);
					ClyRh64g.commit();
					return (new Integer(PpKEAJUq));
				} catch (Exception TXudeG4N) {
					log.error(TXudeG4N, TXudeG4N);
					try {
						ClyRh64g.rollback();
					} catch (Exception jDsHmqEK) {
					}
					throw new ApplicationException("errors.framework.get_next_seq", TXudeG4N, HMUfnrgv);
				} finally {
					try {
						C1ED85UM.close();
					} catch (Exception nAFbp7fD) {
					} finally {
						C1ED85UM = null;
					}
					try {
						ClyRh64g.close();
					} catch (Exception QPYJYRvx) {
					} finally {
						ClyRh64g = null;
					}
				}
			}
		}
	}

}