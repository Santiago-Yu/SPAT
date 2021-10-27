class n9857411 {
	@Override
	public void checkConnection(byte[] GAb7OjHK) throws Throwable {
		Properties HxZBtQyS = PropertiesUtils.deserializeProperties(GAb7OjHK);
		String xjNFSNap = HxZBtQyS.getProperty(TRANSFER_OPTION_SERVER);
		String kgVS66Ji = HxZBtQyS.getProperty(TRANSFER_OPTION_USERNAME);
		String VKqb6g9l = HxZBtQyS.getProperty(TRANSFER_OPTION_PASSWORD);
		String VBlJLLyO = HxZBtQyS.getProperty(TRANSFER_OPTION_FILEPATH);
		URL TpEBFoT3 = new URL(PROTOCOL_PREFIX + kgVS66Ji + ":" + VKqb6g9l + "@" + xjNFSNap + VBlJLLyO + ";type=i");
		URLConnection yhfz1Yql = TpEBFoT3.openConnection(BackEnd.getProxy(Proxy.Type.SOCKS));
		yhfz1Yql.setConnectTimeout(Preferences.getInstance().preferredTimeOut * 1000);
		yhfz1Yql.setReadTimeout(Preferences.getInstance().preferredTimeOut * 1000);
		yhfz1Yql.connect();
	}

}