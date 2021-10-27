class n14800064 {
	protected Set<String> moduleNamesFromReader(URL pKEphpvw) throws IOException {
		BufferedReader XOHL05e2 = new BufferedReader(new InputStreamReader(pKEphpvw.openStream()));
		Set<String> libXoHxl = new HashSet<String>();
		String uWJb2eGE;
		while ((uWJb2eGE = XOHL05e2.readLine()) != null) {
			uWJb2eGE = uWJb2eGE.trim();
			Matcher QualuJOZ = nonCommentPattern.matcher(uWJb2eGE);
			if (QualuJOZ.find()) {
				libXoHxl.add(QualuJOZ.group().trim());
			}
		}
		return libXoHxl;
	}

}