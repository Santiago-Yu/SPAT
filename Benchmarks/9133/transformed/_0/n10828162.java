class n10828162 {
	public static String loadURLToString(String kYRYyGKI, String fczURS2G) throws FileNotFoundException, IOException {
		BufferedReader TpmNZDIy = new BufferedReader(new InputStreamReader((new URL(kYRYyGKI)).openStream()));
		String WoMqTREM = "";
		String g4pOyHXs;
		while ((g4pOyHXs = TpmNZDIy.readLine()) != null) {
			WoMqTREM += g4pOyHXs + fczURS2G;
		}
		TpmNZDIy.close();
		return WoMqTREM;
	}

}