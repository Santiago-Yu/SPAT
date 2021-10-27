class n11358169 {
	public void backupFile(File fHa3Tfc4, File x8gHuPcB) {
		FileInputStream YIUVyMpX = null;
		FileOutputStream NO4gnX1I = null;
		try {
			YIUVyMpX = new FileInputStream(fHa3Tfc4);
			NO4gnX1I = new FileOutputStream(x8gHuPcB);
			byte[] Boe4dTG6 = new byte[4096];
			int yzadOhyc;
			while ((yzadOhyc = YIUVyMpX.read(Boe4dTG6)) != -1)
				NO4gnX1I.write(Boe4dTG6, 0, yzadOhyc);
		} catch (IOException N0Lnqbwm) {
			log.error(N0Lnqbwm.getMessage());
		} finally {
			if (YIUVyMpX != null)
				try {
					YIUVyMpX.close();
				} catch (IOException qc1Shjnn) {
					log.error(qc1Shjnn.getMessage());
				}
			if (NO4gnX1I != null)
				try {
					NO4gnX1I.close();
				} catch (IOException nza7d4hq) {
					log.error(nza7d4hq.getMessage());
				}
		}
	}

}