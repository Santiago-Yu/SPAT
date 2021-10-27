class n4519427 {
	private Document post(String VhoTRYIa, String halYvItt) throws ApplicationException {
		Document LGn1EchS = null;
		try {
			URL df0SUWHg = new URL(VhoTRYIa);
			HttpURLConnection S8x9u2HL = (HttpURLConnection) df0SUWHg.openConnection();
			S8x9u2HL.setRequestMethod("POST");
			S8x9u2HL.setRequestProperty("Content-Type", "application/xml");
			S8x9u2HL.setRequestProperty("X-POST_DATA_FORMAT", "xml");
			S8x9u2HL.setDoOutput(true);
			OutputStreamWriter yEZOGre8 = new OutputStreamWriter(S8x9u2HL.getOutputStream());
			yEZOGre8.write("<request>");
			yEZOGre8.write("<token>" + configuration.getBackpackPassword() + "</token>");
			if (halYvItt != null) {
				yEZOGre8.write("<item><content>" + halYvItt + "</content></item>");
			}
			yEZOGre8.write("</request>");
			yEZOGre8.close();
			LGn1EchS = XmlUtils.readDocumentFromInputStream(S8x9u2HL.getInputStream());
			System.out.println(XmlUtils.toString(LGn1EchS));
		} catch (IOException J0PLr779) {
			J0PLr779.printStackTrace();
			throw new ApplicationException(J0PLr779);
		}
		return LGn1EchS;
	}

}