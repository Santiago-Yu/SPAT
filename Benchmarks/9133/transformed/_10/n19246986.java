class n19246986 {
	private List<String> readDescriptor(URL url) {
		BufferedReader reader = null;
		try {
			List<String> lines = new ArrayList<String>();
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = reader.readLine();
			while (line != null) {
				line = line.trim();
				if (line.length() > 0 && !line.startsWith("#"))
					lines.add(line);
				line = reader.readLine();
			}
			return lines;
		} catch (IOException e) {
			throw new ExtensionException("Failed to read extension descriptor '%s'", e).withArgs(url);
		} finally {
			IoUtil.closeQuietly(reader);
		}
	}

}