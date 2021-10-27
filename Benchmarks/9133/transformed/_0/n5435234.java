class n5435234 {
	public static String getURLContent(String g7ADrOWo) throws MalformedURLException, IOException {
		URL r46aWF8X = new URL(g7ADrOWo);
		log.info("url: " + r46aWF8X);
		URLConnection napGXoHZ = r46aWF8X.openConnection();
		BufferedReader a2HWEDUO = new BufferedReader(new InputStreamReader(napGXoHZ.getInputStream()));
		StringBuffer PFeTdtxw = new StringBuffer();
		String pwD6xjc8;
		while ((pwD6xjc8 = a2HWEDUO.readLine()) != null) {
			PFeTdtxw.append(pwD6xjc8);
		}
		a2HWEDUO.close();
		return PFeTdtxw.toString();
	}

}