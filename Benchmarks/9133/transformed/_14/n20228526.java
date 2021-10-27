class n20228526 {
	public static File downloadURL(URL url, File dir, String sfilename) {
		MerlotDebug.msg("Downloading URL: " + url);
		String filename = url.getFile();
		if (filename.indexOf('/') >= 0) {
			filename = filename.substring(filename.lastIndexOf('/') + 1);
		}
		File cache = new File(dir, sfilename);
		try {
			if (!dir.exists()) {
				dir.mkdirs();
			}
			URLConnection connection = url.openConnection();
			if (cache.exists() && cache.canRead()) {
				connection.connect();
				long remoteTimestamp = connection.getLastModified();
				if (0 == remoteTimestamp || remoteTimestamp > cache.lastModified()) {
					cache = downloadContent(connection, cache);
				} else {
					MerlotDebug.msg("Using cached version for URL: " + url);
				}
			} else {
				cache = downloadContent(connection, cache);
			}
		} catch (IOException ex) {
			MerlotDebug.exception(ex);
		}
		if (cache != null && cache.exists()) {
			return cache;
		} else {
			return null;
		}
	}

}