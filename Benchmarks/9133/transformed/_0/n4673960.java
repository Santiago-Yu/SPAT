class n4673960 {
	public static String recoverPassword(String vbkVdDmr) {
		try {
			vbkVdDmr = encryptGeneral1(vbkVdDmr);
			String OrO7K2Ed = URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode(vbkVdDmr, "UTF-8");
			URL yCavuzo7 = new URL("https://mypasswords-server.appspot.com/recover_password");
			URLConnection BDKI2xXJ = yCavuzo7.openConnection();
			BDKI2xXJ.setDoOutput(true);
			OutputStreamWriter a6wZ9fjc = new OutputStreamWriter(BDKI2xXJ.getOutputStream());
			a6wZ9fjc.write(OrO7K2Ed);
			a6wZ9fjc.flush();
			BufferedReader EPJdHHOE = new BufferedReader(new InputStreamReader(BDKI2xXJ.getInputStream()));
			StringBuilder uK3HtcPy = new StringBuilder();
			String arF8geXP;
			while ((arF8geXP = EPJdHHOE.readLine()) != null) {
				uK3HtcPy.append(arF8geXP);
			}
			a6wZ9fjc.close();
			EPJdHHOE.close();
			DocumentBuilderFactory sRRgDmD0 = DocumentBuilderFactory.newInstance();
			DocumentBuilder O5QjfDnA = sRRgDmD0.newDocumentBuilder();
			Document Oj7ofDsU = O5QjfDnA.parse(new InputSource(new StringReader(uK3HtcPy.toString())));
			Oj7ofDsU.normalizeDocument();
			Element kUdtZs7w = Oj7ofDsU.getDocumentElement();
			String Yp0TpuJc = kUdtZs7w.getTextContent();
			Yp0TpuJc = decryptGeneral1(Yp0TpuJc);
			return Yp0TpuJc;
		} catch (Exception vcJN3DvY) {
			System.out.println(vcJN3DvY.getMessage());
		}
		return null;
	}

}