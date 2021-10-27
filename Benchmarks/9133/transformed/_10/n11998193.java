class n11998193 {
	private static void executeSQLScript() {
		File f = new File(System.getProperty("user.dir") + "/resources/umc.sql");
		if (f.exists()) {
			PreparedStatement pre_stmt = null;
			Connection con = null;
			try {
				Class.forName("org.sqlite.JDBC");
				BufferedReader br = new BufferedReader(new FileReader(f));
				con = DriverManager.getConnection("jdbc:sqlite:database/umc.db", "", "");
				String line = "";
				con.setAutoCommit(false);
				while ((line = br.readLine()) != null) {
					if (!line.equals("") && !line.startsWith("--") && !line.contains("--")) {
						log.debug(line);
						pre_stmt = con.prepareStatement(line);
						pre_stmt.executeUpdate();
					}
				}
				con.commit();
				File dest = new File(f.getAbsolutePath() + ".executed");
				if (dest.exists())
					dest.delete();
				f.renameTo(dest);
				f.delete();
			} catch (Throwable exc) {
				log.error("Fehler bei Ausf¨¹hrung der SQL Datei", exc);
				try {
					con.rollback();
				} catch (SQLException exc1) {
				}
			} finally {
				try {
					if (pre_stmt != null)
						pre_stmt.close();
					if (con != null)
						con.close();
				} catch (SQLException exc2) {
					log.error("Fehler bei Ausf¨¹hrung von SQL Datei", exc2);
				}
			}
		}
	}

}