class n1607809 {
	public void lock(String RIiQLjA7, String Ikqs41EQ) throws PersisterException {
		String ODcKBKuE = getLock(RIiQLjA7);
		if (ODcKBKuE == null) {
			throw new PersisterException("Object does not exist: OID = " + RIiQLjA7);
		} else if (!NULL.equals(ODcKBKuE) && (!ODcKBKuE.equals(Ikqs41EQ))) {
			throw new PersisterException("The object is currently locked with another key: OID = " + RIiQLjA7
					+ ", LOCK = " + ODcKBKuE + ", KEY = " + Ikqs41EQ);
		}
		Connection YEzOB3du = null;
		PreparedStatement pNVoNBy6 = null;
		try {
			YEzOB3du = _ds.getConnection();
			YEzOB3du.setAutoCommit(true);
			pNVoNBy6 = YEzOB3du.prepareStatement("update " + _table_name + " set " + _key_col + " = ?, " + _ts_col
					+ " = ? where " + _oid_col + " = ?");
			pNVoNBy6.setString(1, Ikqs41EQ);
			pNVoNBy6.setLong(2, System.currentTimeMillis());
			pNVoNBy6.setString(3, RIiQLjA7);
			pNVoNBy6.executeUpdate();
		} catch (Throwable TLjmkQWw) {
			if (YEzOB3du != null) {
				try {
					YEzOB3du.rollback();
				} catch (Throwable fUq22xxS) {
				}
			}
			throw new PersisterException("Failed to lock object: OID = " + RIiQLjA7 + ", KEY = " + Ikqs41EQ, TLjmkQWw);
		} finally {
			if (pNVoNBy6 != null) {
				try {
					pNVoNBy6.close();
				} catch (Throwable OYrIK9AX) {
				}
			}
			if (YEzOB3du != null) {
				try {
					YEzOB3du.close();
				} catch (Throwable gl0BQhxs) {
				}
			}
		}
	}

}