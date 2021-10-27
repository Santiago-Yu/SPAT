class n3928959 {
	public static void copyFile(File STOXPPgk, File cBfmEuCl) throws IOException {
		FileInputStream eXXQrvyv = null;
		FileOutputStream s98d8YEG = null;
		try {
			eXXQrvyv = new FileInputStream(STOXPPgk);
			s98d8YEG = new FileOutputStream(cBfmEuCl);
			byte[] r0zC1fAn = new byte[1024 * 4];
			int XsAIGfWA = 0;
			while ((XsAIGfWA = eXXQrvyv.read(r0zC1fAn)) >= 0)
				s98d8YEG.write(r0zC1fAn, 0, XsAIGfWA);
		} finally {
			Streams.closeQuietly(eXXQrvyv);
			Streams.closeQuietly(s98d8YEG);
		}
	}

}