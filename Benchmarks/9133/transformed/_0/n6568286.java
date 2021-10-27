class n6568286 {
	private void getPicture(String aGtVuTDH, String yqZWKUhg) throws Exception {
		URL XUclccZz = new URL(aGtVuTDH);
		HttpURLConnection m5uHpkg3 = (HttpURLConnection) XUclccZz.openConnection();
		m5uHpkg3.setRequestMethod("GET");
		m5uHpkg3.setConnectTimeout(10000);
		if (m5uHpkg3.getResponseCode() == 200) {
			InputStream fsGLUfwX = m5uHpkg3.getInputStream();
			byte[] C1atOsS3 = readStream(fsGLUfwX);
			File eA02IkWc = new File(picDirectory + yqZWKUhg);
			FileOutputStream abQMGeQv = new FileOutputStream(eA02IkWc);
			abQMGeQv.write(C1atOsS3);
			abQMGeQv.close();
		}
		m5uHpkg3.disconnect();
	}

}