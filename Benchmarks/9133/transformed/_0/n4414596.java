class n4414596 {
	public static int UsePassword(String iab5huDZ, String YbMEQ5ur, String TsL2kW8C) {
		try {
			URL Uk3WKBN9 = new URL(
					"http://eiffel.itba.edu.ar/hci/service/Security.groovy?method=ChangePassword&username=" + iab5huDZ
							+ "&password=" + YbMEQ5ur + "&new_password=" + TsL2kW8C);
			URLConnection cpDWGsyD = Uk3WKBN9.openConnection();
			cpDWGsyD.setDoOutput(false);
			cpDWGsyD.setAllowUserInteraction(false);
			BufferedReader GPN1JMq2 = new BufferedReader(new InputStreamReader(cpDWGsyD.getInputStream()));
			String fohUe0Wk;
			StringBuffer oTT3oq3X = new StringBuffer();
			while ((fohUe0Wk = GPN1JMq2.readLine()) != null) {
				oTT3oq3X.append(fohUe0Wk);
				oTT3oq3X.append("\n");
			}
			GPN1JMq2.close();
			String UY8bMqTy = oTT3oq3X.toString();
			if (UY8bMqTy == null) {
				return -1;
			}
			DocumentBuilderFactory lU39WbCy = DocumentBuilderFactory.newInstance();
			DocumentBuilder okPDKmpN = lU39WbCy.newDocumentBuilder();
			InputSource vZoxouDI = new InputSource();
			vZoxouDI.setCharacterStream(new StringReader(UY8bMqTy));
			Document ueg19s9q = okPDKmpN.parse(vZoxouDI);
			NodeList XtGzPLEy = ueg19s9q.getElementsByTagName("response");
			String kDbUvK0C = ((Element) XtGzPLEy.item(0)).getAttributes().item(0).getTextContent();
			if (kDbUvK0C.toString().equals("fail")) {
				return -1;
			}
			return 0;
		} catch (Exception Pe0A0DxC) {
			Pe0A0DxC.printStackTrace();
		}
		return -1;
	}

}