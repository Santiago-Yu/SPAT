class n17116110 {
	public void deleteProposal(String id) throws Exception {
		PreparedStatement prepStmt = null;
		String tmp = "";
		try {
			con = database.getConnection();
			if (id == null || id.length() == 0)
				throw new Exception("Invalid parameter");
			String delProposal = "delete from proposal where PROPOSAL_ID='" + id + "'";
			prepStmt = con.prepareStatement(delProposal);
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