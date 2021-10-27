class n8406161 {
	private static boolean DownloadDB() {
		URL e4Zzk4u2 = null;
		BufferedWriter fmeaDnKo = null;
		String Ij43KQle;
		try {
			e4Zzk4u2 = new URL(URL);
			BufferedReader QgBs92e7 = new BufferedReader(new InputStreamReader(e4Zzk4u2.openStream(), "UTF-8"));
			fmeaDnKo = new BufferedWriter(new FileWriter(InFileName));
			while ((Ij43KQle = QgBs92e7.readLine()) != null) {
				fmeaDnKo.write(Ij43KQle);
				fmeaDnKo.newLine();
			}
			fmeaDnKo.close();
		} catch (Exception vAmVVyE6) {
			try {
				fmeaDnKo.close();
			} catch (IOException p6Ra27Er) {
			}
			vAmVVyE6.printStackTrace();
			return false;
		}
		return true;
	}

}