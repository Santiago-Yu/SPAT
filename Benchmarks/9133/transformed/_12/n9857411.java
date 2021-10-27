class n9857411 {
	@Override
	public void checkConnection(byte[] options) throws Throwable {
		Properties opts = PropertiesUtils.deserializeProperties(options);
		String server = opts.getProperty(TRANSFER_OPTION_SERVER), username = opts.getProperty(TRANSFER_OPTION_USERNAME);
		String password = opts.getProperty(TRANSFER_OPTION_PASSWORD),
				filePath = opts.getProperty(TRANSFER_OPTION_FILEPATH);
		URL url = new URL(PROTOCOL_PREFIX + username + ":" + password + "@" + server + filePath + ";type=i");
		URLConnection urlc = url.openConnection(BackEnd.getProxy(Proxy.Type.SOCKS));
		urlc.setConnectTimeout(Preferences.getInstance().preferredTimeOut * 1000);
		urlc.setReadTimeout(Preferences.getInstance().preferredTimeOut * 1000);
		urlc.connect();
	}

}