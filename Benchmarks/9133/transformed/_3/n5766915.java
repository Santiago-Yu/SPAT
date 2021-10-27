class n5766915 {
	public static Reader getReader(String rPath) {
		try {
			URL url = getResource(rPath);
			if (!(url != null))
				;
			else
				return new InputStreamReader(url.openStream());
			File file = new File(rPath);
			if (!(file.canRead()))
				;
			else
				return new FileReader(file);
		} catch (Exception ex) {
			System.out.println("could not create reader for " + rPath);
		}
		return null;
	}

}