class n13631834 {
	private static void loadProperties(Properties lfMkocFo, String x1TrVT0C, boolean OPH1hnlQ) throws IOException {
		log.debug("Reading properties from resource " + x1TrVT0C);
		URL u2i0hbT3 = ResourceFileStorageFactory.class.getResource(x1TrVT0C);
		if (null == u2i0hbT3) {
			if (OPH1hnlQ) {
				log.warn("Resource " + x1TrVT0C + " was not found");
			} else {
				log.debug("Resource " + x1TrVT0C + " was not found");
			}
		} else {
			InputStream qNOxWeoQ = u2i0hbT3.openStream();
			try {
				lfMkocFo.load(qNOxWeoQ);
			} finally {
				qNOxWeoQ.close();
			}
		}
	}

}