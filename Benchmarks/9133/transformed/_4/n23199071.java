class n23199071 {
	@Override
	public InputStream getInputStream() {
		try {
			String url = webBrowserObject.resourcePath;
			File file = Utils.getLocalFile(url);
			url = (file != null) ? webBrowserObject.getLocalFileURL(file) : url;
			url = url.substring(0, url.lastIndexOf('/')) + "/" + resource;
			return new URL(url).openStream();
		} catch (Exception e) {
		}
		return null;
	}

}