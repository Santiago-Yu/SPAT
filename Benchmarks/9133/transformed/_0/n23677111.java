class n23677111 {
	public static String downloadWebpage1(String OF0UXTRH) throws MalformedURLException, IOException {
		URL OKcECw97 = new URL(OF0UXTRH);
		BufferedReader gpG1u4Gt = new BufferedReader(new InputStreamReader(OKcECw97.openStream()));
		String xNYY9Sg3;
		String udu7ldC2 = "";
		while ((xNYY9Sg3 = gpG1u4Gt.readLine()) != null) {
			udu7ldC2 += xNYY9Sg3 + "\n";
		}
		gpG1u4Gt.close();
		return udu7ldC2;
	}

}