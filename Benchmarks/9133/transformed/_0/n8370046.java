class n8370046 {
	public static String downloadJar(URL aCeECKRh) throws IOException {
		String Z6EBkHEx = null;
		char[] hm6auIUw = new char[4096];
		int Jwxftkl8;
		Z6EBkHEx = Settings.getFreeTsUserPath() + "lib" + Settings.SLASH + getURLFileName(aCeECKRh);
		DebugDialog.print("Downloading jar-file " + aCeECKRh + " to " + Z6EBkHEx + ".", 4);
		InputStreamReader pQNvwPub = new InputStreamReader(aCeECKRh.openStream());
		OutputStreamWriter y3aiN5Rj = new OutputStreamWriter(new FileOutputStream(Z6EBkHEx));
		do {
			Jwxftkl8 = pQNvwPub.read(hm6auIUw, 0, 4096);
			if (Jwxftkl8 > 0) {
				y3aiN5Rj.write(hm6auIUw, 0, Jwxftkl8);
			}
		} while (Jwxftkl8 > 0);
		pQNvwPub.close();
		y3aiN5Rj.close();
		return Z6EBkHEx;
	}

}