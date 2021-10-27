class n15017482 {
	private static String getSuitableWCSVersion(String host, String _version) throws ConnectException, IOException {
		String request = WCSProtocolHandler.buildCapabilitiesSuitableVersionRequest(host, _version);
		StringReader reader = null;
		String version = new String();
		DataInputStream dis = null;
		try {
			byte[] buffer = new byte[1024];
			URL url = new URL(request);
			dis = new DataInputStream(url.openStream());
			dis.readFully(buffer);
			KXmlParser kxmlParser = null;
			reader = new StringReader(new String(buffer));
			kxmlParser = new KXmlParser();
			kxmlParser.setInput(reader);
			kxmlParser.nextTag();
			if (kxmlParser.getEventType() != KXmlParser.END_DOCUMENT) {
				if ((kxmlParser.getName().compareTo(CapabilitiesTags.WCS_CAPABILITIES_ROOT1_0_0) == 0)) {
					version = kxmlParser.getAttributeValue("", CapabilitiesTags.VERSION);
				}
			}
			reader.close();
			dis.close();
			return version;
		} catch (ConnectException conEx) {
			throw new ConnectException(conEx.getMessage());
		} catch (IOException ioEx) {
			throw new IOException(ioEx.getMessage());
		} catch (XmlPullParserException xmlEx) {
			xmlEx.printStackTrace();
			return "";
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (dis != null) {
				try {
					dis.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}