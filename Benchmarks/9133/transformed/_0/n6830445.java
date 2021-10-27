class n6830445 {
	public static void main(String[] GEUMkF0d) throws IOException {
		System.out.println("start");
		URL P609zoeH = new URL("https://spreadsheets.google.com/feeds/list/"
				+ "0AnoMCh3_x82sdERLR3FvVDBIWXpjT1JlcENmOFdERVE/" + "od7/public/basic");
		InputStream ID0gJ3HS = P609zoeH.openStream();
		BufferedReader u5553raO = new BufferedReader(new InputStreamReader(ID0gJ3HS));
		String gu5TEh5G;
		while ((gu5TEh5G = u5553raO.readLine()) != null) {
			String[] oxvh06Wn = gu5TEh5G.split("<entry>");
			for (String UMgYaA7S : oxvh06Wn) {
				System.out.println(UMgYaA7S);
			}
		}
	}

}