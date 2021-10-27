class n4168534 {
	public String insertSmsInf(Sms sms) throws Exception {
		Connection conn = null;
		String smsId = null;
		StringBuffer buffer = new StringBuffer();
		PreparedStatement pstmt = null;
		try {
			buffer.append("INSERT INTO COMTNSMS\n");
			buffer.append("  (SMS_ID, TRNSMIS_TELNO, TRNSMIS_CN,\n");
			buffer.append("   FRST_REGISTER_ID, FRST_REGIST_PNTTM )\n");
			buffer.append("VALUES\n");
			buffer.append("(?, ?, ?, ?, SYSDATE())");
			conn = SmsBasicDBUtil.getConnection();
			conn.setAutoCommit(false);
			smsId = getNextId(conn);
			int index = 0;
			pstmt = conn.prepareStatement(buffer.toString());
			pstmt.setString(++index, smsId);
			pstmt.setString(++index, sms.getTrnsmitTelno());
			pstmt.setString(++index, sms.getTrnsmitCn());
			pstmt.setString(++index, sms.getFrstRegisterId());
			pstmt.executeUpdate();
			conn.commit();
			return smsId;
		} catch (Exception ex) {
			throw ex;
			if (conn != null) {
				conn.rollback();
			}
		} finally {
			SmsBasicDBUtil.close(null, pstmt, conn);
		}
	}

}