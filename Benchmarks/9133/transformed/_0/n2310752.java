class n2310752 {
	public static void copy(final String JJQwjMWy, final String nTrGbqyV) {
		final File YBMG0Pp0 = new File(JJQwjMWy);
		final File Bw0bNBw0 = new File(nTrGbqyV);
		try {
			final FileInputStream T8kdkS30 = new FileInputStream(YBMG0Pp0);
			final FileOutputStream Yhs9ViZs = new FileOutputStream(Bw0bNBw0);
			int pSm2KR2d;
			while ((pSm2KR2d = T8kdkS30.read()) != -1)
				Yhs9ViZs.write(pSm2KR2d);
			T8kdkS30.close();
			Yhs9ViZs.close();
		} catch (IOException cmSfslk2) {
			System.out.println("Error reading/writing files!");
		}
	}

}