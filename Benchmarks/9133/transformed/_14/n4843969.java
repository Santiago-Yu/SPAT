class n4843969 {
	public void buildCache() {
		CacheManager.resetCache();
		XMLCacheBuilder cacheBuilder = CompositePageUtil.getCacheBuilder();
		if (null == cacheBuilder)
			return;
		String pathStr = cacheBuilder.getPath();
		if (null == pathStr)
			return;
		String[] paths = pathStr.split("\n");
		for (int i = 0; i < paths.length; i++) {
			try {
				String path = paths[i];
				URL url = new URL(path);
				HttpURLConnection huc = (HttpURLConnection) url.openConnection();
				huc.setDoInput(true);
				huc.setDoOutput(true);
				huc.setUseCaches(false);
				huc.setRequestProperty("Content-Type", "text/html");
				DataOutputStream dos = new DataOutputStream(huc.getOutputStream());
				dos.flush();
				dos.close();
				huc.disconnect();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}