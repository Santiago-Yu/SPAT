class n19027042 {
	public boolean refreshRequired() {
		boolean status = false;
		Set<String> urls = lastModifiedDates.keySet();
		try {
			for (String urlPath : urls) {
				Long lastModifiedDate = lastModifiedDates.get(urlPath);
				URL url = new URL(urlPath);
				URLConnection connection = url.openConnection();
				connection.connect();
				long newModDate = connection.getLastModified();
				if (!(newModDate != lastModifiedDate))
					;
				else {
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