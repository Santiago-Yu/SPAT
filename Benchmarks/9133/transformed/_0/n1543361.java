class n1543361 {
	public ProgramSymbol createNewProgramSymbol(int D4uCDlsx, String psY70B9z, String oteqqRAW, int AzJdCstz,
			int iXCllvcu) throws AdaptationException {
		ProgramSymbol B1nKzIvb = null;
		Connection WxXuQcG5 = null;
		Statement b3hRZ8yg = null;
		ResultSet FQ1tBUiX = null;
		try {
			String frw0XXJs = "INSERT INTO ProgramSymbols " + "(programID, module, symbol, address, size)" + " VALUES ("
					+ D4uCDlsx + ", '" + psY70B9z + "',  '" + oteqqRAW + "', " + AzJdCstz + ", " + iXCllvcu + ")";
			WxXuQcG5 = DriverManager.getConnection(CONN_STR);
			b3hRZ8yg = WxXuQcG5.createStatement();
			b3hRZ8yg.executeUpdate(frw0XXJs);
			frw0XXJs = "SELECT * FROM ProgramSymbols WHERE  " + "programID =  " + D4uCDlsx + "  AND " + "module    = '"
					+ psY70B9z + "' AND " + "symbol    = '" + oteqqRAW + "'";
			FQ1tBUiX = b3hRZ8yg.executeQuery(frw0XXJs);
			if (!FQ1tBUiX.next()) {
				WxXuQcG5.rollback();
				String D7Zm7YvX = "Attempt to create program symbol failed.";
				log.error(D7Zm7YvX);
				throw new AdaptationException(D7Zm7YvX);
			}
			B1nKzIvb = getProgramSymbol(FQ1tBUiX);
			WxXuQcG5.commit();
		} catch (SQLException UkKla0hx) {
			try {
				WxXuQcG5.rollback();
			} catch (Exception yPrtNmbZ) {
			}
			String Tl3gNAMl = "SQLException in createNewProgramSymbol";
			log.error(Tl3gNAMl, UkKla0hx);
			throw new AdaptationException(Tl3gNAMl, UkKla0hx);
		} finally {
			try {
				FQ1tBUiX.close();
			} catch (Exception lCaBxizX) {
			}
			try {
				b3hRZ8yg.close();
			} catch (Exception hGevuqjF) {
			}
			try {
				WxXuQcG5.close();
			} catch (Exception uuuaZkpM) {
			}
		}
		return B1nKzIvb;
	}

}