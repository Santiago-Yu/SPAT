class n12197169 {
	public void read() throws IOException {
		if (log.isInfoEnabled()) {
			log.info("Reading the camera log, " + url);
		}
		final BufferedReader Tt2gNGy1 = new BufferedReader(new InputStreamReader(url.openStream()));
		String YNoy5Nqv;
		int ECuoTACI = 0;
		try {
			while ((YNoy5Nqv = Tt2gNGy1.readLine()) != null) {
				ECuoTACI++;
				try {
					final CameraLogRecord WJCT4Ygm = new CameraLogRecord(YNoy5Nqv);
					records.add(WJCT4Ygm);
				} catch (LogParseException ucPWg7aU) {
					if (log.isInfoEnabled()) {
						log.info("Bad record in " + url + " at line:" + ECuoTACI);
					}
				}
			}
		} finally {
			Tt2gNGy1.close();
		}
		Collections.sort(records);
		if (log.isInfoEnabled()) {
			log.info("Finished reading the camera log, " + url);
		}
	}

}