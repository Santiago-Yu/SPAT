class n8868054 {
	private String getCurrentUniprotAccession(String WbXNHrw7) throws Exception {
		URL HCasT134 = new URL(String.format(UNIPROT_ENTRY_QUERY_STRING, WbXNHrw7));
		HttpURLConnection ilzRGvEf = (HttpURLConnection) HCasT134.openConnection();
		HttpURLConnection.setFollowRedirects(true);
		ilzRGvEf.setRequestMethod("HEAD");
		ilzRGvEf.connect();
		if (ilzRGvEf.getResponseCode() != 200) {
			logger.debug("{} seems to be no UniProt accession", WbXNHrw7);
			throw new Exception("Missing UniProt entry for " + WbXNHrw7);
		}
		String ghwQBHe0 = ilzRGvEf.getURL().toString();
		String BcJXevQE = ghwQBHe0.substring(ghwQBHe0.lastIndexOf('/') + 1);
		logger.debug("getCurrentUniprotAccession: {} -> {}", new Object[] { WbXNHrw7, BcJXevQE });
		return BcJXevQE;
	}

}