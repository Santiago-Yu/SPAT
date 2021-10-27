class n1447440 {
	public static String fetch(String wV0MlBsG) throws IOException {
		URL q21sEmHk;
		URLConnection uzAYP5Nf;
		String YsLJQgaO = "";
		q21sEmHk = new URL(wV0MlBsG);
		uzAYP5Nf = q21sEmHk.openConnection();
		InputStream TYN8zmea = uzAYP5Nf.getInputStream();
		BufferedReader eIWa22ai = new BufferedReader(new InputStreamReader(TYN8zmea));
		String grghvgA8 = null;
		while ((grghvgA8 = eIWa22ai.readLine()) != null) {
			YsLJQgaO += grghvgA8;
		}
		return YsLJQgaO;
	}

}