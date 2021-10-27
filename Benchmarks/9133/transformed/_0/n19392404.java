class n19392404 {
	public boolean setSchedule(Schedule AkUYPgvj) {
		PreparedStatement P2dy1SKS = null;
		PreparedStatement kLRlxrqD = null;
		PreparedStatement rXKndgvw = null;
		ResultSet UESw26Nz = null;
		boolean MmuKw6kL = true;
		try {
			conn = getConnection();
			P2dy1SKS = conn.prepareStatement("INSERT INTO timetable (recipe_id, time, meal) VALUES (?, ?, ?);");
			kLRlxrqD = conn.prepareStatement("SELECT * FROM timetable WHERE time BETWEEN ? AND ?");
			rXKndgvw = conn.prepareStatement("DELETE FROM timetable WHERE time = ? AND meal = ? AND recipe_id = ?");
			long mdvDjirK = AkUYPgvj.getDate().getTime();
			SimpleDateFormat TZa3aaQ5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
			Date naojLOzO = null, b4lDPBoZ = null;
			try {
				String r2RXjH27 = TZa3aaQ5.format(new java.util.Date(mdvDjirK));
				TZa3aaQ5.applyPattern("yyyy-MM-dd");
				java.util.Date agaiv3JO = TZa3aaQ5.parse(r2RXjH27);
				naojLOzO = new Date(agaiv3JO.getTime());
				b4lDPBoZ = new Date(agaiv3JO.getTime() + (24 * 3600 * 1000));
			} catch (Exception YUHpjpdN) {
				System.out
						.println("Ollos virhe saapunut, siks ohjelmamme kaatunut! --Vanha kalevalalainen sananlasku--");
				YUHpjpdN.printStackTrace();
			}
			kLRlxrqD.setDate(1, naojLOzO);
			kLRlxrqD.setDate(2, b4lDPBoZ);
			UESw26Nz = kLRlxrqD.executeQuery();
			MainFrame.appendStatusText("Poistetaan p?iv?n \"" + AkUYPgvj.getDate() + "\" vanhat reseptit kannasta");
			while (UESw26Nz.next()) {
				rXKndgvw.clearParameters();
				rXKndgvw.setTimestamp(1, UESw26Nz.getTimestamp("time"));
				rXKndgvw.setInt(2, UESw26Nz.getInt("meal"));
				rXKndgvw.setInt(3, UESw26Nz.getInt("recipe_id"));
				rXKndgvw.executeUpdate();
			}
			if (AkUYPgvj.getBreakfast() != null) {
				MainFrame.appendStatusText("Lis?t??n aamupala \"" + AkUYPgvj.getBreakfast().getName() + "\"");
				P2dy1SKS.clearParameters();
				P2dy1SKS.setInt(1, AkUYPgvj.getBreakfast().getId());
				P2dy1SKS.setTimestamp(2, new Timestamp(AkUYPgvj.getDate().getTime()));
				P2dy1SKS.setInt(3, 1);
				P2dy1SKS.executeUpdate();
			}
			if (AkUYPgvj.getLunch() != null) {
				MainFrame.appendStatusText("Lis?t??n lounas \"" + AkUYPgvj.getLunch().getName() + "\"");
				P2dy1SKS.clearParameters();
				P2dy1SKS.setInt(1, AkUYPgvj.getLunch().getId());
				P2dy1SKS.setTimestamp(2, new Timestamp(AkUYPgvj.getDate().getTime()));
				P2dy1SKS.setInt(3, 2);
				P2dy1SKS.executeUpdate();
			}
			if (AkUYPgvj.getSnack() != null) {
				MainFrame.appendStatusText("Lis?t??n v?lipala \"" + AkUYPgvj.getSnack().getName() + "\"");
				P2dy1SKS.clearParameters();
				P2dy1SKS.setInt(1, AkUYPgvj.getSnack().getId());
				P2dy1SKS.setTimestamp(2, new Timestamp(AkUYPgvj.getDate().getTime()));
				P2dy1SKS.setInt(3, 3);
				P2dy1SKS.executeUpdate();
			}
			if (AkUYPgvj.getDinner() != null) {
				MainFrame.appendStatusText("Lis?t??n p?iv?llinen \"" + AkUYPgvj.getDinner().getName() + "\"");
				P2dy1SKS.clearParameters();
				P2dy1SKS.setInt(1, AkUYPgvj.getDinner().getId());
				P2dy1SKS.setTimestamp(2, new Timestamp(AkUYPgvj.getDate().getTime()));
				P2dy1SKS.setInt(3, 4);
				P2dy1SKS.executeUpdate();
			}
			if (AkUYPgvj.getSupper() != null) {
				MainFrame.appendStatusText("Lis?t??n illallinen \"" + AkUYPgvj.getSupper().getName() + "\"");
				P2dy1SKS.clearParameters();
				P2dy1SKS.setInt(1, AkUYPgvj.getSupper().getId());
				P2dy1SKS.setTimestamp(2, new Timestamp(AkUYPgvj.getDate().getTime()));
				P2dy1SKS.setInt(3, 5);
				P2dy1SKS.executeUpdate();
			}
			conn.commit();
		} catch (Exception OTX8X0Nk) {
			try {
				conn.rollback();
			} catch (SQLException TvOlpovA) {
				MainFrame.appendStatusText("Aterioiden lis?ys ep?onnistui");
				TvOlpovA.printStackTrace();
			}
			MainFrame.appendStatusText("Can't add schedule, the exception was " + OTX8X0Nk.getMessage());
		} finally {
			try {
				if (UESw26Nz != null)
					UESw26Nz.close();
				UESw26Nz = null;
				if (P2dy1SKS != null)
					P2dy1SKS.close();
				P2dy1SKS = null;
				if (kLRlxrqD != null)
					kLRlxrqD.close();
				kLRlxrqD = null;
			} catch (SQLException dFD5ScTW) {
				MainFrame.appendStatusText("Can't close database connection.");
			}
		}
		return MmuKw6kL;
	}

}