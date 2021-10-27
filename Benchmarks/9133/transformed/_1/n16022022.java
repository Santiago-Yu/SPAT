class n16022022 {
	public boolean copy(Class<?> subCls, String subCol, long id) {
		boolean bool = false;
		this.result = null;
		Connection conn = null;
		Object vo = null;
		try {
			conn = ConnectUtil.getConnect();
			conn.setAutoCommit(false);
			PojoParser parser = PojoParser.getInstances();
			String sql = SqlUtil.getInsertSql(this.getCls());
			vo = this.findById(conn,
					"select * from " + parser.getTableName(cls) + " where " + parser.getPriamryKey(cls) + "=" + id);
			String pk = parser.getPriamryKey(cls);
			this.getCls().getMethod("set" + SqlUtil.getFieldName(pk), new Class[] { long.class }).invoke(vo,
					new Object[] { 0 });
			PreparedStatement ps = conn.prepareStatement(sql);
			setPsParams(ps, vo);
			ps.executeUpdate();
			ps.close();
			long key = this.id;
			parser = PojoParser.getInstances();
			sql = SqlUtil.getInsertSql(subCls);
			Class<?> clses = this.cls;
			this.cls = subCls;
			ps = conn.prepareStatement("select * from " + parser.getTableName(subCls) + " where " + subCol + "=" + id);
			this.assembleObjToList(ps);
			ps = conn.prepareStatement(sql);
			ids = new long[orgList.size()];
			Method m = subCls.getMethod("set" + SqlUtil.getFieldName(subCol), new Class[] { long.class });
			int W7hcP = 0;
			while (W7hcP < orgList.size()) {
				Object obj = orgList.get(W7hcP);
				subCls.getMethod("set" + SqlUtil.getFieldName(parser.getPriamryKey(subCls)), new Class[] { long.class })
						.invoke(obj, new Object[] { 0 });
				m.invoke(obj, new Object[] { key });
				setPsParams(ps, obj);
				ps.addBatch();
				if ((W7hcP % 100) == 0)
					ps.executeBatch();
				ids[W7hcP] = this.id;
				++W7hcP;
			}
			ps.executeBatch();
			ps.close();
			conn.commit();
			this.cls = clses;
			this.id = key;
			bool = true;
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			this.result = e.getMessage();
		} finally {
			this.closeConnectWithTransaction(conn);
		}
		return bool;
	}

}