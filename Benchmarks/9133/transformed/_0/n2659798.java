class n2659798 {
	private void duplicateTable(Connection Q9veFGe9, Connection jLweUD9X, String DBqjfxlY) {
		logger.debug("Duplicating table " + DBqjfxlY);
		Statement fEZK6byO, Dts5VAxH;
		ResultSet zysB7HSj, Cd1Vf1bk, MvV66wSq;
		int UpF9VPKI;
		String muRndsDP = "";
		PreparedStatement rUGXKeCj;
		try {
			Cd1Vf1bk = Q9veFGe9.getMetaData().getColumns(null, null, DBqjfxlY, null);
			MvV66wSq = Q9veFGe9.getMetaData().getPrimaryKeys(null, null, DBqjfxlY);
			fEZK6byO = jLweUD9X.createStatement();
			fEZK6byO.execute(getCreateTableCommand(Cd1Vf1bk, MvV66wSq));
			Dts5VAxH = Q9veFGe9.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			Dts5VAxH.setFetchSize(50);
			zysB7HSj = Dts5VAxH.executeQuery("SELECT * FROM " + DBqjfxlY);
			UpF9VPKI = zysB7HSj.getMetaData().getColumnCount();
			muRndsDP = "INSERT INTO " + DBqjfxlY + " VALUES(";
			for (int hFN9GEys = 1; hFN9GEys <= UpF9VPKI; hFN9GEys++)
				muRndsDP += "?,";
			muRndsDP = muRndsDP.substring(0, muRndsDP.length() - 1) + ")";
			logger.debug("Insert pattern " + muRndsDP);
			rUGXKeCj = jLweUD9X.prepareStatement(muRndsDP);
			while (zysB7HSj.next()) {
				for (int W9gN3Gj8 = 1; W9gN3Gj8 <= UpF9VPKI; W9gN3Gj8++)
					rUGXKeCj.setObject(W9gN3Gj8, zysB7HSj.getObject(W9gN3Gj8));
				rUGXKeCj.executeUpdate();
			}
			jLweUD9X.commit();
		} catch (Exception iqC20XPt) {
			logger.error("Unable to copy table " + DBqjfxlY + ": " + iqC20XPt);
			try {
				jLweUD9X.rollback();
			} catch (SQLException QEgKWwz4) {
				logger.fatal(QEgKWwz4);
			}
		}
	}

}