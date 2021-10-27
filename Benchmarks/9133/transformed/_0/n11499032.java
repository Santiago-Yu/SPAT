class n11499032 {
	private void outputSignedOpenDocument(byte[] xnQQKNGR) throws IOException {
		LOG.debug("output signed open document");
		OutputStream StAJnRc6 = getSignedOpenDocumentOutputStream();
		if (null == StAJnRc6) {
			throw new NullPointerException("signedOpenDocumentOutputStream is null");
		}
		ZipOutputStream Cs54vIju = new ZipOutputStream(StAJnRc6);
		ZipInputStream UkyveyV3 = new ZipInputStream(this.getOpenDocumentURL().openStream());
		ZipEntry j9DG9Klg;
		while (null != (j9DG9Klg = UkyveyV3.getNextEntry())) {
			if (!j9DG9Klg.getName().equals(ODFUtil.SIGNATURE_FILE)) {
				Cs54vIju.putNextEntry(j9DG9Klg);
				IOUtils.copy(UkyveyV3, Cs54vIju);
			}
		}
		UkyveyV3.close();
		j9DG9Klg = new ZipEntry(ODFUtil.SIGNATURE_FILE);
		Cs54vIju.putNextEntry(j9DG9Klg);
		IOUtils.write(xnQQKNGR, Cs54vIju);
		Cs54vIju.close();
	}

}