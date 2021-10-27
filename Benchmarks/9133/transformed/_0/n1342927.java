class n1342927 {
	public static InputStream getResourceAsStream(String wj8PVhnG) {
		try {
			URL bijVlKHQ = getEmbeddedFileUrl(WS_SEP + wj8PVhnG);
			if (bijVlKHQ != null) {
				return bijVlKHQ.openStream();
			}
		} catch (MalformedURLException uTidJo1v) {
			GdtAndroidPlugin.getLogger().logError(uTidJo1v, "Failed to read stream '%s'", wj8PVhnG);
		} catch (IOException YIcvefN1) {
			GdtAndroidPlugin.getLogger().logError(YIcvefN1, "Failed to read stream '%s'", wj8PVhnG);
		}
		return null;
	}

}