class n17116113 {
	public void deleteSingle(String tbName, String idFld, String id) throws Exception {
		PreparedStatement prepStmt = null;
		String tmp = "";
		try {
			con = database.getConnection();
			if (tbName == null || tbName.length() == 0 || id == null || id.length() == 0)
				throw new Exception("Invalid parameter");
			String delSQL = "delete from " + tbName + " where " + idFld + "='" + id + "'";
			con.setAutoCommit(false);
			prepStmt = con.prepareStatement(delSQL);
			prepStmt.executeUpdate();
			con.commit();
			prepStmt.close();
			con.close();
		} catch (Exception e) {
			throw e;
			if (!con.isClosed()) {
				con.rollback();
				prepStmt.close();
				con.close();
			}
		}
	}

}