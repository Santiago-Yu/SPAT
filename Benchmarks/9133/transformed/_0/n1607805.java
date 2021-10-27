class n1607805 {
	public void create(String me7w8DAI, Serializable mOGDrVlH) throws PersisterException {
		String KB1WJZrM = getLock(me7w8DAI);
		if (KB1WJZrM != null) {
			throw new PersisterException("Object already exists: OID = " + me7w8DAI);
		}
		Connection A2KKZdp0 = null;
		PreparedStatement OFICanL4 = null;
		try {
			byte[] IvBGjnD0 = serialize(mOGDrVlH);
			A2KKZdp0 = _ds.getConnection();
			A2KKZdp0.setAutoCommit(true);
			OFICanL4 = A2KKZdp0.prepareStatement("insert into " + _table_name + "(" + _oid_col + "," + _data_col + ","
					+ _ts_col + ") values (?,?,?)");
			OFICanL4.setString(1, me7w8DAI);
			OFICanL4.setBinaryStream(2, new ByteArrayInputStream(IvBGjnD0), IvBGjnD0.length);
			OFICanL4.setLong(3, System.currentTimeMillis());
			OFICanL4.executeUpdate();
		} catch (Throwable re5fIG3i) {
			if (A2KKZdp0 != null) {
				try {
					A2KKZdp0.rollback();
				} catch (Throwable EsF96U3q) {
				}
			}
			throw new PersisterException("Failed to create object: OID = " + me7w8DAI, re5fIG3i);
		} finally {
			if (OFICanL4 != null) {
				try {
					OFICanL4.close();
				} catch (Throwable ff5L7QOz) {
				}
			}
			if (A2KKZdp0 != null) {
				try {
					A2KKZdp0.close();
				} catch (Throwable eaPNrzlu) {
				}
			}
		}
	}

}