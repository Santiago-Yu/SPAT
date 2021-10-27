class n7129106 {
	protected void downloadCacheFile(File file) throws Exception {
		ApplicationProperties app = ApplicationProperties.getInstance();
		String address = app.getProperty(JabberConstants.PROPERTY_JABBER_SERVERLIST, DEFAULT_SERVER_URL);
		URL url = new URL(address);
		file.createNewFile();
		InputStream input = url.openStream();
		OutputStream cache = new FileOutputStream(file);
		int bytesRead = 0;
		byte buffer[] = new byte[1024];
		while ((bytesRead = input.read(buffer)) >= 0)
			cache.write(buffer, 0, bytesRead);
		input.close();
		cache.close();
	}

}