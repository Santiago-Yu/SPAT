class n16294877 {
	public static void copierFichier(URL BcUn0WMT, File s56tvWKq) throws CopieException, IOException {
		if (s56tvWKq.exists()) {
			throw new CopieException("ERREUR : Copie du fichier '" + BcUn0WMT.getPath() + "' vers '"
					+ s56tvWKq.getPath() + "' impossible!\n" + "CAUSE  : Le fichier destination existe d?j?.");
		}
		URLConnection OqltZwfr = BcUn0WMT.openConnection();
		InputStream WaRAjX86 = OqltZwfr.getInputStream();
		FileOutputStream ecYugIJ5 = new FileOutputStream(s56tvWKq);
		byte MnJEn9M3[] = new byte[512 * 1024];
		int nOnOiqRn;
		while ((nOnOiqRn = WaRAjX86.read(MnJEn9M3)) != -1) {
			ecYugIJ5.write(MnJEn9M3, 0, nOnOiqRn);
		}
		log.debug("(COPIE) Copie du fichier : " + BcUn0WMT.getPath() + " --> " + s56tvWKq.getPath());
		WaRAjX86.close();
		ecYugIJ5.close();
	}

}