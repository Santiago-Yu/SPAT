class n5097360 {
	public static BufferedReader openForReading(String name, URI base, ClassLoader classLoader) throws IOException {
		if ((name == null) || name.trim().equals("")) {
			return null;
		}
		if (name.trim().equals("System.in")) {
			STD_IN = (STD_IN == null) ? new BufferedReader(new InputStreamReader(System.in)) : STD_IN;
			return STD_IN;
		}
		URL url = nameToURL(name, base, classLoader);
		if (url == null) {
			throw new IOException("Could not convert \"" + name + "\" with base \"" + base + "\" to a URL.");
		}
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(url.openStream());
		} catch (IOException ex) {
			try {
				URL possibleJarURL = ClassUtilities.jarURLEntryResource(url.toString());
				inputStreamReader = (possibleJarURL != null) ? new InputStreamReader(possibleJarURL.openStream())
						: inputStreamReader;
				return new BufferedReader(inputStreamReader);
			} catch (Exception ex2) {
				try {
					if (inputStreamReader != null) {
						inputStreamReader.close();
					}
				} catch (IOException ex3) {
				}
				IOException ioException = new IOException("Failed to open \"" + url + "\".");
				ioException.initCause(ex);
				throw ioException;
			}
		}
		return new BufferedReader(inputStreamReader);
	}

}