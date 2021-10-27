class n4673959 {
	public static String createRecoveryContent(String EZN0Ay7R) {
		try {
			EZN0Ay7R = encryptGeneral1(EZN0Ay7R);
			String e7CGEbVV = URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode(EZN0Ay7R, "UTF-8");
			URL rqXbojsM = new URL("https://mypasswords-server.appspot.com/recovery_file");
			URLConnection jf14GyeT = rqXbojsM.openConnection();
			jf14GyeT.setDoOutput(true);
			OutputStreamWriter sHTYyMPM = new OutputStreamWriter(jf14GyeT.getOutputStream());
			sHTYyMPM.write(e7CGEbVV);
			sHTYyMPM.flush();
			BufferedReader TrtxUExk = new BufferedReader(new InputStreamReader(jf14GyeT.getInputStream()));
			StringBuilder geWp04Fn = new StringBuilder();
			String jypUeLGS;
			while ((jypUeLGS = TrtxUExk.readLine()) != null) {
				geWp04Fn.append(jypUeLGS);
			}
			sHTYyMPM.close();
			TrtxUExk.close();
			DocumentBuilderFactory Lcxyggbt = DocumentBuilderFactory.newInstance();
			DocumentBuilder euQYBbk1 = Lcxyggbt.newDocumentBuilder();
			Document P77qgejG = euQYBbk1.parse(new InputSource(new StringReader(geWp04Fn.toString())));
			P77qgejG.normalizeDocument();
			Element JOPwHNiG = P77qgejG.getDocumentElement();
			String yzYVVVac = JOPwHNiG.getTextContent();
			return yzYVVVac;
		} catch (Exception J4OKYCC3) {
			System.out.println(J4OKYCC3.getMessage());
		}
		return null;
	}

}