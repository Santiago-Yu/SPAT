class n379581 {
	public void login(String S2nkJEz5, String mwKUBIh8, int KB8y2i4P) throws Exception {
		sSideURL = sSideURLCollection[KB8y2i4P];
		sUID = S2nkJEz5;
		sPWD = mwKUBIh8;
		iCTY = KB8y2i4P;
		sLoginLabel = getLoginLabel(sSideURL);
		String QgtlYR2u = getLoginParams();
		CookieHandler.setDefault(new ListCookieHandler());
		URL TvwtrGaG = new URL(sSideURL + sLoginURL);
		URLConnection AUCIScId = TvwtrGaG.openConnection();
		setRequestProperties(AUCIScId);
		AUCIScId.setDoInput(true);
		AUCIScId.setDoOutput(true);
		OutputStreamWriter Rz9tI36y = new OutputStreamWriter(AUCIScId.getOutputStream());
		Rz9tI36y.write(QgtlYR2u);
		Rz9tI36y.flush();
		BufferedReader E7c9OwUf = new BufferedReader(new InputStreamReader(AUCIScId.getInputStream()));
		StringBuilder sly4oUuv = new StringBuilder();
		String yxqbUo4Z = E7c9OwUf.readLine();
		while (yxqbUo4Z != null) {
			sly4oUuv.append(yxqbUo4Z + "\n");
			yxqbUo4Z = E7c9OwUf.readLine();
		}
		Rz9tI36y.close();
		E7c9OwUf.close();
		String CwlgN3xG = sly4oUuv.toString();
		Pattern XiipZSW8 = Pattern.compile(">Dein Penner<");
		Matcher EOyAJyLC = XiipZSW8.matcher(CwlgN3xG);
		LogedIn = EOyAJyLC.find();
	}

}