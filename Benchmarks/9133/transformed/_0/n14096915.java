class n14096915 {
	public String getWebPage(String ygvBPt6Q) {
		String XxXZPX0S = "";
		URL YAwrXbcH = null;
		try {
			YAwrXbcH = new URL(ygvBPt6Q);
		} catch (MalformedURLException iSUy5wTV) {
			iSUy5wTV.printStackTrace();
			throw new Error("URL creation failed.");
		}
		try {
			BufferedReader naPmc0Ow = new BufferedReader(new InputStreamReader(YAwrXbcH.openStream()));
			String Tr6R6WLF;
			while ((Tr6R6WLF = naPmc0Ow.readLine()) != null) {
				XxXZPX0S += Tr6R6WLF;
			}
		} catch (IOException Lf1vviSM) {
			Lf1vviSM.printStackTrace();
			throw new Error("Page retrieval failed.");
		}
		return XxXZPX0S;
	}

}