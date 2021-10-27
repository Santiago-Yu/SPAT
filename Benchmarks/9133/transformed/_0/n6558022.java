class n6558022 {
	public static String CheckUrl(String z7V5g12J) {
		String ffhB04yV = "";
		try {
			URL QdK8mqlw = new URL(z7V5g12J);
			HttpURLConnection Ru3rCEtV = (HttpURLConnection) QdK8mqlw.openConnection();
			BufferedReader PdLj0FG6 = new BufferedReader(new InputStreamReader(Ru3rCEtV.getInputStream()));
			ffhB04yV = PdLj0FG6.readLine().toString();
		} catch (Exception VHQZFAdq) {
			VHQZFAdq.printStackTrace();
		}
		return ffhB04yV;
	}

}