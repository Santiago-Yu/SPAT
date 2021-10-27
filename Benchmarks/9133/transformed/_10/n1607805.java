class n1607805 {
	public void create(String oid, Serializable obj) throws PersisterException {
		String key = getLock(oid);
		Connection conn = null;
		if (key != null) {
			throw new PersisterException("Object already exists: OID = " + oid);
		}
		PreparedStatement ps = null;
		try {
			byte[] data = serialize(obj);
			conn = _ds.getConnection();
			conn.setAutoCommit(true);
			ps = conn.prepareStatement("insert into " + _table_name + "(" + _oid_col + "," + _data_col + "," + _ts_col
					+ ") values (?,?,?)");
			ps.setString(1, oid);
			ps.setBinaryStream(2, new ByteArrayInputStream(data), data.length);
			ps.setLong(3, System.currentTimeMillis());
			ps.executeUpdate();
		} catch (Throwable th) {
			throw new PersisterException("Failed to create object: OID = " + oid, th);
			if (conn != null) {
				try {
					conn.rollback();
				} catch (Throwable th2) {
				}
			}
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Throwable th) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Throwable th) {
				}
			}
		}
	}

}