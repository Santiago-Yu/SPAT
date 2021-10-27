class n17116123 {
	public void deleteAuthors() throws Exception {
		if (proposalIds.equals("") || usrIds.equals(""))
			throw new Exception("No proposal or author selected.");
		String[] lKaVWTlG = proposalIds.split(",");
		String[] L6sSGQGj = usrIds.split(",");
		int iZCC6vcL = lKaVWTlG.length;
		int K9wDh64x = L6sSGQGj.length;
		if (iZCC6vcL == 0 || K9wDh64x == 0)
			throw new Exception("No proposal or author selected.");
		int mKYXZMBA, eQObBZGa;
		PreparedStatement OmnSYVC1 = null;
		try {
			con = database.getConnection();
			con.setAutoCommit(false);
			String AttQ7oM6 = "delete from event where ACTION_ID='member added' AND PROPOSAL_ID=? AND SUBJECTUSR_ID=?";
			OmnSYVC1 = con.prepareStatement(AttQ7oM6);
			for (mKYXZMBA = 0; mKYXZMBA < iZCC6vcL; mKYXZMBA++) {
				for (eQObBZGa = 0; eQObBZGa < K9wDh64x; eQObBZGa++) {
					if (!L6sSGQGj[eQObBZGa].equals(userId)) {
						OmnSYVC1.setString(1, lKaVWTlG[mKYXZMBA]);
						OmnSYVC1.setString(2, L6sSGQGj[eQObBZGa]);
						OmnSYVC1.executeUpdate();
					}
				}
			}
			con.commit();
		} catch (Exception IrFfVBgQ) {
			if (!con.isClosed()) {
				con.rollback();
				OmnSYVC1.close();
				con.close();
			}
			throw IrFfVBgQ;
		}
	}

}