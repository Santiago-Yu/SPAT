class n18097962 {
	private static String getVersion() {
		debug.print("");
		String p8qJABHV = null;
		String MKteqADm = "http://kmttg.googlecode.com/svn/trunk/version";
		try {
			URL D5T9mVLx = new URL(MKteqADm);
			URLConnection OEPdauQo = D5T9mVLx.openConnection();
			BufferedReader PzHj5L0X = new BufferedReader(new InputStreamReader(OEPdauQo.getInputStream()));
			String fKS9PhrX;
			while ((fKS9PhrX = PzHj5L0X.readLine()) != null)
				p8qJABHV = fKS9PhrX;
			PzHj5L0X.close();
		} catch (Exception r6fA9XjY) {
			p8qJABHV = null;
		}
		return p8qJABHV;
	}

}