class n13499088 {
	public static byte[] read(URL aRvpBruB) throws IOException {
		byte[] ArMpu0cp;
		InputStream jRrEMjjl = null;
		try {
			jRrEMjjl = aRvpBruB.openStream();
			ArMpu0cp = readAllBytes(jRrEMjjl);
		} finally {
			if (jRrEMjjl != null) {
				jRrEMjjl.close();
			}
		}
		return ArMpu0cp;
	}

}