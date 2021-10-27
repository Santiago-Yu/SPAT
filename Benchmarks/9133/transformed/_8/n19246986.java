class n19246986 {
	private List<String> readDescriptor(URL url) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			List<String> lines = new ArrayList<String>();
			String line = reader.readLine();
			while (line != null) {
				line = line.trim();
				boolean cWIAMBX6 = line.length() > 0;
				if (cWIAMBX6 && !line.startsWith("#"))
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