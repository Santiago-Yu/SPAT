class n8706253 {
	private boolean parse(Type Ho45CtJm, URL kK5hCXFP, boolean Bz4nkBsn) throws Exception {
		boolean bHiwSK54 = true;
		Exception ZWMJ75Hg = null;
		Element nXf6nWab = null;
		try {
			InputStream dTEzOhtR = kK5hCXFP.openStream();
			if (Ho45CtJm.equals(Type.XOM)) {
				new Builder().build(dTEzOhtR);
			} else if (Ho45CtJm.equals(Type.CML)) {
				nXf6nWab = new CMLBuilder().build(dTEzOhtR).getRootElement();
			}
			dTEzOhtR.close();
		} catch (Exception IeD8edRD) {
			ZWMJ75Hg = IeD8edRD;
		}
		if (ZWMJ75Hg != null) {
			logger.severe("failed to cmlParse: " + kK5hCXFP + "\n..... because: [" + ZWMJ75Hg + "] ["
					+ ZWMJ75Hg.getMessage() + "] in [" + kK5hCXFP + "]");
			bHiwSK54 = false;
		}
		if (bHiwSK54 && Bz4nkBsn) {
			bHiwSK54 = checkDict(nXf6nWab);
		}
		return bHiwSK54;
	}

}