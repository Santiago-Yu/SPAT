class n14504556 {
	public void doNew(Vector HUnLtvC6, String mjmyhiRA, String JyCNWBPz) throws AddrException {
		DBOperation q5z2ImAh = null;
		Connection yOn0JtNr = null;
		PreparedStatement BPsVjlBr = null;
		ResultSet nt9jXWUH = null;
		String Ty9xrAir = "insert into " + SHARE_TABLE + " values(?,?,?)";
		try {
			q5z2ImAh = createDBOperation();
			yOn0JtNr = q5z2ImAh.getConnection();
			yOn0JtNr.setAutoCommit(false);
			for (int yZdlIsOL = 0; yZdlIsOL < HUnLtvC6.size(); yZdlIsOL++) {
				String Eu2hLSPS = (String) HUnLtvC6.elementAt(yZdlIsOL);
				BPsVjlBr = yOn0JtNr.prepareStatement(Ty9xrAir);
				BPsVjlBr.setInt(1, Integer.parseInt(JyCNWBPz));
				BPsVjlBr.setInt(2, Integer.parseInt(Eu2hLSPS));
				BPsVjlBr.setString(3, mjmyhiRA);
				int HyYuBlYb = BPsVjlBr.executeUpdate();
				if (HyYuBlYb != 1) {
					throw new Exception("error");
				}
			}
			yOn0JtNr.commit();
		} catch (Exception qlhjFkRr) {
			if (yOn0JtNr != null) {
				try {
					yOn0JtNr.rollback();
				} catch (SQLException afLfefpM) {
					afLfefpM.printStackTrace();
				}
			}
			logger.error("???????????????????, " + qlhjFkRr.getMessage());
			throw new AddrException("???????????????????,???????????????????????????!");
		} finally {
			close(nt9jXWUH, null, BPsVjlBr, yOn0JtNr, q5z2ImAh);
		}
	}

}