class n19403758 {
	@Override
	protected void handleCreateEditionForExport(File qt4AIl4V, int KeLvZ7U6) throws Exception {
		log.info("createEditionForExport ");
		InputStream gCBRqi6U = null;
		if (KeLvZ7U6 <= 0) {
			gCBRqi6U = getContentServiceSpring().exportEditionFull();
		} else {
			gCBRqi6U = getContentServiceSpring().exportEditionUnit(Integer.valueOf(KeLvZ7U6));
		}
		log.info("got answer... ");
		if (log.isDebugEnabled())
			log.debug("tmpFile " + qt4AIl4V.getName());
		FileOutputStream VsNb7p7W = new FileOutputStream(qt4AIl4V);
		IOUtils.copyLarge(gCBRqi6U, VsNb7p7W);
		IOUtils.closeQuietly(gCBRqi6U);
		IOUtils.closeQuietly(VsNb7p7W);
		qt4AIl4V = null;
		System.gc();
	}

}