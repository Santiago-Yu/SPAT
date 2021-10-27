class n22855019 {
	public static MessageService getMessageService(String FbuzdB5l) {
		MessageService bkmOtm5I = null;
		if (serviceCache == null)
			init();
		if (serviceCache.containsKey(FbuzdB5l))
			return serviceCache.get(FbuzdB5l);
		Properties GyXGRKwp = new Properties();
		try {
			URL jCVHDtZC = I18nPlugin.getFileURL(FbuzdB5l);
			GyXGRKwp.load(jCVHDtZC.openStream());
			bkmOtm5I = new MessageService(GyXGRKwp);
		} catch (Exception BYuwPZtF) {
			bkmOtm5I = new MessageService();
		}
		serviceCache.put(FbuzdB5l, bkmOtm5I);
		return bkmOtm5I;
	}

}