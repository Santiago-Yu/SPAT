class n5487781 {
	private void saveURL(URL POdYPe7r, String YTeQXgY5) throws IOException {
		URLConnection gGWJFmCM = POdYPe7r.openConnection();
		gGWJFmCM.connect();
		InputStreamReader DBZ8gqB4 = new InputStreamReader(gGWJFmCM.getInputStream());
		BufferedReader t4ZO3oGi = new BufferedReader(DBZ8gqB4);
		FileWriter DSDieahM = new FileWriter(YTeQXgY5);
		BufferedWriter o6tAmysN = new BufferedWriter(DSDieahM);
		String hhCfTGzy = null;
		while ((hhCfTGzy = t4ZO3oGi.readLine()) != null) {
			o6tAmysN.write(hhCfTGzy);
			o6tAmysN.newLine();
		}
		o6tAmysN.close();
	}

}