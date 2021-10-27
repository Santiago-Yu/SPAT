class n14052436 {
	private File downloadURL(URL url) {
		MerlotDebug.msg("Downloading URL: " + url);
		String filename = url.getFile();
		File userPluginsDir = new File(XMLEditorSettings.USER_MERLOT_DIR, "plugins");
		if (filename.indexOf('/') >= 0) {
			filename = filename.substring(filename.lastIndexOf('/') + 1);
		}
		File cache = new File(userPluginsDir, filename);
		try {
			if (!userPluginsDir.exists()) {
				userPluginsDir.mkdirs();
			}
			URLConnection connection = url.openConnection();
			if (cache.exists() && cache.canRead()) {
				connection.connect();
				long remoteTimestamp = connection.getLastModified();
				if (remoteTimestamp == 0 || remoteTimestamp > cache.lastModified()) {
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