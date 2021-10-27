class n3609806 {
	private static String getData(String jlOYMtVQ) throws Exception {
		System.out.println("getdata");
		URL LQf0bn06 = new URL(jlOYMtVQ);
		uc = (HttpURLConnection) LQf0bn06.openConnection();
		br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		String n1JzN5lQ = "", tSS4ZdQ3 = "";
		while ((n1JzN5lQ = br.readLine()) != null) {
			System.out.println(n1JzN5lQ);
			tSS4ZdQ3 += n1JzN5lQ;
		}
		br.close();
		return tSS4ZdQ3;
	}

}