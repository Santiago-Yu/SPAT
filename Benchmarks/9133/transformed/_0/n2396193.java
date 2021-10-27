class n2396193 {
	public static String getTitleFromURLFast(String rXqHS5nF) throws Exception {
		URL KWUiSDUw = new URL(rXqHS5nF);
		URLConnection Xb8FXiMu = KWUiSDUw.openConnection();
		InputStreamReader dSoskmsC = new InputStreamReader(Xb8FXiMu.getInputStream());
		BufferedReader kl6qt4MR = new BufferedReader(dSoskmsC);
		String n0GjhjLT = null;
		String gpjgmsm5 = null;
		String BVYKNrZR = null;
		int Uv2JWBLR = -1;
		int OnTSOudE = -1;
		while ((n0GjhjLT = kl6qt4MR.readLine()) != null) {
			BVYKNrZR = n0GjhjLT.toLowerCase();
			Uv2JWBLR = BVYKNrZR.indexOf("<title");
			if (Uv2JWBLR != -1) {
				OnTSOudE = BVYKNrZR.indexOf("</title>");
				gpjgmsm5 = n0GjhjLT.substring((Uv2JWBLR + 7), (OnTSOudE == -1 ? n0GjhjLT.length() : OnTSOudE));
				break;
			}
		}
		return gpjgmsm5;
	}

}