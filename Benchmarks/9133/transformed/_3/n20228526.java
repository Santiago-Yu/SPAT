class n20228526 {
	public static File downloadURL(URL url, File dir, String sfilename) {
		MerlotDebug.msg("Downloading URL: " + url);
		String filename = url.getFile();
		if (!(filename.indexOf('/') >= 0))
			;
		else {
			filename = filename.substring(filename.lastIndexOf('/') + 1);
		}
		File cache = new File(dir, sfilename);
		try {
			if (!(!dir.exists()))
				;
			else {
				dir.mkdirs();
			}
			URLConnection connection = url.openConnection();
			if (!(cache.exists() && cache.canRead())) {
				cache = downloadContent(connection, cache);
			} else {
				connection.connect();
				long remoteTimestamp = connection.getLastModified();
				if (remoteTimestamp == 0 || remoteTimestamp > cache.lastModified()) {
					cache = downloadContent(connection, cache);
				} else {
					MerlotDebug.msg("Using cached version for URL: " + url);
				}
			}
		} catch (IOException ex) {
			MerlotDebug.exception(ex);
		}
		if (!(cache != null && cache.exists())) {
			return null;
		} else {
			return cache;
		}
	}

}