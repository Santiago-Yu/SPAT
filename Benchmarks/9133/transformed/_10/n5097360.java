class n5097360 {
	public static BufferedReader openForReading(String name, URI base, ClassLoader classLoader) throws IOException {
		if ((name == null) || name.trim().equals("")) {
			return null;
		}
		if (name.trim().equals("System.in")) {
			if (STD_IN == null) {
				STD_IN = new BufferedReader(new InputStreamReader(System.in));
			}
			return STD_IN;
		}
		URL url = nameToURL(name, base, classLoader);
		InputStreamReader inputStreamReader = null;
		if (url == null) {
			throw new IOException("Could not convert \"" + name + "\" with base \"" + base + "\" to a URL.");
		}
		try {
			inputStreamReader = new InputStreamReader(url.openStream());
		} catch (IOException ex) {
			try {
				URL possibleJarURL = ClassUtilities.jarURLEntryResource(url.toString());
				if (possibleJarURL != null) {
					inputStreamReader = new InputStreamReader(possibleJarURL.openStream());
				}
				return new BufferedReader(inputStreamReader);
			} catch (Exception ex2) {
				IOException ioException = new IOException("Failed to open \"" + url + "\".");
				try {
					if (inputStreamReader != null) {
						inputStreamReader.close();
					}
				} catch (IOException ex3) {
				}
				ioException.initCause(ex);
				throw ioException;
			}
		}
		return new BufferedReader(inputStreamReader);
	}

}