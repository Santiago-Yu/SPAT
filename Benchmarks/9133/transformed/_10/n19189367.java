class n19189367 {
	public void insert() throws Exception {
		PreparedStatement pStmt = null;
		Connection con = DbUtil.connectToDb();
		try {
			pStmt = con.prepareStatement(
					"INSERT INTO " + Constants.TABLENAME + " (name,phone,address)" + " values(?,?,?)");
			con.setAutoCommit(false);
			pStmt.setString(1, name);
			pStmt.setString(2, phone);
			pStmt.setString(3, address);
			int j = pStmt.executeUpdate();
			con.commit();
		} catch (Exception ex) {
			throw ex;
			try {
				con.rollback();
			} catch (SQLException sqlex) {
				sqlex.printStackTrace(System.out);
			}
		} finally {
			try {
				pStmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}