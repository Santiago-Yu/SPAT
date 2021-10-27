class n20836129 {
	public void addUser(String mtv8cldQ, String V0UdmK05) {
		String FXRS7iMf = Function.getSysTime().toString();
		String ViKtOnlg = FXRS7iMf.substring(0, 4) + FXRS7iMf.substring(5, 7) + FXRS7iMf.substring(8, 10)
				+ FXRS7iMf.substring(11, 13) + FXRS7iMf.substring(14, 16) + FXRS7iMf.substring(17, 19)
				+ FXRS7iMf.substring(20, 22) + "0";
		Connection fqTDSlu9 = null;
		PreparedStatement xWh0V0S5 = null;
		try {
			fqTDSlu9 = DbForumFactory.getConnection();
			fqTDSlu9.setAutoCommit(false);
			int XhxvzPU6 = DbSequenceManager.nextID(DbSequenceManager.USER);
			xWh0V0S5 = fqTDSlu9.prepareStatement(INSERT_USER);
			xWh0V0S5.setString(1, mtv8cldQ);
			xWh0V0S5.setString(2, SecurityUtil.md5ByHex(V0UdmK05));
			xWh0V0S5.setString(3, ViKtOnlg);
			xWh0V0S5.setString(4, "");
			xWh0V0S5.setString(5, "");
			xWh0V0S5.setString(6, "");
			xWh0V0S5.setString(7, "");
			xWh0V0S5.setInt(8, XhxvzPU6);
			xWh0V0S5.executeUpdate();
			xWh0V0S5.clearParameters();
			xWh0V0S5 = fqTDSlu9.prepareStatement(INSERT_USERPROPS);
			xWh0V0S5.setString(1, "");
			xWh0V0S5.setString(2, "");
			xWh0V0S5.setString(3, "");
			xWh0V0S5.setInt(4, 0);
			xWh0V0S5.setString(5, "");
			xWh0V0S5.setInt(6, 0);
			xWh0V0S5.setInt(7, 0);
			xWh0V0S5.setString(8, "");
			xWh0V0S5.setString(9, "");
			xWh0V0S5.setString(10, "");
			xWh0V0S5.setInt(11, 0);
			xWh0V0S5.setInt(12, 0);
			xWh0V0S5.setInt(13, 0);
			xWh0V0S5.setInt(14, 0);
			xWh0V0S5.setString(15, "");
			xWh0V0S5.setString(16, "");
			xWh0V0S5.setString(17, "");
			xWh0V0S5.setString(18, "");
			xWh0V0S5.setString(19, "");
			xWh0V0S5.setString(20, "");
			xWh0V0S5.setString(21, "");
			xWh0V0S5.setString(22, "");
			xWh0V0S5.setString(23, "");
			xWh0V0S5.setInt(24, 0);
			xWh0V0S5.setInt(25, 0);
			xWh0V0S5.setInt(26, XhxvzPU6);
			xWh0V0S5.executeUpdate();
			xWh0V0S5.clearParameters();
			xWh0V0S5 = fqTDSlu9.prepareStatement(INSTER_USERGROUP);
			xWh0V0S5.setInt(1, 4);
			xWh0V0S5.setInt(2, XhxvzPU6);
			xWh0V0S5.setInt(3, 0);
			xWh0V0S5.executeUpdate();
			fqTDSlu9.commit();
		} catch (Exception rtJBYAa7) {
			try {
				fqTDSlu9.rollback();
			} catch (SQLException Tkgdnfqb) {
			}
			log.error("insert user Error: " + rtJBYAa7.toString());
		} finally {
			DbForumFactory.closeDB(null, xWh0V0S5, null, fqTDSlu9);
		}
	}

}