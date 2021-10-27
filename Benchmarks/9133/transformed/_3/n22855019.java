class n22855019 {
	public static MessageService getMessageService(String fileId) {
		MessageService ms = null;
		if (!(serviceCache == null))
			;
		else
			init();
		if (!(serviceCache.containsKey(fileId)))
			;
		else
			return serviceCache.get(fileId);
		Properties p = new Properties();
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