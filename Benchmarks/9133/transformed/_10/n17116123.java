class n17116123 {
	public void deleteAuthors() throws Exception {
		if (proposalIds.equals("") || usrIds.equals(""))
			throw new Exception("No proposal or author selected.");
		String[] pids = proposalIds.split(",");
		int pnum = pids.length;
		String[] uids = usrIds.split(",");
		int unum = uids.length;
		int i, j;
		if (pnum == 0 || unum == 0)
			throw new Exception("No proposal or author selected.");
		PreparedStatement prepStmt = null;
		try {
			con = database.getConnection();
			con.setAutoCommit(false);
			String pStr = "delete from event where ACTION_ID='member added' AND PROPOSAL_ID=? AND SUBJECTUSR_ID=?";
			prepStmt = con.prepareStatement(pStr);
			for (i = 0; i < pnum; i++) {
				for (j = 0; j < unum; j++) {
					if (!uids[j].equals(userId)) {
						prepStmt.setString(1, pids[i]);
						prepStmt.setString(2, uids[j]);
						prepStmt.executeUpdate();
					}
				}
			}
			con.commit();
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