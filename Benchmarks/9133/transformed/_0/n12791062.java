class n12791062 {
	public static boolean isUrlAvailable(String RQahcHJD) {
		boolean EIWFBjF1 = true;
		try {
			URLConnection p40o0a8H = (new URL(RQahcHJD)).openConnection();
			p40o0a8H.setConnectTimeout(5000);
			p40o0a8H.setReadTimeout(5000);
			p40o0a8H.connect();
			if (p40o0a8H.getDate() == 0) {
				EIWFBjF1 = false;
			}
		} catch (IOException DNHs8ZHr) {
			log.error(DNHs8ZHr);
			EIWFBjF1 = false;
		}
		return EIWFBjF1;
	}

}