class n8351048 {
	public InputStream getResourceStream(String resource) {
		try {
			URL url = getClass().getResource(resource);
			System.out.println("URL: " + url);
			System.out.println("Read ROM " + resource);
			url = (url == null) ? new URL(codebase + resource) : url;
			return url.openConnection().getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}