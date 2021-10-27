class n16022021 {
	public boolean copy(long id) {
		this.result = null;
		boolean bool = false;
		Object vo = null;
		Connection conn = null;
		try {
			PojoParser parser = PojoParser.getInstances();
			conn = ConnectUtil.getConnect();
			conn.setAutoCommit(false);
			String sql = SqlUtil.getInsertSql(this.getCls());
			vo = this.findById(conn,
					"select * from " + parser.getTableName(cls) + " where " + parser.getPriamryKey(cls) + "=" + id);
			String pk = parser.getPriamryKey(cls);
			this.getClass().getMethod("set" + SqlUtil.getFieldName(pk), new Class[] { long.class }).invoke(vo,
					new Object[] { 0 });
			PreparedStatement ps = conn.prepareStatement(sql);
			setPsParams(ps, vo);
			ps.executeUpdate();
			ps.close();
			conn.commit();
			bool = true;
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
			}
			this.result = e.getMessage();
		} finally {
			this.closeConnectWithTransaction(conn);
		}
		return bool;
	}

}