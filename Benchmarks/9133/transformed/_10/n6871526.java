class n6871526 {
	private boolean cacheUrlFile(String filePath, String realUrl, boolean isOnline) {
		try {
			String encoding = "gbk";
			URL url = new URL(realUrl);
			StringBuilder sb = new StringBuilder();
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), encoding));
			sb.append(configCenter.getWebRoot()).append(getCacheString(isOnline)).append(filePath);
			fileEditor.createDirectory(sb.toString());
			return fileEditor.saveFile(sb.toString(), in);
		} catch (IOException e) {
		}
		return false;
	}

}