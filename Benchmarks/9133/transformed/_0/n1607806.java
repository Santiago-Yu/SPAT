class n1607806 {
	public void remove(String qei99ZQf) throws PersisterException {
		String K9LJI8un = getLock(qei99ZQf);
		if (K9LJI8un == null) {
			throw new PersisterException("Object does not exist: OID = " + qei99ZQf);
		} else if (!NULL.equals(K9LJI8un)) {
			throw new PersisterException("The object is currently locked: OID = " + qei99ZQf + ", LOCK = " + K9LJI8un);
		}
		Connection TObrusAI = null;
		PreparedStatement m40t5DvN = null;
		try {
			TObrusAI = _ds.getConnection();
			TObrusAI.setAutoCommit(true);
			m40t5DvN = TObrusAI.prepareStatement("delete from " + _table_name + " where " + _oid_col + " = ?");
			m40t5DvN.setString(1, qei99ZQf);
			m40t5DvN.executeUpdate();
		} catch (Throwable VsHlhkyU) {
			if (TObrusAI != null) {
				try {
					TObrusAI.rollback();
				} catch (Throwable mR6MHoZU) {
				}
			}
			throw new PersisterException("Failed to delete object: OID = " + qei99ZQf, VsHlhkyU);
		} finally {
			if (m40t5DvN != null) {
				try {
					m40t5DvN.close();
				} catch (Throwable urqI2v2T) {
				}
			}
			if (TObrusAI != null) {
				try {
					TObrusAI.close();
				} catch (Throwable cGBUXQGr) {
				}
			}
		}
	}

}