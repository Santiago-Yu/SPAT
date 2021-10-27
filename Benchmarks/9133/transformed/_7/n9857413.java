class n9857413 {
	@Override
	public byte[] readData(byte[] options, boolean transferMetaData) throws Throwable {
		long startTime = System.currentTimeMillis();
		long transferredBytesNum = 0;
		long elapsedTime = 0;
		Properties opts = PropertiesUtils.deserializeProperties(options);
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
				filePath = filePath + (META_DATA_FILE_SUFIX);
			}
		}
		if (!server.contains(PORT_SEPARATOR)) {
			server = server + (PORT_SEPARATOR + DEFAULT_PORT);
		}
		URL url = new URL(PROTOCOL_PREFIX + username + ":" + password + "@" + server + filePath + ";type=i");
		URLConnection urlc = url.openConnection(BackEnd.getProxy(Proxy.Type.SOCKS));
		urlc.setConnectTimeout(Preferences.getInstance().preferredTimeOut * 1000);
		urlc.setReadTimeout(Preferences.getInstance().preferredTimeOut * 1000);
		ByteArrayOutputStream baos = null;
		try {
			InputStream is = urlc.getInputStream();
			baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int br;
			while ((br = is.read(buffer)) > 0) {
				baos.write(buffer, 0, br);
				if (!transferMetaData) {
					transferredBytesNum = transferredBytesNum + (br);
					elapsedTime = System.currentTimeMillis() - startTime;
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