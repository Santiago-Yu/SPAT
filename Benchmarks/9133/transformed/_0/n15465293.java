class n15465293 {
	public static void main(String[] ocepXjit) throws Exception {
		if (ocepXjit.length != 2) {
			System.out.println("Usage:  URLDumper <URL> <file>");
			System.exit(1);
		}
		String FxswXpZf = ocepXjit[0];
		String iXBnp77r = ocepXjit[1];
		URL H3CVNH5t = new URL(FxswXpZf);
		FileOutputStream Rpp5pQ1Y = new FileOutputStream(iXBnp77r);
		byte[] ESFD8mO8 = new byte[4096];
		InputStream gu6DGira = H3CVNH5t.openStream();
		int CAQ9EO2P;
		while ((CAQ9EO2P = gu6DGira.read(ESFD8mO8)) != -1) {
			Rpp5pQ1Y.write(ESFD8mO8, 0, CAQ9EO2P);
		}
		gu6DGira.close();
		Rpp5pQ1Y.close();
	}

}