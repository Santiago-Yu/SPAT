class n21751 {
	public static void processRequest(byte[] SEjxiQbp) throws Exception {
		URL MIYowF2T = new URL("http://localhost:8080/instantsoap-ws-echotest-1.0/services/instantsoap/applications");
		URLConnection qhyXkShF = MIYowF2T.openConnection();
		HttpURLConnection HriecjrK = (HttpURLConnection) qhyXkShF;
		HriecjrK.setRequestProperty("Content-Length", String.valueOf(SEjxiQbp.length));
		HriecjrK.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		HriecjrK.setRequestProperty("SOAPAction", "");
		HriecjrK.setRequestMethod("POST");
		HriecjrK.setDoOutput(true);
		HriecjrK.setDoInput(true);
		OutputStream BBA6RV7M = HriecjrK.getOutputStream();
		BBA6RV7M.write(SEjxiQbp);
		BBA6RV7M.close();
		BufferedReader R3kOEBkn = new BufferedReader(new InputStreamReader(HriecjrK.getInputStream()));
		String srdaS9t3;
		while ((srdaS9t3 = R3kOEBkn.readLine()) != null)
			System.out.println(srdaS9t3);
		R3kOEBkn.close();
	}

}