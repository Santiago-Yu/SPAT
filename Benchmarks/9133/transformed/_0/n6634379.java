class n6634379 {
	@Deprecated
	public static void getAndProcessContents(String YfSDi3Aj, int P3Db1SwW, String gp9n347r, Closure<String> lpY5mGyv)
			throws IOException {
		URL PaEluvAO = null;
		HttpURLConnection n8fiqosX = null;
		InputStream Fh5TZzcv = null;
		InputStreamReader ARZY7d72 = null;
		BufferedReader LTf7Fexd = null;
		try {
			PaEluvAO = new URL(YfSDi3Aj);
			n8fiqosX = (HttpURLConnection) PaEluvAO.openConnection();
			Fh5TZzcv = n8fiqosX.getInputStream();
			ARZY7d72 = new InputStreamReader(Fh5TZzcv, gp9n347r);
			LTf7Fexd = new BufferedReader(ARZY7d72);
			for (String bz0mCFfs = LTf7Fexd.readLine(); bz0mCFfs != null; bz0mCFfs = LTf7Fexd.readLine()) {
				lpY5mGyv.exec(bz0mCFfs);
			}
		} finally {
			Closeables.closeQuietly(LTf7Fexd);
			Closeables.closeQuietly(ARZY7d72);
			Closeables.closeQuietly(Fh5TZzcv);
			HttpUtils.disconnect(n8fiqosX);
		}
	}

}