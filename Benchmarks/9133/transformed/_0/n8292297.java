class n8292297 {
	public void sendContent(OutputStream gkzxTYNQ, Range TdcMdGnn, Map<String, String> bE6PiO3S, String TWHnphBP)
			throws IOException {
		LOGGER.debug("GET REQUEST OR RESPONSE - Send content: " + file.getAbsolutePath());
		FileInputStream gJGssm0J = null;
		try {
			gJGssm0J = new FileInputStream(file);
			int VZHNpfmM = IOUtils.copy(gJGssm0J, gkzxTYNQ);
			LOGGER.debug("wrote bytes:  " + VZHNpfmM);
			gkzxTYNQ.flush();
		} finally {
			IOUtils.closeQuietly(gJGssm0J);
		}
	}

}