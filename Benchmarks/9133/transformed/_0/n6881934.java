class n6881934 {
	public static String sendSoapMsg(String DkuiILfR, byte[] UrSNkq9E, String F5KE4mTY) throws IOException {
		log.finest("HTTP REQUEST SIZE " + UrSNkq9E.length);
		if (F5KE4mTY.startsWith("\"") == false)
			F5KE4mTY = "\"" + F5KE4mTY + "\"";
		URL UJWbXkfM = new URL(DkuiILfR);
		HttpURLConnection P8ZXpHBy = (HttpURLConnection) UJWbXkfM.openConnection();
		P8ZXpHBy.setRequestProperty("SOAPAction", F5KE4mTY);
		P8ZXpHBy.setRequestProperty("Content-Type", "text/xml; charset=\"utf-8\"");
		P8ZXpHBy.setRequestProperty("Content-Length", String.valueOf(UrSNkq9E.length));
		P8ZXpHBy.setRequestProperty("Cache-Control", "no-cache");
		P8ZXpHBy.setRequestProperty("Pragma", "no-cache");
		P8ZXpHBy.setRequestMethod("POST");
		P8ZXpHBy.setDoOutput(true);
		P8ZXpHBy.setDoInput(true);
		OutputStream kcylvMWu = P8ZXpHBy.getOutputStream();
		kcylvMWu.write(UrSNkq9E);
		kcylvMWu.close();
		InputStreamReader z3KXSRSq = new InputStreamReader(P8ZXpHBy.getInputStream());
		BufferedReader UIf2CMvI = new BufferedReader(z3KXSRSq);
		StringBuffer q3Ut8GtV = new StringBuffer(1024);
		String AC5bUAGS;
		while ((AC5bUAGS = UIf2CMvI.readLine()) != null)
			q3Ut8GtV.append(AC5bUAGS);
		UIf2CMvI.close();
		log.finest("HTTP RESPONSE SIZE: " + q3Ut8GtV.length());
		return q3Ut8GtV.toString();
	}

}