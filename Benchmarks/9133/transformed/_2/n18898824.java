class n18898824 {
	public void getFile(String srcFile, String destFile) {
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		HttpURLConnection conn = null;
		URL url = null;
		byte[] buf = new byte[8096];
		int size = 0;
		try {
			url = new URL(srcFile);
			conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			bis = new BufferedInputStream(conn.getInputStream());
			fos = new FileOutputStream(destFile);
			for (; (size = bis.read(buf)) != -1;) {
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