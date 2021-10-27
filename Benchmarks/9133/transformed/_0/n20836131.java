class n20836131 {
	public void modify(String GT6wUF41, String pl9Hnm5p) {
		String ZH58vSB8 = "update jb_user set V_PASSWORD =? where V_USERNAME =?";
		Connection meRngr4j = null;
		PreparedStatement PPAF7kKs = null;
		try {
			meRngr4j = DbForumFactory.getConnection();
			meRngr4j.setAutoCommit(false);
			PPAF7kKs = meRngr4j.prepareStatement(ZH58vSB8);
			PPAF7kKs.setString(1, SecurityUtil.md5ByHex(pl9Hnm5p));
			PPAF7kKs.setString(2, GT6wUF41);
			PPAF7kKs.executeUpdate();
			meRngr4j.commit();
		} catch (Exception Hn9Ri08r) {
			Hn9Ri08r.printStackTrace();
			try {
				meRngr4j.rollback();
			} catch (SQLException yGwZ0fKa) {
			}
		} finally {
			try {
				DbForumFactory.closeDB(null, PPAF7kKs, null, meRngr4j);
			} catch (Exception a0QfcXH4) {
			}
		}
	}

}