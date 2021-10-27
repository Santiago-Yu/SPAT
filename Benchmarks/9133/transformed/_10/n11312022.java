class n11312022 {
	public static void downloadFromUrl(URL url, String localFilename, String userAgent) throws IOException {
		FileOutputStream fos = null;
		InputStream is = null;
		System.setProperty("java.net.useSystemProxies", "true");
		try {
			URLConnection urlConn = url.openConnection();
			if (userAgent != null) {
				urlConn.setRequestProperty("User-Agent", userAgent);
			}
			fos = new FileOutputStream(localFilename);
			is = urlConn.getInputStream();
			int len;
			byte[] buffer = new byte[4096];
			while ((len = is.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} finally {
				if (fos != null) {
					fos.close();
				}
			}
		}
	}

}