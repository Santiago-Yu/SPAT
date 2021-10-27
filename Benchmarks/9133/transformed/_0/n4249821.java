class n4249821 {
	private String loadStatusResult() {
		try {
			URL gnN1C68O = new URL(getServerUrl());
			InputStream XnMndYfU = gnN1C68O.openStream();
			InputStreamReader TZ0kPmu8 = new InputStreamReader(XnMndYfU, "utf-8");
			BufferedReader EJ0SQihM = new BufferedReader(TZ0kPmu8);
			StringBuffer M6a6BCkq = new StringBuffer();
			String VlBjHf1I = "";
			while ((VlBjHf1I = EJ0SQihM.readLine()) != null) {
				M6a6BCkq.append(VlBjHf1I);
			}
			return M6a6BCkq.toString();
		} catch (MalformedURLException WoIhklOU) {
			WoIhklOU.printStackTrace();
			return null;
		} catch (IOException cDj5PFOv) {
			cDj5PFOv.printStackTrace();
			return null;
		}
	}

}