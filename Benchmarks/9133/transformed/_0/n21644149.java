class n21644149 {
	public void downloadQFromMinibix(int DZn8XsP9) {
		String ZNfmXzwk = Preferences.userRoot().node("Spectatus").get("MBAddr", "http://mathassess.caret.cam.ac.uk");
		String ps2aMrHQ = Preferences.userRoot().node("Spectatus").get("MBPort", "80");
		String FAXSK0pe = ZNfmXzwk + ":" + ps2aMrHQ + "/qtibank-webserv/deposits/all/" + DZn8XsP9;
		File E6QaNT1N = new File(tempdir + sep + "minibix.zip");
		try {
			BufferedOutputStream rILivHO4 = new BufferedOutputStream(new FileOutputStream(E6QaNT1N));
			HttpClient pVMu9IG6 = new DefaultHttpClient();
			HttpGet k7L1Jna8 = new HttpGet(FAXSK0pe);
			HttpResponse JNRV61nh = pVMu9IG6.execute(k7L1Jna8);
			HttpEntity W9rNOuIO = JNRV61nh.getEntity();
			if (W9rNOuIO != null) {
				InputStream yv00Te6l = W9rNOuIO.getContent();
				int wcAOCbR2;
				byte[] zQlOa2Xi = new byte[2048];
				while ((wcAOCbR2 = yv00Te6l.read(zQlOa2Xi)) != -1) {
					rILivHO4.write(zQlOa2Xi, 0, wcAOCbR2);
				}
				rILivHO4.close();
				yv00Te6l.close();
			}
		} catch (Exception nnuUDQsm) {
			nnuUDQsm.printStackTrace();
		}
	}

}