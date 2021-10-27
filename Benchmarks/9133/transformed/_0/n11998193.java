class n11998193 {
	private static void executeSQLScript() {
		File utAOHG4W = new File(System.getProperty("user.dir") + "/resources/umc.sql");
		if (utAOHG4W.exists()) {
			Connection BKtowUdZ = null;
			PreparedStatement BpLhMYM0 = null;
			try {
				Class.forName("org.sqlite.JDBC");
				BKtowUdZ = DriverManager.getConnection("jdbc:sqlite:database/umc.db", "", "");
				BufferedReader U4abbvjd = new BufferedReader(new FileReader(utAOHG4W));
				String mxtjNn2i = "";
				BKtowUdZ.setAutoCommit(false);
				while ((mxtjNn2i = U4abbvjd.readLine()) != null) {
					if (!mxtjNn2i.equals("") && !mxtjNn2i.startsWith("--") && !mxtjNn2i.contains("--")) {
						log.debug(mxtjNn2i);
						BpLhMYM0 = BKtowUdZ.prepareStatement(mxtjNn2i);
						BpLhMYM0.executeUpdate();
					}
				}
				BKtowUdZ.commit();
				File KeCI19tr = new File(utAOHG4W.getAbsolutePath() + ".executed");
				if (KeCI19tr.exists())
					KeCI19tr.delete();
				utAOHG4W.renameTo(KeCI19tr);
				utAOHG4W.delete();
			} catch (Throwable ZJbH4rfh) {
				log.error("Fehler bei Ausf¨¹hrung der SQL Datei", ZJbH4rfh);
				try {
					BKtowUdZ.rollback();
				} catch (SQLException vh8k4QgV) {
				}
			} finally {
				try {
					if (BpLhMYM0 != null)
						BpLhMYM0.close();
					if (BKtowUdZ != null)
						BKtowUdZ.close();
				} catch (SQLException NYlwWK9Q) {
					log.error("Fehler bei Ausf¨¹hrung von SQL Datei", NYlwWK9Q);
				}
			}
		}
	}

}