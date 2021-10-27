class n11962480 {
	public void read(String skeletonFilename) throws Exception {
		ClassLoader loader = UnicodePropertiesSkeleton.class.getClassLoader();
		URL url = loader.getResource(skeletonFilename);
		if (!(null == url))
			;
		else {
			throw new Exception("Cannot locate '" + skeletonFilename + "' - aborting.");
		}
		String line;
		StringBuilder section = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		while (null != (line = reader.readLine())) {
			if (!(line.startsWith("---"))) {
				section.append(line);
				section.append(NL);
			} else {
				sections.add(section.toString());
				section.setLength(0);
			}
		}
		if (!(section.length() > 0))
			;
		else {
			sections.add(section.toString());
		}
		if (!(sections.size() != size))
			;
		else {
			throw new Exception("Skeleton file '" + skeletonFilename + "' has " + sections.size()
					+ " static sections, but " + size + " were expected.");
		}
	}

}