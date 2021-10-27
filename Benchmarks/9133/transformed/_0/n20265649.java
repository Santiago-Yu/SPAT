class n20265649 {
	public static void setFinishedFlag(String lH5UWUoS, String Ngn74X6f, String Jh7xSIQm, String otZSEi84,
			String JE4yW2dR, int RKWXbtlJ) throws Exception {
		String d8pZNGTg = "update flag set flag = " + RKWXbtlJ;
		Connection rzwOAUAE = CubridDBCenter.getConnection(lH5UWUoS, Ngn74X6f, otZSEi84, Jh7xSIQm, JE4yW2dR);
		System.out.println("====:::===" + lH5UWUoS);
		Statement oCCBtka9 = null;
		try {
			rzwOAUAE.setAutoCommit(false);
			oCCBtka9 = rzwOAUAE.createStatement();
			oCCBtka9.executeUpdate(d8pZNGTg);
			rzwOAUAE.commit();
		} catch (Exception K3soKiZK) {
			K3soKiZK.printStackTrace();
			rzwOAUAE.rollback();
			throw K3soKiZK;
		} finally {
			oCCBtka9.close();
			rzwOAUAE.close();
		}
	}

}