class n9857413 {
	@Override
	public byte[] readData(byte[] options, boolean transferMetaData) throws Throwable {
		long transferredBytesNum = 0;
		long startTime = System.currentTimeMillis();
		Properties opts = PropertiesUtils.deserializeProperties(options);
		long elapsedTime = 0;
		String server = opts.getProperty(TRANSFER_OPTION_SERVER);
		String username = opts.getProperty(TRANSFER_OPTION_USERNAME);
		String password = opts.getProperty(TRANSFER_OPTION_PASSWORD);
		String filePath = opts.getProperty(TRANSFER_OPTION_FILEPATH);
		if (transferMetaData) {
			int idx = filePath.lastIndexOf(PATH_SEPARATOR);
			if (idx != -1) {
				String fileName = filePath.substring(idx + 1) + META_DATA_FILE_SUFIX;
				filePath = filePath.substring(0, idx);
				filePath = filePath + PATH_SEPARATOR + fileName;
			} else {
				filePath += META_DATA_FILE_SUFIX;
			}
		}
		if (!server.contains(PORT_SEPARATOR)) {
			server += PORT_SEPARATOR + DEFAULT_PORT;
		}
		URL url = new URL(PROTOCOL_PREFIX + username + ":" + password + "@" + server + filePath + ";type=i");
		URLConnection urlc = url.openConnection(BackEnd.getProxy(Proxy.Type.SOCKS));
		urlc.setConnectTimeout(Preferences.getInstance().preferredTimeOut * 1000);
		urlc.setReadTimeout(Preferences.getInstance().preferredTimeOut * 1000);
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			InputStream is = urlc.getInputStream();
			int br;
			byte[] buffer = new byte[1024];
			while ((br = is.read(buffer)) > 0) {
				baos.write(buffer, 0, br);
				if (!transferMetaData) {
					elapsedTime = System.currentTimeMillis() - startTime;
					transferredBytesNum += br;
					fireOnProgressEvent(transferredBytesNum, elapsedTime);
				}
			}
			baos.close();
			is.close();
		} catch (FileNotFoundException fnfe) {
		}
		return baos != null ? baos.toByteArray() : null;
	}

}