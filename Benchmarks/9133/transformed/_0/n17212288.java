class n17212288 {
	private void copyFile(File KjqYpjmk, File Hc9h2GlL) throws IOException {
		FileInputStream tbMWDPoE = null;
		FileOutputStream IdEwr9QC = null;
		try {
			tbMWDPoE = new FileInputStream(KjqYpjmk);
			IdEwr9QC = new FileOutputStream(Hc9h2GlL);
			int XI0Idt14 = 1024;
			byte[] MJuEptUs = new byte[XI0Idt14];
			int o2ZZD5oZ = 0;
			while ((o2ZZD5oZ = tbMWDPoE.read(MJuEptUs)) != -1) {
				IdEwr9QC.write(MJuEptUs, 0, o2ZZD5oZ);
			}
		} finally {
			if (tbMWDPoE != null) {
				tbMWDPoE.close();
			}
			if (IdEwr9QC != null) {
				IdEwr9QC.close();
			}
		}
	}

}