class n1607810 {
	public void unlock(String pFXZUwCS, String UJXmxSWE) throws PersisterException {
		String ORRuUWre = getLock(pFXZUwCS);
		if (ORRuUWre == null) {
			throw new PersisterException("Object does not exist: OID = " + pFXZUwCS);
		} else if (!NULL.equals(ORRuUWre) && (!ORRuUWre.equals(UJXmxSWE))) {
			throw new PersisterException("The object is currently locked with another key: OID = " + pFXZUwCS
					+ ", LOCK = " + ORRuUWre + ", KEY = " + UJXmxSWE);
		}
		Connection RAqXEqR7 = null;
		PreparedStatement VfsCWAR1 = null;
		try {
			RAqXEqR7 = _ds.getConnection();
			RAqXEqR7.setAutoCommit(true);
			VfsCWAR1 = RAqXEqR7.prepareStatement("update " + _table_name + " set " + _key_col + " = NULL, " + _ts_col
					+ " = ? where " + _oid_col + " = ?");
			VfsCWAR1.setLong(1, System.currentTimeMillis());
			VfsCWAR1.setString(2, pFXZUwCS);
			VfsCWAR1.executeUpdate();
		} catch (Throwable Nje0FQBI) {
			if (RAqXEqR7 != null) {
				try {
					RAqXEqR7.rollback();
				} catch (Throwable GPeWPvDj) {
				}
			}
			throw new PersisterException("Failed to unlock object: OID = " + pFXZUwCS + ", KEY = " + UJXmxSWE,
					Nje0FQBI);
		} finally {
			if (VfsCWAR1 != null) {
				try {
					VfsCWAR1.close();
				} catch (Throwable ou3qJ8NS) {
				}
			}
			if (RAqXEqR7 != null) {
				try {
					RAqXEqR7.close();
				} catch (Throwable olW3FXsF) {
				}
			}
		}
	}

}