class n18458055 {
	public synchronized int executeCommand(Vector<String> X2BVRh06) throws Exception {
		int vDAuqnZO = 0, pYPsS1hb = 0;
		Statement Z444s7BX = null;
		String YrV9ebrE = "";
		try {
			oConexion.setAutoCommit(false);
			Z444s7BX = oConexion.createStatement();
			for (pYPsS1hb = 0; pYPsS1hb < X2BVRh06.size(); pYPsS1hb++) {
				YrV9ebrE = (String) X2BVRh06.elementAt(pYPsS1hb);
				vDAuqnZO += Z444s7BX.executeUpdate(YrV9ebrE);
			}
			oConexion.commit();
		} catch (SQLException a0QqtU5m) {
			oConexion.rollback();
			throw a0QqtU5m;
		} finally {
			Z444s7BX.close();
			Z444s7BX = null;
		}
		return vDAuqnZO;
	}

}