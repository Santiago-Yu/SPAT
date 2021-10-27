class n8953394 {
	private void update(String qlL1dygu, SyrupConnection oC6k83gB, boolean Xg5g1xTx) throws Exception {
		Statement rvaVVSPp = null;
		try {
			rvaVVSPp = oC6k83gB.createStatement();
			rvaVVSPp.executeUpdate(qlL1dygu);
			oC6k83gB.commit();
		} catch (Throwable uwhXxK7M) {
			if (Xg5g1xTx) {
				logger.log(Level.INFO, "Update failed. Transaction is rolled back", uwhXxK7M);
			}
			oC6k83gB.rollback();
		}
	}

}