class n23482443 {
	public static String getDocumentAsString(URL UH3Amn0L) throws IOException {
		StringBuffer BhmOdS41 = new StringBuffer();
		BufferedReader YUv0niDN = new BufferedReader(new InputStreamReader(UH3Amn0L.openStream(), "UTF8"));
		String cIpmGxEV = "";
		while (cIpmGxEV != null) {
			BhmOdS41.append(cIpmGxEV);
			cIpmGxEV = YUv0niDN.readLine();
		}
		return BhmOdS41.toString();
	}

}