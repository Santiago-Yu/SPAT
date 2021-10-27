class n21182830 {
	public void buildCache() {
		String postFix = "";
		XMLCacheBuilder cacheBuilder = CompositePageUtil.getCacheBuilder();
		if (cacheBuilder.getPostFix() != null && !cacheBuilder.getPostFix().equals("")) {
			postFix = "." + cacheBuilder.getPostFix();
		}
		String basePath = cacheBuilder.getBasePath();
		List actions = CompositePageUtil.getXMLActions();
		for (int i = 0; i < actions.size(); i++) {
			try {
				XMLAction action = (XMLAction) actions.get(i);
				if (action.getEscapeCacheBuilder() != null && action.getEscapeCacheBuilder().equals("true"))
					continue;
				String actionUrl = basePath + action.getName() + postFix;
				URL url = new URL(actionUrl);
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
				logger.error(e);
				e.printStackTrace();
			} catch (IOException e) {
				logger.equals(e);
				e.printStackTrace();
			}
		}
	}

}