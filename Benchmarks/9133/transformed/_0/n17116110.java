class n17116110 {
	public void deleteProposal(String tfkhqE3e) throws Exception {
		String vYL0zTj0 = "";
		PreparedStatement dEU3fVj3 = null;
		try {
			if (tfkhqE3e == null || tfkhqE3e.length() == 0)
				throw new Exception("Invalid parameter");
			con = database.getConnection();
			String dhFHZ6oB = "delete from proposal where PROPOSAL_ID='" + tfkhqE3e + "'";
			dEU3fVj3 = con.prepareStatement(dhFHZ6oB);
			dEU3fVj3.executeUpdate();
			con.commit();
			dEU3fVj3.close();
			con.close();
		} catch (Exception bkHBvrlW) {
			if (!con.isClosed()) {
				con.rollback();
				dEU3fVj3.close();
				con.close();
			}
			throw bkHBvrlW;
		}
	}

}