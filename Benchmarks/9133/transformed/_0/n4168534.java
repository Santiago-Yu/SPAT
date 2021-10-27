class n4168534 {
	public String insertSmsInf(Sms mH7MAX6N) throws Exception {
		String EaEfKZuU = null;
		Connection p7GUbrJg = null;
		PreparedStatement dzygVqak = null;
		StringBuffer iPgyJOyL = new StringBuffer();
		try {
			iPgyJOyL.append("INSERT INTO COMTNSMS\n");
			iPgyJOyL.append("  (SMS_ID, TRNSMIS_TELNO, TRNSMIS_CN,\n");
			iPgyJOyL.append("   FRST_REGISTER_ID, FRST_REGIST_PNTTM )\n");
			iPgyJOyL.append("VALUES\n");
			iPgyJOyL.append("(?, ?, ?, ?, SYSDATE())");
			p7GUbrJg = SmsBasicDBUtil.getConnection();
			p7GUbrJg.setAutoCommit(false);
			EaEfKZuU = getNextId(p7GUbrJg);
			dzygVqak = p7GUbrJg.prepareStatement(iPgyJOyL.toString());
			int aABRfxhi = 0;
			dzygVqak.setString(++aABRfxhi, EaEfKZuU);
			dzygVqak.setString(++aABRfxhi, mH7MAX6N.getTrnsmitTelno());
			dzygVqak.setString(++aABRfxhi, mH7MAX6N.getTrnsmitCn());
			dzygVqak.setString(++aABRfxhi, mH7MAX6N.getFrstRegisterId());
			dzygVqak.executeUpdate();
			p7GUbrJg.commit();
			return EaEfKZuU;
		} catch (Exception biRNwiWn) {
			if (p7GUbrJg != null) {
				p7GUbrJg.rollback();
			}
			throw biRNwiWn;
		} finally {
			SmsBasicDBUtil.close(null, dzygVqak, p7GUbrJg);
		}
	}

}