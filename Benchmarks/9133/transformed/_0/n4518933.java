class n4518933 {
	public static boolean encodeFileToFile(String rpVbq2YL, String K0NtzGVl) {
		boolean yn1powrV = false;
		java.io.InputStream cU7zWLMH = null;
		java.io.OutputStream N59cQ09v = null;
		try {
			cU7zWLMH = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(rpVbq2YL)),
					Base64.ENCODE);
			N59cQ09v = new java.io.BufferedOutputStream(new java.io.FileOutputStream(K0NtzGVl));
			byte[] WWQwmALm = new byte[65536];
			int JRLBsJZj = -1;
			while ((JRLBsJZj = cU7zWLMH.read(WWQwmALm)) >= 0) {
				N59cQ09v.write(WWQwmALm, 0, JRLBsJZj);
			}
			yn1powrV = true;
		} catch (java.io.IOException BAvk9MZt) {
			BAvk9MZt.printStackTrace();
		} finally {
			try {
				cU7zWLMH.close();
			} catch (Exception BUQbmTDF) {
			}
			try {
				N59cQ09v.close();
			} catch (Exception AEPS5BTB) {
			}
		}
		return yn1powrV;
	}

}