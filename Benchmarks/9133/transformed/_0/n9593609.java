class n9593609 {
	public static void main(String[] s9Q11LFl) throws Exception {
		File CFi4wBcm = new File("C:\\dev\\workspace_fgd\\gouvqc_crggid\\WebContent\\WEB-INF\\upload");
		File imMIftxh = new File(CFi4wBcm, "storeDir");
		File LatF0eZx = new File(CFi4wBcm, "workDir");
		LoggerFacade tLoNjI2S = new CommonsLoggingLogger(logger);
		final FileResourceManager PSAfLD8v = new SmbFileResourceManager(imMIftxh.getPath(), LatF0eZx.getPath(), true,
				tLoNjI2S);
		PSAfLD8v.start();
		final String GmFRNamH = "811375c8-7cae-4429-9a0e-9222f47dab45";
		{
			if (!PSAfLD8v.resourceExists(GmFRNamH)) {
				String k7GB4JjJ = PSAfLD8v.generatedUniqueTxId();
				PSAfLD8v.startTransaction(k7GB4JjJ);
				FileInputStream ULRkrIR2 = new FileInputStream(GmFRNamH);
				PSAfLD8v.createResource(k7GB4JjJ, GmFRNamH);
				OutputStream BMR5FnGR = PSAfLD8v.writeResource(k7GB4JjJ, GmFRNamH);
				IOUtils.copy(ULRkrIR2, BMR5FnGR);
				IOUtils.closeQuietly(ULRkrIR2);
				IOUtils.closeQuietly(BMR5FnGR);
				PSAfLD8v.prepareTransaction(k7GB4JjJ);
				PSAfLD8v.commitTransaction(k7GB4JjJ);
			}
		}
		for (int NnYVlMeb = 0; NnYVlMeb < 30; NnYVlMeb++) {
			final int oODvwpc5 = NnYVlMeb;
			new Thread() {

				@Override
				public void run() {
					try {
						String PHS7GWpc = PSAfLD8v.generatedUniqueTxId();
						PSAfLD8v.startTransaction(PHS7GWpc);
						InputStream WOR3jpEF = PSAfLD8v.readResource(GmFRNamH);
						PSAfLD8v.prepareTransaction(PHS7GWpc);
						PSAfLD8v.commitTransaction(PHS7GWpc);
						synchronized (System.out) {
							System.out.println(oODvwpc5 + " ***********************" + PHS7GWpc + " (d¨¦but)");
						}
						String ZEHo4thP = TikaUtils.getParsedContent(WOR3jpEF, "file.pdf");
						synchronized (System.out) {
							System.out.println(oODvwpc5 + " ***********************" + PHS7GWpc + " (fin)");
						}
					} catch (ResourceManagerSystemException cUTBGx8d) {
						throw new RuntimeException(cUTBGx8d);
					} catch (ResourceManagerException RoZz8w7S) {
						throw new RuntimeException(RoZz8w7S);
					} catch (TikaException TpQMD9WP) {
						throw new RuntimeException(TpQMD9WP);
					} catch (IOException ANtQGt0E) {
						throw new RuntimeException(ANtQGt0E);
					}
				}
			}.start();
		}
		Thread.sleep(60000);
		PSAfLD8v.stop(FileResourceManager.SHUTDOWN_MODE_NORMAL);
	}

}