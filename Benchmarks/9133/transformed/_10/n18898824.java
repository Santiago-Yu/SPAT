class n18898824 {
	public void getFile(String srcFile, String destFile) {
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		URL url = null;
		HttpURLConnection conn = null;
		int size = 0;
		byte[] buf = new byte[8096];
		try {
			url = new URL(srcFile);
			conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			fos = new FileOutputStream(destFile);
			bis = new BufferedInputStream(conn.getInputStream());
			while ((size = bis.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}
			fos.close();
			bis.close();
		} catch (MalformedURLException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		} finally {
			conn.disconnect();
		}
	}

}