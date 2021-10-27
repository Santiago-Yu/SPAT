class n13279978 {
	@Override
	public void sendContent(OutputStream AuPEg8NB, Range iNrUJn9J, Map<String, String> ulROThJP, String seoEb6Nw)
			throws IOException {
		LOGGER.debug("DOWNLOAD - Send content: " + realFile.getAbsolutePath());
		LOGGER.debug("Output stream: " + AuPEg8NB.toString());
		if (ServerConfiguration.isDynamicSEL()) {
			LOGGER.error("IS DINAMIC SEL????");
		} else {
		}
		if (".tokens".equals(realFile.getName()) || ".response".equals(realFile.getName())
				|| ".request".equals(realFile.getName()) || isAllowedClient) {
			FileInputStream yEfGGfDG = null;
			try {
				yEfGGfDG = new FileInputStream(realFile);
				int WV4NYDme = IOUtils.copy(yEfGGfDG, AuPEg8NB);
				LOGGER.debug("System resource or Allowed Client wrote bytes:  " + WV4NYDme);
				AuPEg8NB.flush();
			} catch (Exception ghCnS4Ue) {
				LOGGER.error("Error while uploading over encryption system " + realFile.getName() + " file", ghCnS4Ue);
			} finally {
				IOUtils.closeQuietly(yEfGGfDG);
			}
		} else {
			FileInputStream NFfVtjcH = null;
			try {
				NFfVtjcH = new FileInputStream(realFile);
				int nGPIRCZo = IOUtils.copy(NFfVtjcH, AuPEg8NB);
				LOGGER.debug("System resource or Allowed Client wrote bytes:  " + nGPIRCZo);
				AuPEg8NB.flush();
			} catch (Exception t7qhDDBe) {
				LOGGER.error("Error while uploading over encryption system " + realFile.getName() + " file", t7qhDDBe);
			} finally {
				IOUtils.closeQuietly(NFfVtjcH);
			}
		}
	}

}