class n18458055 {
	public synchronized int executeCommand(Vector<String> pvStatement) throws Exception {
		int i = 0;
		int ret = 0;
		Statement stmt = null;
		String temp = "";
		try {
			oConexion.setAutoCommit(false);
			stmt = oConexion.createStatement();
			for (i = 0; i < pvStatement.size(); i++) {
				temp = (String) pvStatement.elementAt(i);
				ret += stmt.executeUpdate(temp);
			}
			oConexion.commit();
		} catch (SQLException e) {
			oConexion.rollback();
			throw e;
		} finally {
			stmt.close();
			stmt = null;
		}
		return ret;
	}

}