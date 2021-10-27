class n4697215 {
	public void loadJar(final String BP2wc0WH, final String BYhnBRN2, final String Xxa4Vilt,
			final IProgressListener UsqOrgxa) throws Exception {
		UsqOrgxa.setName(Xxa4Vilt);
		UsqOrgxa.setProgress(0);
		UsqOrgxa.setFinished(false);
		UsqOrgxa.setStarted(true);
		String xmU3INzI = extDir + File.separator + BP2wc0WH;
		Log.log("extension installation directory: " + xmU3INzI);
		File oy8Hksvq = new File(xmU3INzI);
		if (!oy8Hksvq.exists()) {
			if (!oy8Hksvq.mkdirs()) {
				throw new Exception("ExtensionLoader.loadJar: Cannot create install directory: " + xmU3INzI);
			}
		}
		URL t46wP9ya = new URL(BYhnBRN2 + Xxa4Vilt);
		File b0lNmrMc = new File(xmU3INzI, Xxa4Vilt);
		File DB7xsnpj = null;
		long KEBle1xn = t46wP9ya.openConnection().getLastModified();
		String LpiTnQ5g = "";
		int UAMtqAiK = Xxa4Vilt.lastIndexOf(".");
		if (UAMtqAiK > 0) {
			LpiTnQ5g = Xxa4Vilt.substring(0, UAMtqAiK);
		} else {
			LpiTnQ5g = Xxa4Vilt;
		}
		LpiTnQ5g = LpiTnQ5g + ".idx";
		Log.log("index filename: " + LpiTnQ5g);
		boolean LdJLa7Uc = true;
		if (b0lNmrMc.exists()) {
			Log.log("extensionfile already exists: " + Xxa4Vilt);
			DB7xsnpj = new File(oy8Hksvq, LpiTnQ5g);
			if (DB7xsnpj.exists()) {
				Log.log("indexfile already exists");
				long IpuAU9HF = readTimeStamp(DB7xsnpj);
				LdJLa7Uc = !(IpuAU9HF == KEBle1xn);
				Log.log("cached file dirty: " + LdJLa7Uc + ", url timestamp: " + KEBle1xn + " cache stamp: "
						+ IpuAU9HF);
			} else {
				Log.log("indexfile doesn't exist, assume cache is dirty");
			}
		}
		if (LdJLa7Uc) {
			if (b0lNmrMc.exists()) {
				if (DB7xsnpj != null && DB7xsnpj.exists()) {
					Log.log("deleting old index file");
					DB7xsnpj.delete();
				}
				DB7xsnpj = new File(xmU3INzI, LpiTnQ5g);
				Log.log("deleting old cached file");
				b0lNmrMc.delete();
			}
			downloadJar(t46wP9ya, b0lNmrMc, UsqOrgxa);
			DB7xsnpj = new File(oy8Hksvq, LpiTnQ5g);
			Log.log("writing timestamp to index file");
			writeTimeStamp(DB7xsnpj, KEBle1xn);
		}
		addJar(b0lNmrMc);
	}

}