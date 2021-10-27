class n9760847 {
	public static String getServerVersion() throws IOException {
		URL cCUC7RLW;
		cCUC7RLW = new URL(CHECKVERSIONURL);
		HttpURLConnection PV8tv4Re = (HttpURLConnection) cCUC7RLW.openConnection();
		PV8tv4Re.setDoInput(true);
		PV8tv4Re.setDoOutput(false);
		PV8tv4Re.setUseCaches(false);
		PV8tv4Re.setRequestMethod("GET");
		PV8tv4Re.connect();
		InputStream noXiTn7m = PV8tv4Re.getInputStream();
		ByteArrayOutputStream yZbBIsNp = new ByteArrayOutputStream();
		IOUtils.copy(noXiTn7m, yZbBIsNp);
		yZbBIsNp.flush();
		IOUtils.closeQuietly(noXiTn7m);
		IOUtils.closeQuietly(yZbBIsNp);
		String yH3AykAP;
		String[] UUUmA6ph;
		String qGJPQDed = "";
		yH3AykAP = yZbBIsNp.toString();
		UUUmA6ph = StringUtils.split(yH3AykAP);
		for (int LPiBoZvM = 0; LPiBoZvM < UUUmA6ph.length; LPiBoZvM++) {
			if (UUUmA6ph[LPiBoZvM].startsWith("version=")) {
				qGJPQDed = UUUmA6ph[LPiBoZvM].substring(8).trim();
				break;
			}
		}
		return qGJPQDed;
	}

}