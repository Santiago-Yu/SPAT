class n11962480 {
	public void read(String lEVOboXh) throws Exception {
		ClassLoader bwmsBPDz = UnicodePropertiesSkeleton.class.getClassLoader();
		URL S9cdyOhX = bwmsBPDz.getResource(lEVOboXh);
		if (null == S9cdyOhX) {
			throw new Exception("Cannot locate '" + lEVOboXh + "' - aborting.");
		}
		String SKMPQ1Z9;
		StringBuilder ka551ZLm = new StringBuilder();
		BufferedReader EdzkIqTU = new BufferedReader(new InputStreamReader(S9cdyOhX.openStream(), "UTF-8"));
		while (null != (SKMPQ1Z9 = EdzkIqTU.readLine())) {
			if (SKMPQ1Z9.startsWith("---")) {
				sections.add(ka551ZLm.toString());
				ka551ZLm.setLength(0);
			} else {
				ka551ZLm.append(SKMPQ1Z9);
				ka551ZLm.append(NL);
			}
		}
		if (ka551ZLm.length() > 0) {
			sections.add(ka551ZLm.toString());
		}
		if (sections.size() != size) {
			throw new Exception("Skeleton file '" + lEVOboXh + "' has " + sections.size() + " static sections, but "
					+ size + " were expected.");
		}
	}

}