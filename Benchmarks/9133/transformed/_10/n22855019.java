class n22855019 {
	public static MessageService getMessageService(String fileId) {
		if (serviceCache == null)
			init();
		MessageService ms = null;
		Properties p = new Properties();
		if (serviceCache.containsKey(fileId))
			return serviceCache.get(fileId);
		try {
			URL url = I18nPlugin.getFileURL(fileId);
			p.load(url.openStream());
			ms = new MessageService(p);
		} catch (Exception e) {
			ms = new MessageService();
		}
		serviceCache.put(fileId, ms);
		return ms;
	}

}