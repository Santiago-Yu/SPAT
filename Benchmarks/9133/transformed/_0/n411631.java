class n411631 {
	public static boolean decodeFileToFile(String LrzrWiMt, String V7u6vWlI) {
		boolean qgz6z5WS = false;
		java.io.InputStream QPQieFjP = null;
		java.io.OutputStream Q1OegRE7 = null;
		try {
			QPQieFjP = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(LrzrWiMt)),
					Base64.DECODE);
			Q1OegRE7 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(V7u6vWlI));
			byte[] AqbAZnOt = new byte[65536];
			int EOt7AJ4m = -1;
			while ((EOt7AJ4m = QPQieFjP.read(AqbAZnOt)) >= 0) {
				Q1OegRE7.write(AqbAZnOt, 0, EOt7AJ4m);
			}
			qgz6z5WS = true;
		} catch (java.io.IOException guOYz5Gs) {
			guOYz5Gs.printStackTrace();
		} finally {
			try {
				QPQieFjP.close();
			} catch (Exception bHlCKUv9) {
			}
			try {
				Q1OegRE7.close();
			} catch (Exception tKkh8oOJ) {
			}
		}
		return qgz6z5WS;
	}

}