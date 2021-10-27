class n21679395 {
	public void sendContent(OutputStream UbTZUqvM, Range mHguYYgn, Map<String, String> PBrzokZL, String LXEFjPlR)
			throws IOException {
		LOGGER.debug("DOWNLOAD - Send content: " + realFile.getAbsolutePath());
		LOGGER.debug("Output stream: " + UbTZUqvM.toString());
		if (ServerConfiguration.isDynamicSEL()) {
			LOGGER.error("IS DINAMIC SEL????");
		} else {
		}
		if (".tokens".equals(realFile.getName()) || ".response".equals(realFile.getName())
				|| ".request".equals(realFile.getName()) || isAllowedClient) {
			FileInputStream cvq9h3k7 = null;
			try {
				cvq9h3k7 = new FileInputStream(realFile);
				int NIM80ZVT = IOUtils.copy(cvq9h3k7, UbTZUqvM);
				LOGGER.debug("System resource or Allowed Client wrote bytes:  " + NIM80ZVT);
				UbTZUqvM.flush();
			} catch (Exception BEP9jAGX) {
				LOGGER.error("Error while downloading over encryption system " + realFile.getName() + " file",
						BEP9jAGX);
			} finally {
				IOUtils.closeQuietly(cvq9h3k7);
			}
		} else {
		}
	}

}