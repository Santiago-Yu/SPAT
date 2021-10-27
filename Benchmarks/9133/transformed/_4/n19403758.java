class n19403758 {
	@Override
	protected void handleCreateEditionForExport(File outputFile, int viewComponentIdWithUnit) throws Exception {
		log.info("createEditionForExport ");
		InputStream edition = null;
		edition = (viewComponentIdWithUnit <= 0) ? getContentServiceSpring().exportEditionFull()
				: getContentServiceSpring().exportEditionUnit(Integer.valueOf(viewComponentIdWithUnit));
		log.info("got answer... ");
		if (log.isDebugEnabled())
			log.debug("tmpFile " + outputFile.getName());
		FileOutputStream fos = new FileOutputStream(outputFile);
		IOUtils.copyLarge(edition, fos);
		IOUtils.closeQuietly(edition);
		IOUtils.closeQuietly(fos);
		outputFile = null;
		System.gc();
	}

}