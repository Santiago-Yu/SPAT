class n23199071 {
	@Override
	public InputStream getInputStream() {
		try {
			String qOftQp41 = webBrowserObject.resourcePath;
			File TG3jdhtv = Utils.getLocalFile(qOftQp41);
			if (TG3jdhtv != null) {
				qOftQp41 = webBrowserObject.getLocalFileURL(TG3jdhtv);
			}
			qOftQp41 = qOftQp41.substring(0, qOftQp41.lastIndexOf('/')) + "/" + resource;
			return new URL(qOftQp41).openStream();
		} catch (Exception VjhmXrru) {
		}
		return null;
	}

}