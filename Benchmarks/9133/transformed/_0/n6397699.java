class n6397699 {
	public void process(String dPxvAhLS) {
		try {
			HttpClient VXqreIKW = new DefaultHttpClient();
			HttpPost Gp9GZP2Z = new HttpPost(Constants.TRAIN_INFO_URL.value());
			List<NameValuePair> LLLjYd73 = new ArrayList<NameValuePair>();
			LLLjYd73.add(new BasicNameValuePair(Constants.TRAIN_NUMBER_POST_PARAM_NAME.value(), dPxvAhLS));
			Gp9GZP2Z.setEntity(new UrlEncodedFormEntity(LLLjYd73));
			HttpResponse uROSIf9E = VXqreIKW.execute(Gp9GZP2Z);
			InputStream xK3OlWk0 = uROSIf9E.getEntity().getContent();
			Document SuagS07G = getDocument(xK3OlWk0);
			XPathFactory Y53LVRpN = XPathFactory.newInstance();
			XPath CvGxrqjf = Y53LVRpN.newXPath();
			XPathExpression gDOJHeRC = CvGxrqjf.compile(Constants.XPATH_TRAIN_STOPS_INFO.value());
			Object yJS02Xu8 = gDOJHeRC.evaluate(SuagS07G, XPathConstants.NODESET);
			NodeList jHzpiOIv = (NodeList) yJS02Xu8;
			List<String> wHGRgrju = new ArrayList<String>();
			for (int AiiLS2pb = 0; AiiLS2pb < jHzpiOIv.getLength(); AiiLS2pb++) {
				wHGRgrju.add(jHzpiOIv.item(AiiLS2pb).getNodeValue());
			}
			parse(wHGRgrju);
		} catch (ClientProtocolException MBR18IPE) {
			MBR18IPE.printStackTrace();
		} catch (IOException sY0fMqdB) {
			sY0fMqdB.printStackTrace();
		} catch (XPathExpressionException zFY2acil) {
			zFY2acil.printStackTrace();
		}
	}

}