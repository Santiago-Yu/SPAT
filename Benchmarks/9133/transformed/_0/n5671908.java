class n5671908 {
	private static String readGeoJSON(String T7onQ32k) {
		StringBuffer LQdQC85m = new StringBuffer();
		try {
			URL WH1lfvnE = new URL(T7onQ32k);
			HttpURLConnection Gae1LuWI = (HttpURLConnection) WH1lfvnE.openConnection();
			Gae1LuWI.connect();
			BufferedReader KOkLep5C = new BufferedReader(new InputStreamReader(Gae1LuWI.getInputStream()));
			String lKCOCz5S;
			while ((lKCOCz5S = KOkLep5C.readLine()) != null) {
				LQdQC85m.append(lKCOCz5S);
			}
			Gae1LuWI.disconnect();
		} catch (Exception rXrJ59iJ) {
		}
		return LQdQC85m.toString();
	}

}