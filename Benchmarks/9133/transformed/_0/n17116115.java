class n17116115 {
	public void assign() throws Exception {
		if (proposalIds.equals("") || usrIds.equals(""))
			throw new Exception("No proposal or peer-viewer selected.");
		String[] vjZtSFbO = proposalIds.split(",");
		String[] xcXaTEZ0 = usrIds.split(",");
		int wu64PEzf = vjZtSFbO.length;
		int Sr9zknHu = xcXaTEZ0.length;
		if (wu64PEzf == 0 || Sr9zknHu == 0)
			throw new Exception("No proposal or peer-viewer selected.");
		int g3XAR1vE, SJhmGyRw;
		String zEuiZP7c = "update proposal set current_status='assigned' where ";
		for (g3XAR1vE = 0; g3XAR1vE < wu64PEzf; g3XAR1vE++) {
			if (g3XAR1vE > 0)
				zEuiZP7c += " OR ";
			zEuiZP7c += "PROPOSAL_ID=" + vjZtSFbO[g3XAR1vE];
		}
		Calendar ZKHyK5cT = Calendar.getInstance();
		int PA0gT7R8 = ZKHyK5cT.get(Calendar.DATE);
		int kPO04D0F = ZKHyK5cT.get(Calendar.MONTH);
		int I5WC3Nn6 = ZKHyK5cT.get(Calendar.YEAR);
		String R1f3w7rc = String.valueOf(I5WC3Nn6) + "-" + String.valueOf(kPO04D0F + 1) + "-"
				+ String.valueOf(PA0gT7R8);
		PreparedStatement r2DiOFSm = null;
		try {
			con = database.getConnection();
			con.setAutoCommit(false);
			r2DiOFSm = con.prepareStatement(zEuiZP7c);
			r2DiOFSm.executeUpdate();
			zEuiZP7c = "insert into event (summary,document1,document2,document3,publicComments,privateComments,ACTION_ID,eventDate,ROLE_ID,reviewText,USR_ID,PROPOSAL_ID,SUBJECTUSR_ID) values "
					+ "('','','','','','','assigned','" + R1f3w7rc + "',2,'new'," + userId + ",?,?)";
			r2DiOFSm = con.prepareStatement(zEuiZP7c);
			for (g3XAR1vE = 0; g3XAR1vE < wu64PEzf; g3XAR1vE++) {
				for (SJhmGyRw = 0; SJhmGyRw < Sr9zknHu; SJhmGyRw++) {
					r2DiOFSm.setString(1, vjZtSFbO[g3XAR1vE]);
					r2DiOFSm.setString(2, xcXaTEZ0[SJhmGyRw]);
					r2DiOFSm.executeUpdate();
				}
			}
			con.commit();
		} catch (Exception L8T6oMvp) {
			if (!con.isClosed()) {
				con.rollback();
				r2DiOFSm.close();
				con.close();
			}
			throw L8T6oMvp;
		}
		event_Form TQ8OqqAe = new event_Form();
		for (SJhmGyRw = 0; SJhmGyRw < Sr9zknHu; SJhmGyRw++) {
			TQ8OqqAe.setUSR_ID(userId);
			TQ8OqqAe.setSUBJECTUSR_ID(xcXaTEZ0[SJhmGyRw]);
			systemManager.handleEvent(SystemManager.EVENT_PROPOSAL_ASSIGNED, TQ8OqqAe, null, null);
		}
	}

}