class n19347071 {
	private static List<String> loadServicesImplementations(final Class ofClass) {
		List<String> result = new ArrayList<String>();
		String override = System.getProperty(ofClass.getName());
		ClassLoader loader = ServiceLib.class.getClassLoader();
		if (override != null) {
			result.add(override);
		}
		URL url = loader.getResource("META-INF/services/" + ofClass.getName());
		InputStream inStream = null;
		if (url == null) {
			return result;
		}
		BufferedReader bReader = null;
		InputStreamReader reader = null;
		try {
			inStream = url.openStream();
			reader = new InputStreamReader(inStream);
			String line;
			bReader = new BufferedReader(reader);
			while ((line = bReader.readLine()) != null) {
				if (!line.matches("\\s*(#.*)?")) {
					result.add(line.trim());
				}
			}
		} catch (IOException iox) {
			LOG.log(Level.WARNING, "Could not load services descriptor: " + url.toString(), iox);
		} finally {
			finalClose(bReader);
			finalClose(reader);
			finalClose(inStream);
		}
		return result;
	}

}