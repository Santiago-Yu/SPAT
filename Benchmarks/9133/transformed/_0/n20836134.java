class n20836134 {
	public void addUser(String gZSdiVKP, String pdSYpsPU, boolean qd4fu1Bc) throws Exception {
		Connection k2tMdDwD = null;
		PreparedStatement SZ97Nx1H = null;
		try {
			k2tMdDwD = DbForumFactory.getConnection();
			k2tMdDwD.setAutoCommit(false);
			int V7B2FQyr = DbSequenceManager.nextID(DbSequenceManager.USER);
			SZ97Nx1H = k2tMdDwD.prepareStatement(INSERT_USER);
			SZ97Nx1H.setString(1, gZSdiVKP);
			if (qd4fu1Bc) {
				SZ97Nx1H.setString(2, SecurityUtil.md5ByHex(pdSYpsPU));
			} else {
				SZ97Nx1H.setString(2, pdSYpsPU);
			}
			SZ97Nx1H.setString(3, "");
			SZ97Nx1H.setString(4, "");
			SZ97Nx1H.setString(5, "");
			SZ97Nx1H.setString(6, "");
			SZ97Nx1H.setString(7, "");
			SZ97Nx1H.setInt(8, V7B2FQyr);
			SZ97Nx1H.executeUpdate();
			SZ97Nx1H.clearParameters();
			SZ97Nx1H = k2tMdDwD.prepareStatement(INSERT_USERPROPS);
			SZ97Nx1H.setString(1, "");
			SZ97Nx1H.setString(2, "");
			SZ97Nx1H.setString(3, "");
			SZ97Nx1H.setInt(4, 0);
			SZ97Nx1H.setString(5, "");
			SZ97Nx1H.setInt(6, 0);
			SZ97Nx1H.setInt(7, 0);
			SZ97Nx1H.setString(8, "");
			SZ97Nx1H.setString(9, "");
			SZ97Nx1H.setString(10, "");
			SZ97Nx1H.setInt(11, 0);
			SZ97Nx1H.setInt(12, 0);
			SZ97Nx1H.setInt(13, 0);
			SZ97Nx1H.setInt(14, 0);
			SZ97Nx1H.setString(15, "");
			SZ97Nx1H.setString(16, "");
			SZ97Nx1H.setString(17, "");
			SZ97Nx1H.setString(18, "");
			SZ97Nx1H.setString(19, "");
			SZ97Nx1H.setString(20, "");
			SZ97Nx1H.setString(21, "");
			SZ97Nx1H.setString(22, "");
			SZ97Nx1H.setString(23, "");
			SZ97Nx1H.setInt(24, 0);
			SZ97Nx1H.setInt(25, 0);
			SZ97Nx1H.setInt(26, V7B2FQyr);
			SZ97Nx1H.executeUpdate();
			SZ97Nx1H.clearParameters();
			SZ97Nx1H = k2tMdDwD.prepareStatement(INSTER_USERGROUP);
			SZ97Nx1H.setInt(1, 4);
			SZ97Nx1H.setInt(2, V7B2FQyr);
			SZ97Nx1H.setInt(3, 0);
			SZ97Nx1H.executeUpdate();
			k2tMdDwD.commit();
		} catch (Exception n2ETOw5p) {
			try {
				k2tMdDwD.rollback();
			} catch (SQLException ViOO2Rl4) {
			}
			log.error("insert user Error: " + n2ETOw5p.toString());
		} finally {
			DbForumFactory.closeDB(null, SZ97Nx1H, null, k2tMdDwD);
		}
	}

}