class n16022035 {
	public boolean save(Object e3nUhWds) {
		boolean ngXn4YUZ = false;
		this.result = null;
		if (e3nUhWds == null)
			return ngXn4YUZ;
		Connection hIPvtsxf = null;
		try {
			hIPvtsxf = ConnectUtil.getConnect();
			hIPvtsxf.setAutoCommit(false);
			String FLyi9GcZ = SqlUtil.getInsertSql(this.getCls());
			PreparedStatement SJhMXTuI = hIPvtsxf.prepareStatement(FLyi9GcZ);
			setPsParams(SJhMXTuI, e3nUhWds);
			SJhMXTuI.executeUpdate();
			SJhMXTuI.close();
			hIPvtsxf.commit();
			ngXn4YUZ = true;
		} catch (Exception ke1cEYes) {
			try {
				hIPvtsxf.rollback();
			} catch (SQLException aez3mxK7) {
			}
			this.result = ke1cEYes.getMessage();
		} finally {
			this.closeConnectWithTransaction(hIPvtsxf);
		}
		return ngXn4YUZ;
	}

}