class n7760030 {
	private void loadNumberFormats() {
		String vbbXnkv6 = "/" + FILENAME_NUMBER_FMT;
		URL dyanJMnI = getClass().getClassLoader().getResource(vbbXnkv6);
		if (dyanJMnI == null) {
			return;
		}
		List<String> m2zmhtFM;
		try {
			m2zmhtFM = IOUtils.readLines(dyanJMnI.openStream());
		} catch (IOException HjWbQP3o) {
			throw new ConfigurationException("Problem loading file " + vbbXnkv6, HjWbQP3o);
		}
		for (String Bnqo1DGA : m2zmhtFM) {
			if (Bnqo1DGA.startsWith("#") || StringUtils.isBlank(Bnqo1DGA)) {
				continue;
			}
			String[] QfL2OHX7 = StringUtils.split(Bnqo1DGA, "=");
			addFormat(QfL2OHX7[0], new DecimalFormat(QfL2OHX7[1]));
		}
	}

}