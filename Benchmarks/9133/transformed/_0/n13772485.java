class n13772485 {
	private static String getData(String kOoM4SET) throws Exception {
		URL fTnd3TYx = new URL(kOoM4SET);
		uc = (HttpURLConnection) fTnd3TYx.openConnection();
		if (login) {
			uc.setRequestProperty("Cookie", logincookie + ";" + xfsscookie);
		}
		br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		String N0wxRCfs = "", uhn7rDFZ = "";
		while ((N0wxRCfs = br.readLine()) != null) {
			uhn7rDFZ += N0wxRCfs;
		}
		br.close();
		return uhn7rDFZ;
	}

}