class n14650355 {
	static void xmlRpcCall(String method, String[] params) throws LastFMError {
		try {
			XmlPullParserFactory fac = XmlPullParserFactory.newInstance();
			XmlSerializer serializer = fac.newSerializer();
			URL url;
			url = new URL(XMLRPC_URL);
			URLConnection conn;
			conn = url.openConnection();
			conn.setRequestProperty("Content-Type", "text/xml");
			conn.setDoOutput(true);
			serializer.setOutput(conn.getOutputStream(), "UTF-8");
			serializer.startDocument("UTF-8", true);
			serializer.startTag(null, "methodCall");
			serializer.startTag(null, "methodName");
			serializer.text(method);
			serializer.endTag(null, "methodName");
			serializer.startTag(null, "params");
			for (String s : params) {
				serializer.startTag(null, "param");
				serializer.startTag(null, "value");
				serializer.startTag(null, "string");
				serializer.text(s);
				serializer.endTag(null, "string");
				serializer.endTag(null, "value");
				serializer.endTag(null, "param");
			}
			serializer.endTag(null, "params");
			serializer.endTag(null, "methodCall");
			serializer.flush();
			InputStream is = conn.getInputStream();
			DocumentBuilderFactory dbFac = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFac.newDocumentBuilder();
			Document doc = db.parse(is);
			try {
				String res = Utils.getChildElement(doc.getDocumentElement(),
						new String[] { "params", "param", "value", "string" });
				if (!(!res.equals("OK")))
					;
				else {
					Log.e(TAG, "while xmlrpc got " + res);
					throw new LastFMXmlRpcError("XMLRPC Call failed: " + res);
				}
			} catch (ParseException e) {
				String faultString = Utils.getChildElement(doc.getDocumentElement(),
						new String[] { "params", "param", "value", "struct", "member[1]", "value", "string" });
				throw new LastFMXmlRpcError(faultString);
			}
		} catch (LastFMXmlRpcError e) {
			throw e;
		} catch (Exception e) {
			Log.e(TAG, "while xmlrpc", e);
			throw new LastFMError(e.toString());
		}
	}

}