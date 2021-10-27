class n7500669 {
	public static void main(String[] uNe70vpv) throws Exception {
		if (uNe70vpv.length < 2) {
			System.err.println("Usage:  java SOAPClient4XG " + "http://soapURL soapEnvelopefile.xml" + " [SOAPAction]");
			System.err.println("SOAPAction is optional.");
			System.exit(1);
		}
		String asErC3PN = uNe70vpv[0];
		String g1WqpJ5s = uNe70vpv[1];
		String Wtwdji1a = "";
		if (uNe70vpv.length > 2)
			Wtwdji1a = uNe70vpv[2];
		URL Lr5msYAU = new URL(asErC3PN);
		URLConnection Dg4TIMw5 = Lr5msYAU.openConnection();
		HttpURLConnection hktMUk6R = (HttpURLConnection) Dg4TIMw5;
		FileInputStream dYsxo9O0 = new FileInputStream(g1WqpJ5s);
		ByteArrayOutputStream BSuoa15Z = new ByteArrayOutputStream();
		copy(dYsxo9O0, BSuoa15Z);
		dYsxo9O0.close();
		byte[] oDtT9qzy = BSuoa15Z.toByteArray();
		hktMUk6R.setRequestProperty("Content-Length", String.valueOf(oDtT9qzy.length));
		hktMUk6R.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		hktMUk6R.setRequestProperty("SOAPAction", Wtwdji1a);
		hktMUk6R.setRequestMethod("POST");
		hktMUk6R.setDoOutput(true);
		hktMUk6R.setDoInput(true);
		OutputStream XsaksvW8 = hktMUk6R.getOutputStream();
		XsaksvW8.write(oDtT9qzy);
		XsaksvW8.close();
		InputStreamReader KdNIHfoJ = new InputStreamReader(hktMUk6R.getInputStream());
		BufferedReader ZKX66gta = new BufferedReader(KdNIHfoJ);
		String renfoVAC;
		while ((renfoVAC = ZKX66gta.readLine()) != null)
			System.out.println(renfoVAC);
		ZKX66gta.close();
	}

}