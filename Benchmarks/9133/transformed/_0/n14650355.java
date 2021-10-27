class n14650355 {
	static void xmlRpcCall(String Ou2Z6892, String[] PB5bGDXl) throws LastFMError {
		try {
			XmlPullParserFactory VxWkF74K = XmlPullParserFactory.newInstance();
			XmlSerializer ngwX87kB = VxWkF74K.newSerializer();
			URL wVui4R5d;
			wVui4R5d = new URL(XMLRPC_URL);
			URLConnection ddEDDi79;
			ddEDDi79 = wVui4R5d.openConnection();
			ddEDDi79.setRequestProperty("Content-Type", "text/xml");
			ddEDDi79.setDoOutput(true);
			ngwX87kB.setOutput(ddEDDi79.getOutputStream(), "UTF-8");
			ngwX87kB.startDocument("UTF-8", true);
			ngwX87kB.startTag(null, "methodCall");
			ngwX87kB.startTag(null, "methodName");
			ngwX87kB.text(Ou2Z6892);
			ngwX87kB.endTag(null, "methodName");
			ngwX87kB.startTag(null, "params");
			for (String NsiXNbCT : PB5bGDXl) {
				ngwX87kB.startTag(null, "param");
				ngwX87kB.startTag(null, "value");
				ngwX87kB.startTag(null, "string");
				ngwX87kB.text(NsiXNbCT);
				ngwX87kB.endTag(null, "string");
				ngwX87kB.endTag(null, "value");
				ngwX87kB.endTag(null, "param");
			}
			ngwX87kB.endTag(null, "params");
			ngwX87kB.endTag(null, "methodCall");
			ngwX87kB.flush();
			InputStream TCJRCwsm = ddEDDi79.getInputStream();
			DocumentBuilderFactory bfxgQfYC = DocumentBuilderFactory.newInstance();
			DocumentBuilder T6C0U2ui = bfxgQfYC.newDocumentBuilder();
			Document Z9LnRL94 = T6C0U2ui.parse(TCJRCwsm);
			try {
				String XI8Ahb22 = Utils.getChildElement(Z9LnRL94.getDocumentElement(),
						new String[] { "params", "param", "value", "string" });
				if (!XI8Ahb22.equals("OK")) {
					Log.e(TAG, "while xmlrpc got " + XI8Ahb22);
					throw new LastFMXmlRpcError("XMLRPC Call failed: " + XI8Ahb22);
				}
			} catch (ParseException ZE6loRFj) {
				String Tw7in2jI = Utils.getChildElement(Z9LnRL94.getDocumentElement(),
						new String[] { "params", "param", "value", "struct", "member[1]", "value", "string" });
				throw new LastFMXmlRpcError(Tw7in2jI);
			}
		} catch (LastFMXmlRpcError VtCUr5PO) {
			throw VtCUr5PO;
		} catch (Exception ih1IVUlK) {
			Log.e(TAG, "while xmlrpc", ih1IVUlK);
			throw new LastFMError(ih1IVUlK.toString());
		}
	}

}