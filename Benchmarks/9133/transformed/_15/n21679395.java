class n21679395 {
	public void sendContent(OutputStream out, Range range, Map<String, String> params, String contentType)
			throws IOException {
		LOGGER.debug("DOWNLOAD - Send content: " + realFile.getAbsolutePath());
		LOGGER.debug("Output stream: " + out.toString());
		if (ServerConfiguration.isDynamicSEL()) {
			LOGGER.error("IS DINAMIC SEL????");
		} else {
		}
		if ((realFile.getName() != null && realFile.getName().equals(".tokens"))
				|| (realFile.getName() != null && realFile.getName().equals(".response"))
				|| (realFile.getName() != null && realFile.getName().equals(".request")) || isAllowedClient) {
			FileInputStream in = null;
			try {
				in = new FileInputStream(realFile);
				int bytes = IOUtils.copy(in, out);
				LOGGER.debug("System resource or Allowed Client wrote bytes:  " + bytes);
				out.flush();
			} catch (Exception e) {
				LOGGER.error("Error while downloading over encryption system " + realFile.getName() + " file", e);
			} finally {
				IOUtils.closeQuietly(in);
			}
		} else {
		}
	}

}