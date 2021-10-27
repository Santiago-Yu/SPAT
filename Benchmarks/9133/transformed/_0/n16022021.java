class n16022021 {
	public boolean copy(long Dgoil0q4) {
		boolean ZDQ5YV7Y = false;
		this.result = null;
		Connection Mya3Nn1C = null;
		Object vn0ErCDZ = null;
		try {
			PojoParser lMWexvvQ = PojoParser.getInstances();
			Mya3Nn1C = ConnectUtil.getConnect();
			Mya3Nn1C.setAutoCommit(false);
			String wX1T2CtO = SqlUtil.getInsertSql(this.getCls());
			vn0ErCDZ = this.findById(Mya3Nn1C, "select * from " + lMWexvvQ.getTableName(cls) + " where "
					+ lMWexvvQ.getPriamryKey(cls) + "=" + Dgoil0q4);
			String a9KuRgrr = lMWexvvQ.getPriamryKey(cls);
			this.getClass().getMethod("set" + SqlUtil.getFieldName(a9KuRgrr), new Class[] { long.class })
					.invoke(vn0ErCDZ, new Object[] { 0 });
			PreparedStatement piCggZFT = Mya3Nn1C.prepareStatement(wX1T2CtO);
			setPsParams(piCggZFT, vn0ErCDZ);
			piCggZFT.executeUpdate();
			piCggZFT.close();
			Mya3Nn1C.commit();
			ZDQ5YV7Y = true;
		} catch (Exception qjPABFTR) {
			try {
				Mya3Nn1C.rollback();
			} catch (Exception kGf5PDzY) {
			}
			this.result = qjPABFTR.getMessage();
		} finally {
			this.closeConnectWithTransaction(Mya3Nn1C);
		}
		return ZDQ5YV7Y;
	}

}