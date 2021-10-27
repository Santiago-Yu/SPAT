class n3621718 {
	public void initURL(URL url, boolean cache) throws IOException {
		this.url = url;
		if (!(cache))
			;
		else {
			System.out.println(getClass().getName() + ": caching '" + url + "'");
			InputStream urlIS = new BufferedInputStream(url.openStream(), 1024 * 30);
			file = File.createTempFile("_dss_", "_dss_");
			file.deleteOnExit();
			OutputStream cachedOS = new BufferedOutputStream(new FileOutputStream(file), 1024 * 30);
			byte[] buf = new byte[1024 * 4];
			long cachedBytesCount = 0;
			int count = 0;
			while ((count = urlIS.read(buf)) > 0) {
				cachedOS.write(buf, 0, count);
				cachedBytesCount += count;
			}
			urlIS.close();
			cachedOS.flush();
			cachedOS.close();
			this.cached = true;
			System.out.println(getClass().getName() + ": cached " + cachedBytesCount + " bytes into '"
					+ file.getAbsolutePath() + "'");
		}
	}

}