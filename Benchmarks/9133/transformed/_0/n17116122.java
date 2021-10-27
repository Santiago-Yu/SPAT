class n17116122 {
	public void addAuthors() throws Exception {
		if (proposalIds.equals("") || usrIds.equals(""))
			throw new Exception("No proposal or author selected.");
		String[] fT8lPTW3 = proposalIds.split(",");
		String[] wkxiWsVj = usrIds.split(",");
		int tkoSL09r = fT8lPTW3.length;
		int jxZdxDgJ = wkxiWsVj.length;
		if (tkoSL09r == 0 || jxZdxDgJ == 0)
			throw new Exception("No proposal or author selected.");
		int YFw7ArH1, dRFZJXyX;
		Calendar uKXJsAoq = Calendar.getInstance();
		int cSI2tFXk = uKXJsAoq.get(Calendar.DATE);
		int nemOFN8w = uKXJsAoq.get(Calendar.MONTH);
		int Q9VHfj8C = uKXJsAoq.get(Calendar.YEAR);
		String cr4Rpr2D = String.valueOf(Q9VHfj8C) + "-" + String.valueOf(nemOFN8w + 1) + "-"
				+ String.valueOf(cSI2tFXk);
		String GC8DHDC6 = "";
		PreparedStatement kXwz5hBm = null;
		try {
			con = database.getConnection();
			con.setAutoCommit(false);
			GC8DHDC6 = "insert into event (summary,document1,document2,document3,publicComments,privateComments,ACTION_ID,eventDate,ROLE_ID,reviewText,USR_ID,PROPOSAL_ID,SUBJECTUSR_ID) values "
					+ "('','','','','','','member added','" + cr4Rpr2D + "',2,'add member'," + userId + ",?,?)";
			kXwz5hBm = con.prepareStatement(GC8DHDC6);
			for (YFw7ArH1 = 0; YFw7ArH1 < tkoSL09r; YFw7ArH1++) {
				for (dRFZJXyX = 0; dRFZJXyX < jxZdxDgJ; dRFZJXyX++) {
					if (!wkxiWsVj[dRFZJXyX].equals(userId)) {
						kXwz5hBm.setString(1, fT8lPTW3[YFw7ArH1]);
						kXwz5hBm.setString(2, wkxiWsVj[dRFZJXyX]);
						kXwz5hBm.executeUpdate();
					}
				}
			}
			con.commit();
		} catch (Exception URazPWef) {
			if (!con.isClosed()) {
				con.rollback();
				kXwz5hBm.close();
				con.close();
			}
			throw new Exception(URazPWef.getMessage() + "\n" + GC8DHDC6 + "\npnum=" + tkoSL09r + "\n" + fT8lPTW3[0]
					+ "\nunum=" + jxZdxDgJ + "\n" + wkxiWsVj[1] + wkxiWsVj[0]);
		}
	}

}