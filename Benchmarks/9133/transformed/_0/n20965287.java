class n20965287 {
	public float stampPerson(PEntry cMCRPcoA) throws SQLException {
		conn.setAutoCommit(false);
		float Nljr2eBi;
		try {
			Statement MDnz7OtM = conn.createStatement();
			ResultSet pO6JULf1 = MDnz7OtM.executeQuery("SELECT now();");
			pO6JULf1.next();
			Timestamp nIrkp5md = pO6JULf1.getTimestamp("now()");
			Calendar lvWS12WM = new GregorianCalendar();
			lvWS12WM.setTime(nIrkp5md);
			if (cMCRPcoA.getState() != 0) {
				for (int y4kb1o33 = 0; y4kb1o33 < cMCRPcoA.getOpenItems().size(); y4kb1o33++) {
					Workitem i8io0ctE = (Workitem) cMCRPcoA.getOpenItems().get(y4kb1o33);
					long Ord3FiIF = nIrkp5md.getTime() - i8io0ctE.getIntime();
					float uXZ78HBD = Ord3FiIF * (float) 1f / cMCRPcoA.getOpenItems().size();
					MDnz7OtM.executeUpdate("UPDATE stampzk SET outtime='" + nIrkp5md.getTime() + "', diff='" + Ord3FiIF
							+ "', diffp='" + uXZ78HBD + "' WHERE stampzkid='" + i8io0ctE.getStampZkId() + "';");
				}
				pO6JULf1 = MDnz7OtM.executeQuery(
						"SELECT intime FROM stamppersonal WHERE stamppersonalid='" + cMCRPcoA.getState() + "';");
				pO6JULf1.next();
				long kPUlhdQG = pO6JULf1.getLong("intime");
				long JlPuwovP = (nIrkp5md.getTime() - kPUlhdQG);
				MDnz7OtM.executeUpdate("UPDATE stamppersonal SET outtime='" + nIrkp5md.getTime() + "', diff='"
						+ JlPuwovP + "' WHERE stamppersonalid='" + cMCRPcoA.getState() + "';");
				MDnz7OtM.executeUpdate(
						"UPDATE personal SET stamppersonalid='0' WHERE personalnr='" + cMCRPcoA.getPersonalId() + "';");
				MDnz7OtM.executeUpdate("UPDATE personalyearworktime SET worktime=worktime+"
						+ (float) JlPuwovP / 3600000f + " WHERE year=" + lvWS12WM.get(Calendar.YEAR)
						+ " AND personalid='" + cMCRPcoA.getPersonalId() + "';");
				pO6JULf1 = MDnz7OtM.executeQuery("SELECT SUM(diff) AS twt FROM stamppersonal WHERE personalid='"
						+ cMCRPcoA.getPersonalId() + "' AND datum='" + lvWS12WM.get(Calendar.YEAR) + "-"
						+ (lvWS12WM.get(Calendar.MONTH) + 1) + "-" + lvWS12WM.get(Calendar.DAY_OF_MONTH) + "';");
				pO6JULf1.next();
				Nljr2eBi = (float) pO6JULf1.getInt("twt") / 3600000f;
			} else {
				MDnz7OtM.executeUpdate("INSERT INTO stamppersonal SET personalid='" + cMCRPcoA.getPersonalId()
						+ "', intime='" + nIrkp5md.getTime() + "', datum='" + lvWS12WM.get(Calendar.YEAR) + "-"
						+ (lvWS12WM.get(Calendar.MONTH) + 1) + "-" + lvWS12WM.get(Calendar.DAY_OF_MONTH) + "';");
				pO6JULf1 = MDnz7OtM.executeQuery("SELECT stamppersonalid FROM stamppersonal WHERE personalid='"
						+ cMCRPcoA.getPersonalId() + "' AND outtime='0' ORDER BY stamppersonalid DESC LIMIT 1;");
				pO6JULf1.next();
				int HX92DNWO = pO6JULf1.getInt("stamppersonalid");
				MDnz7OtM.executeUpdate("UPDATE personal SET stamppersonalid='" + HX92DNWO + "' WHERE personalnr='"
						+ cMCRPcoA.getPersonalId() + "';");
				Calendar h1B09tAv = new GregorianCalendar();
				h1B09tAv.setTime(nIrkp5md);
				h1B09tAv.add(Calendar.DAY_OF_YEAR, -1);
				pO6JULf1 = MDnz7OtM.executeQuery("SELECT SUM(diff) AS twt FROM stamppersonal WHERE personalid='"
						+ cMCRPcoA.getPersonalId() + "' AND datum='" + lvWS12WM.get(Calendar.YEAR) + "-"
						+ (lvWS12WM.get(Calendar.MONTH) + 1) + "-" + lvWS12WM.get(Calendar.DAY_OF_MONTH) + "';");
				pO6JULf1.next();
				float nigGiSnk = (float) pO6JULf1.getInt("twt") / 3600000f;
				pO6JULf1 = MDnz7OtM.executeQuery("SELECT worktime FROM personalyearworktime WHERE personalid='"
						+ cMCRPcoA.getPersonalId() + "' AND year='" + lvWS12WM.get(Calendar.YEAR) + "';");
				pO6JULf1.next();
				float hwpUBysA = pO6JULf1.getFloat("worktime") - nigGiSnk;
				pO6JULf1 = MDnz7OtM.executeQuery("SELECT duetime FROM dueworktime WHERE datum='"
						+ h1B09tAv.get(Calendar.YEAR) + "-" + (h1B09tAv.get(Calendar.MONTH) + 1) + "-"
						+ h1B09tAv.get(Calendar.DAY_OF_MONTH) + "' AND personalid='" + cMCRPcoA.getPersonalId() + "';");
				pO6JULf1.next();
				Nljr2eBi = hwpUBysA - pO6JULf1.getFloat("duetime");
			}
		} catch (SQLException uDHJp8Zv) {
			conn.rollback();
			conn.setAutoCommit(true);
			throw uDHJp8Zv;
		}
		conn.commit();
		conn.setAutoCommit(true);
		return Nljr2eBi;
	}

}