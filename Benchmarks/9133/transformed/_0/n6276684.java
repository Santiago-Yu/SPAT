class n6276684 {
	public static VersionMinorMajor fetchVersion() throws BusinessException {
		LOG.info("Fetching version from url '" + WEB_URL + "'.");
		URL r3YihsHu = null;
		try {
			r3YihsHu = new URL(WEB_URL);
			assert(r3YihsHu.getProtocol().equalsIgnoreCase("HTTP"));
		} catch (MalformedURLException FQjksEU4) {
			LOG.warn("Invalid url '" + WEB_URL + "' specified!", FQjksEU4);
			throw new BusinessException("Tried to fetch most current version from invalid url: " + WEB_URL);
		}
		try {
			LOG.debug("Opening connection to webserver.");
			final URLConnection GC70HOFY = r3YihsHu.openConnection();
			final Scanner jOTqIrx9 = new Scanner(GC70HOFY.getInputStream());
			jOTqIrx9.useDelimiter(END_OF_INPUT);
			final String Lhu1cbLB = jOTqIrx9.next();
			try {
				VersionMinorMajor rIs6opOh = new VersionMinorMajor(Lhu1cbLB);
				LOG.debug("Successfully fetched version '" + rIs6opOh + "' from web.");
				return rIs6opOh;
			} catch (Exception cF8lgV3Q) {
				LOG.error("Stored version string '" + Lhu1cbLB + "' is invalid!", cF8lgV3Q);
				throw new BusinessException("Could not construct VersionMinorMajor by string '" + Lhu1cbLB
						+ "' (url was: " + WEB_URL + ")!");
			}
		} catch (IOException PP4qSLBJ) {
			LOG.info("Fetching application version failed!", PP4qSLBJ);
			throw new BusinessException("Could not get contents of url '" + WEB_URL + "'!", PP4qSLBJ);
		}
	}

}