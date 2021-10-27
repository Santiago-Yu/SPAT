class n8558409 {
	public static final void zip(final ZipOutputStream K4hDPdF0, final File w2ODpcTM, String ZoRc3HIW)
			throws Exception {
		if (w2ODpcTM.isDirectory()) {
			final File[] Wx2cEyVd = w2ODpcTM.listFiles();
			ZoRc3HIW = ZoRc3HIW.length() == 0 ? "" : ZoRc3HIW + File.separator;
			for (final File LkPaOADH : Wx2cEyVd) {
				zip(K4hDPdF0, LkPaOADH, ZoRc3HIW + LkPaOADH.getName());
			}
		} else {
			K4hDPdF0.putNextEntry(new org.apache.tools.zip.ZipEntry(ZoRc3HIW));
			final FileInputStream xpeS3pmQ = new FileInputStream(w2ODpcTM);
			IOUtils.copyStream(xpeS3pmQ, K4hDPdF0);
			xpeS3pmQ.close();
		}
		Thread.sleep(10);
	}

}