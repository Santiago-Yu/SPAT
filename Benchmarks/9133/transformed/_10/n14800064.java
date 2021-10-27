class n14800064 {
	protected Set<String> moduleNamesFromReader(URL url) throws IOException {
		Set<String> names = new HashSet<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			Matcher m = nonCommentPattern.matcher(line);
			if (m.find()) {
				names.add(m.group().trim());
			}
		}
		return names;
	}

}