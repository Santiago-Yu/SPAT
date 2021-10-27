class n13540821 {
	private static InputSource getInputSourceFromURI(String Ngq8Hk7x, String iffz5qeQ, String MQxJ25FG)
			throws IOException, ProtocolException, UnsupportedEncodingException {
		URL fCeF4T4u = null;
		try {
			fCeF4T4u = new URL(Ngq8Hk7x);
		} catch (MalformedURLException H8S5yEFp) {
			return new InputSource(Ngq8Hk7x);
		}
		if (iffz5qeQ == null && fCeF4T4u.getUserInfo() == null) {
			return new InputSource(Ngq8Hk7x);
		}
		if (!fCeF4T4u.getProtocol().startsWith("http")) {
			return new InputSource(Ngq8Hk7x);
		}
		URLConnection PiPySwge = fCeF4T4u.openConnection();
		if (!(PiPySwge instanceof HttpURLConnection)) {
			return new InputSource(Ngq8Hk7x);
		}
		HttpURLConnection dzNq5RrF = (HttpURLConnection) PiPySwge;
		String fm7SjEqO = fCeF4T4u.getUserInfo();
		dzNq5RrF.setRequestMethod("GET");
		dzNq5RrF.setAllowUserInteraction(false);
		dzNq5RrF.setDefaultUseCaches(false);
		dzNq5RrF.setDoInput(true);
		dzNq5RrF.setDoOutput(false);
		dzNq5RrF.setInstanceFollowRedirects(true);
		dzNq5RrF.setUseCaches(false);
		String Uzo7yc1Q = null;
		if (fm7SjEqO != null) {
			Uzo7yc1Q = fm7SjEqO;
		} else if (iffz5qeQ != null) {
			Uzo7yc1Q = (MQxJ25FG == null) ? iffz5qeQ : iffz5qeQ + ":" + MQxJ25FG;
		}
		if (Uzo7yc1Q != null) {
			dzNq5RrF.setRequestProperty("Authorization",
					"Basic " + base64encode(Uzo7yc1Q.getBytes(httpAuthCharEncoding)));
		}
		dzNq5RrF.connect();
		return new InputSource(dzNq5RrF.getInputStream());
	}

}