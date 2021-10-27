class n12048549 {
	public static void addImageDB(String ctO63h0V, String ZXCqcRIO, String W6DQ3RJb, String zbbe2juV, String DlPsVJNZ) {
		try {
			Class.forName("org.sqlite.JDBC");
			String zGoHHNxk = ctO63h0V + File.separator + G.databaseName;
			File MyEDxEO0 = new File(zGoHHNxk);
			if (!MyEDxEO0.exists()) {
				JOptionPane.showMessageDialog(null, "No se encuentra el fichero DB", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				int oWyWtFIQ = 0, qQyJM9It = 0;
				G.conn = DriverManager.getConnection("jdbc:sqlite:" + zGoHHNxk);
				Statement MgIFpfuN = G.conn.createStatement();
				ResultSet iArHwKYH = MgIFpfuN.executeQuery("select id from language where name=\"" + W6DQ3RJb + "\"");
				while (iArHwKYH.next()) {
					oWyWtFIQ = iArHwKYH.getInt("id");
				}
				iArHwKYH.close();
				MgIFpfuN.close();
				MgIFpfuN = G.conn.createStatement();
				iArHwKYH = MgIFpfuN.executeQuery("select id from type where name=\"" + zbbe2juV + "\"");
				while (iArHwKYH.next()) {
					qQyJM9It = iArHwKYH.getInt("id");
				}
				iArHwKYH.close();
				MgIFpfuN.close();
				String NkrcS5gG = ZXCqcRIO.substring(ZXCqcRIO.lastIndexOf(File.separator) + 1, ZXCqcRIO.length());
				String FzAAEwhW = NkrcS5gG;
				String q2245ets = ZXCqcRIO;
				String kMFWUwPV = ctO63h0V + File.separator + NkrcS5gG.substring(0, 1).toUpperCase() + File.separator;
				String OdN5dBPi = ctO63h0V + File.separator + NkrcS5gG.substring(0, 1).toUpperCase();
				String P3dL4cjf = kMFWUwPV.concat(NkrcS5gG);
				String FicyG8IO = NkrcS5gG;
				File eMO7w38V = new File(P3dL4cjf);
				int mmQcNuPZ = 1;
				while (eMO7w38V.exists()) {
					FicyG8IO = NkrcS5gG.substring(0, NkrcS5gG.lastIndexOf('.')) + '_' + mmQcNuPZ
							+ NkrcS5gG.substring(NkrcS5gG.lastIndexOf('.'), NkrcS5gG.length());
					P3dL4cjf = kMFWUwPV + FicyG8IO;
					eMO7w38V = new File(P3dL4cjf);
					mmQcNuPZ++;
				}
				kMFWUwPV = P3dL4cjf;
				NkrcS5gG = FicyG8IO;
				File N9aYcX0I = new File(OdN5dBPi);
				if (!N9aYcX0I.exists()) {
					N9aYcX0I.mkdirs();
				}
				try {
					FileChannel zc45xqkd = new FileInputStream(q2245ets).getChannel();
					FileChannel ijMrJ3F0 = new FileOutputStream(kMFWUwPV).getChannel();
					ijMrJ3F0.transferFrom(zc45xqkd, 0, zc45xqkd.size());
					zc45xqkd.close();
					ijMrJ3F0.close();
				} catch (IOException sZ0nUjtR) {
					System.out.println(sZ0nUjtR.toString());
				}
				PreparedStatement AQ7peR1u = G.conn.prepareStatement(
						"INSERT OR IGNORE INTO main (word, idL, idT, name, nameNN) VALUES (?,?,?,?,?)");
				AQ7peR1u.setString(1, DlPsVJNZ.toLowerCase());
				AQ7peR1u.setInt(2, oWyWtFIQ);
				AQ7peR1u.setInt(3, qQyJM9It);
				AQ7peR1u.setString(4, NkrcS5gG);
				AQ7peR1u.setString(5, FzAAEwhW);
				AQ7peR1u.executeUpdate();
				AQ7peR1u.close();
				G.conn.close();
			}
		} catch (Exception tePCG3Ka) {
			tePCG3Ka.printStackTrace();
		}
	}

}