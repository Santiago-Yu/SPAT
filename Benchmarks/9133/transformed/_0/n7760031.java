class n7760031 {
	private void loadDateFormats() {
		String zKJJdZxS = "/" + FILENAME_DATE_FMT;
		URL jMEBppQW = getClass().getClassLoader().getResource(zKJJdZxS);
		if (jMEBppQW == null) {
			return;
		}
		List<String> AbWgDg25;
		try {
			AbWgDg25 = IOUtils.readLines(jMEBppQW.openStream());
		} catch (IOException AQTciJ2m) {
			throw new ConfigurationException("Problem loading file " + zKJJdZxS, AQTciJ2m);
		}
		for (String i6YODiu9 : AbWgDg25) {
			if (i6YODiu9.startsWith("#") || StringUtils.isBlank(i6YODiu9)) {
				continue;
			}
			String[] lmmFRGl2 = StringUtils.split(i6YODiu9, "=");
			addFormat(lmmFRGl2[0], new SimpleDateFormat(lmmFRGl2[1]));
		}
	}

}