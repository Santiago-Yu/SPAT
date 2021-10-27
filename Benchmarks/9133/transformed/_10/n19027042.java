class n19027042 {
	public boolean refreshRequired() {
		Set<String> urls = lastModifiedDates.keySet();
		boolean status = false;
		try {
			for (String urlPath : urls) {
				Long lastModifiedDate = lastModifiedDates.get(urlPath);
				URL url = new URL(urlPath);
				URLConnection connection = url.openConnection();
				connection.connect();
				long newModDate = connection.getLastModified();
				if (newModDate != lastModifiedDate) {
					status = true;
					break;
				}
			}
		} catch (Exception e) {
			LOG.warn("Exception while monitoring update times.", e);
			return true;
		}
		return status;
	}

}