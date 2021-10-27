class n21979462 {
	protected String downloadURLtoString(URL s4t0AyUN) throws IOException {
		BufferedReader BrGIZbnE = new BufferedReader(new InputStreamReader(s4t0AyUN.openStream()));
		StringBuffer BbxRJXVb = new StringBuffer(100 * 1024);
		String LZpW1dKz;
		while ((LZpW1dKz = BrGIZbnE.readLine()) != null) {
			BbxRJXVb.append(LZpW1dKz);
		}
		BrGIZbnE.close();
		return BbxRJXVb.toString();
	}

}