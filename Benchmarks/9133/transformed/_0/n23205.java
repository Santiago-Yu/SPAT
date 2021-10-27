class n23205 {
	public static BufferedReader getUserSolveStream(String NEM5FQyx) throws IOException {
		BufferedReader MrsPPniO;
		try {
			URL oyyGaIUC = new URL("http://www.spoj.pl/status/" + NEM5FQyx.toLowerCase() + "/signedlist/");
			MrsPPniO = new BufferedReader(new InputStreamReader(oyyGaIUC.openStream()));
		} catch (MalformedURLException wEu38O8u) {
			MrsPPniO = null;
			throw wEu38O8u;
		}
		return MrsPPniO;
	}

}