class n17116111 {
	public void deleteType(String id) throws Exception {
		PreparedStatement prepStmt = null;
		String tmp = "";
		try {
			con = database.getConnection();
			if (id == null || id.length() == 0)
				throw new Exception("Invalid parameter");
			String delType = "delete from type where TYPE_ID='" + id + "'";
			con.setAutoCommit(false);
			prepStmt = con.prepareStatement(
					"delete from correlation where TYPE_ID='" + id + "' OR CORRELATEDTYPE_ID='" + id + "'");
			prepStmt.executeUpdate();
			prepStmt = con.prepareStatement("delete from composition where TYPE_ID='" + id + "'");
			prepStmt.executeUpdate();
			prepStmt = con.prepareStatement("delete from distribution where TYPE_ID='" + id + "'");
			prepStmt.executeUpdate();
			prepStmt = con.prepareStatement("delete from typename where TYPE_ID='" + id + "'");
			prepStmt.executeUpdate();
			prepStmt = con.prepareStatement("delete from typereference where TYPE_ID='" + id + "'");
			prepStmt.executeUpdate();
			prepStmt = con.prepareStatement("delete from plot where TYPE_ID='" + id + "'");
			prepStmt.executeUpdate();
			prepStmt = con.prepareStatement(delType);
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