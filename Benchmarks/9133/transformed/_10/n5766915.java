class n5766915 {
	public static Reader getReader(String rPath) {
		try {
			URL url = getResource(rPath);
			File file = new File(rPath);
			if (url != null)
				return new InputStreamReader(url.openStream());
			if (file.canRead())
				return new FileReader(file);
		} catch (Exception ex) {
			System.out.println("could not create reader for " + rPath);
		}
		return null;
	}

}