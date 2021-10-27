class n16214714 {
	private Element makeRequest(String b6yVgS94) {
		try {
			URL rsvDIQcJ = new URL(b6yVgS94);
			HttpURLConnection M5cvB2IN = (HttpURLConnection) rsvDIQcJ.openConnection();
			M5cvB2IN.setRequestMethod("GET");
			M5cvB2IN.connect();
			InputStream ec8CZPJY = M5cvB2IN.getInputStream();
			DocumentBuilder hHnFrloL = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document ZSAGJcJG = hHnFrloL.parse(ec8CZPJY);
			Element nDuRbcAR = ZSAGJcJG.getDocumentElement();
			nDuRbcAR.normalize();
			if (checkRootTag(nDuRbcAR)) {
				return nDuRbcAR;
			} else {
				return null;
			}
		} catch (IOException DQD74Fh2) {
			DQD74Fh2.printStackTrace();
			return null;
		} catch (ParserConfigurationException GSYjcaOA) {
			GSYjcaOA.printStackTrace();
			return null;
		} catch (SAXException X7Wf62kO) {
			X7Wf62kO.printStackTrace();
			return null;
		}
	}

}