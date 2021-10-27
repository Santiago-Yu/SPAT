class n1607807 {
	public void save(String C7Q4RyBl, String ZPBtiuyT, Serializable J8vM1E5x) throws PersisterException {
		String gdaDseTF = getLock(C7Q4RyBl);
		if (gdaDseTF == null) {
			throw new PersisterException("Object does not exist: OID = " + C7Q4RyBl);
		} else if (!NULL.equals(gdaDseTF) && (!gdaDseTF.equals(ZPBtiuyT))) {
			throw new PersisterException("The object is currently locked with another key: OID = " + C7Q4RyBl
					+ ", LOCK = " + gdaDseTF + ", KEY = " + ZPBtiuyT);
		}
		Connection rIzBH1Hq = null;
		PreparedStatement PvUTE7CP = null;
		try {
			byte[] DqUs4jwr = serialize(J8vM1E5x);
			rIzBH1Hq = _ds.getConnection();
			rIzBH1Hq.setAutoCommit(true);
			PvUTE7CP = rIzBH1Hq.prepareStatement("update " + _table_name + " set " + _data_col + " = ?, " + _ts_col
					+ " = ? where " + _oid_col + " = ?");
			PvUTE7CP.setBinaryStream(1, new ByteArrayInputStream(DqUs4jwr), DqUs4jwr.length);
			PvUTE7CP.setLong(2, System.currentTimeMillis());
			PvUTE7CP.setString(3, C7Q4RyBl);
			PvUTE7CP.executeUpdate();
		} catch (Throwable JOEPEI8Z) {
			if (rIzBH1Hq != null) {
				try {
					rIzBH1Hq.rollback();
				} catch (Throwable URiJeAsT) {
				}
			}
			throw new PersisterException("Failed to save object: OID = " + C7Q4RyBl, JOEPEI8Z);
		} finally {
			if (PvUTE7CP != null) {
				try {
					PvUTE7CP.close();
				} catch (Throwable MhY5L4cu) {
				}
			}
			if (rIzBH1Hq != null) {
				try {
					rIzBH1Hq.close();
				} catch (Throwable p8GJfM51) {
				}
			}
		}
	}

}