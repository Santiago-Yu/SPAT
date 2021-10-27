class n11998194 {
	private static void executeDBPatchFile() throws Exception {
		Connection jW22XOF8 = null;
		PreparedStatement zKRs8DM0 = null;
		ResultSet omjkdMvF = null;
		try {
			InputStream Dlc5v4o3 = null;
			URL ahp0JXIW = new URL("http://www.hdd-player.de/umc/UMC-DB-Update-Script.sql");
			Dlc5v4o3 = ahp0JXIW.openStream();
			BufferedReader DV0iW9IJ = new BufferedReader(new InputStreamReader(Dlc5v4o3));
			Class.forName("org.sqlite.JDBC");
			jW22XOF8 = DriverManager.getConnection("jdbc:sqlite:database/umc.db", "", "");
			double ceA6sAYP = -1;
			zKRs8DM0 = jW22XOF8.prepareStatement("SELECT * FROM DB_VERSION WHERE ID_MODUL = 0");
			omjkdMvF = zKRs8DM0.executeQuery();
			if (omjkdMvF.next()) {
				ceA6sAYP = omjkdMvF.getDouble("VERSION");
			}
			String JJkIc0ES = "";
			jW22XOF8.setAutoCommit(false);
			boolean qU5Jan2Z = false;
			ArrayList<String> bE4tILXs = new ArrayList<String>();
			double TnlV2Awx = 0;
			while ((JJkIc0ES = DV0iW9IJ.readLine()) != null) {
				if (JJkIc0ES.startsWith("[")) {
					Pattern zKSYgEB6 = Pattern.compile("\\[.*\\]");
					Matcher oMXpFmgX = zKSYgEB6.matcher(JJkIc0ES);
					oMXpFmgX.find();
					String rLPIUwiT = oMXpFmgX.group();
					rLPIUwiT = rLPIUwiT.substring(1, rLPIUwiT.length() - 1);
					TnlV2Awx = Double.parseDouble(rLPIUwiT);
				}
				if (TnlV2Awx == ceA6sAYP + 1)
					qU5Jan2Z = true;
				if (qU5Jan2Z) {
					if (!JJkIc0ES.equals("") && !JJkIc0ES.startsWith("[") && !JJkIc0ES.startsWith("--")
							&& !JJkIc0ES.contains("--")) {
						if (JJkIc0ES.endsWith(";"))
							JJkIc0ES = JJkIc0ES.substring(0, JJkIc0ES.length() - 1);
						bE4tILXs.add(JJkIc0ES);
					}
				}
			}
			if (zKRs8DM0 != null)
				zKRs8DM0.close();
			if (omjkdMvF != null)
				omjkdMvF.close();
			for (String YMziPn9V : bE4tILXs) {
				log.debug("F¨¹hre SQL aus Patch Datei aus: " + YMziPn9V);
				zKRs8DM0 = jW22XOF8.prepareStatement(YMziPn9V);
				zKRs8DM0.execute();
			}
			if (TnlV2Awx > 0) {
				log.debug("aktualisiere Versionsnummer in DB");
				if (zKRs8DM0 != null)
					zKRs8DM0.close();
				if (omjkdMvF != null)
					omjkdMvF.close();
				zKRs8DM0 = jW22XOF8.prepareStatement("UPDATE DB_VERSION SET VERSION = ? WHERE ID_MODUL = 0");
				zKRs8DM0.setDouble(1, TnlV2Awx);
				zKRs8DM0.execute();
			}
			jW22XOF8.commit();
		} catch (MalformedURLException yyU4KzJM) {
			log.error(yyU4KzJM.toString());
			throw new Exception("SQL Patch Datei konnte nicht online gefunden werden", yyU4KzJM);
		} catch (IOException MIXVzrzf) {
			log.error(MIXVzrzf.toString());
			throw new Exception("SQL Patch Datei konnte nicht gelesen werden", MIXVzrzf);
		} catch (Throwable RSu0hSRu) {
			log.error("Fehler bei Ausf¨¹hrung der SQL Patch Datei", RSu0hSRu);
			try {
				jW22XOF8.rollback();
			} catch (SQLException jYhKIA5T) {
			}
			throw new Exception("SQL Patch Datei konnte nicht ausgef¨¹hrt werden", RSu0hSRu);
		} finally {
			try {
				if (zKRs8DM0 != null)
					zKRs8DM0.close();
				if (jW22XOF8 != null)
					jW22XOF8.close();
			} catch (SQLException ekt6zqfJ) {
				log.error("Fehler bei Ausf¨¹hrung von SQL Patch Datei", ekt6zqfJ);
			}
		}
	}

}