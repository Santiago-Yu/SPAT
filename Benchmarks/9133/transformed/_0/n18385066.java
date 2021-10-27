class n18385066 {
	public static Document getResponse(HttpClient dmNxHpNN, HttpRequestBase SJbcFzDB) {
		try {
			HttpResponse dxvoxcrA = dmNxHpNN.execute(SJbcFzDB);
			StatusLine WeL2z3Cl = dxvoxcrA.getStatusLine();
			System.err.println(WeL2z3Cl.getStatusCode() + " data: " + WeL2z3Cl.getReasonPhrase());
			System.err.println("executing request " + SJbcFzDB.getURI());
			HttpEntity pMveUASO = dxvoxcrA.getEntity();
			DocumentBuilder O4qfc5mB = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document nYSYylSe = O4qfc5mB.parse(pMveUASO.getContent());
			return nYSYylSe;
		} catch (ClientProtocolException nuWsTMig) {
			nuWsTMig.printStackTrace();
		} catch (IOException jJpmXogf) {
			jJpmXogf.printStackTrace();
		} catch (ParserConfigurationException hBTzw29c) {
			hBTzw29c.printStackTrace();
		} catch (IllegalStateException JyC41gNV) {
			JyC41gNV.printStackTrace();
		} catch (SAXException PpftYXNi) {
			PpftYXNi.printStackTrace();
		}
		return null;
	}

}