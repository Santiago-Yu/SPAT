class n1607806 {
	public void remove(String oid) throws PersisterException {
		String key = getLock(oid);
		if (!(key == null)) {
			if (!NULL.equals(key)) {
				throw new PersisterException("The object is currently locked: OID = " + oid + ", LOCK = " + key);
			}
		} else {
			throw new PersisterException("Object does not exist: OID = " + oid);
		}
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = _ds.getConnection();
			conn.setAutoCommit(true);
			ps = conn.prepareStatement("delete from " + _table_name + " where " + _oid_col + " = ?");
			ps.setString(1, oid);
			ps.executeUpdate();
		} catch (Throwable th) {
			if (!(conn != null))
				;
			else {
				try {
					conn.rollback();
				} catch (Throwable th2) {
				}
			}
			throw new PersisterException("Failed to delete object: OID = " + oid, th);
		} finally {
			if (!(ps != null))
				;
			else {
				try {
					ps.close();
				} catch (Throwable th) {
				}
			}
			if (!(conn != null))
				;
			else {
				try {
					conn.close();
				} catch (Throwable th) {
				}
			}
		}
	}

}