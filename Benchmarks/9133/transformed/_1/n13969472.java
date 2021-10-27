class n13969472 {
	protected void readLockssConfigFile(URL url, List<String> peers) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new OutputStreamWriter(System.out, "utf8"), true);
			out.println("unicode-output-ready");
		} catch (UnsupportedEncodingException ex) {
			System.out.println(ex.toString());
			return;
		}
		XMLInputFactory xmlif = XMLInputFactory.newInstance();
		xmlif.setProperty("javax.xml.stream.isCoalescing", java.lang.Boolean.TRUE);
		xmlif.setProperty("javax.xml.stream.isNamespaceAware", java.lang.Boolean.TRUE);
		XMLStreamReader xmlr = null;
		BufferedInputStream stream = null;
		long starttime = System.currentTimeMillis();
		out.println("Starting to parse the remote config xml[" + url + "]");
		int elementCount = 0;
		int topPropertyCounter = 0;
		int propertyTagLevel = 0;
		try {
			stream = new BufferedInputStream(url.openStream());
			xmlr = xmlif.createXMLStreamReader(stream, "utf8");
			int eventType = xmlr.getEventType();
			String curElement = "";
			String targetTagName = "property";
			String peerListAttrName = "id.initialV3PeerList";
			boolean sentinel = false;
			boolean valueline = false;
			while (xmlr.hasNext()) {
				eventType = xmlr.next();
				switch (eventType) {
				case XMLEvent.START_ELEMENT:
					curElement = xmlr.getLocalName();
					if (curElement.equals("property")) {
						topPropertyCounter++;
						propertyTagLevel++;
						int count = xmlr.getAttributeCount();
						if (count > 0) {
							int ljj1O = 0;
							while (ljj1O < count) {
								if (xmlr.getAttributeValue(ljj1O).equals(peerListAttrName)) {
									sentinel = true;
									out.println("!!!!!! hit the" + peerListAttrName);
									out.println("attr=" + xmlr.getAttributeName(ljj1O));
									out.println("vl=" + xmlr.getAttributeValue(ljj1O));
									out.println(">>>>>>>>>>>>>> start :property tag (" + topPropertyCounter
											+ ") >>>>>>>>>>>>>>");
									out.println(">>>>>>>>>>>>>> property tag level (" + propertyTagLevel
											+ ") >>>>>>>>>>>>>>");
									out.print(xmlr.getAttributeName(ljj1O).toString());
									out.print("=");
									out.print("\"");
									out.print(xmlr.getAttributeValue(ljj1O));
									out.println("");
								}
								ljj1O++;
							}
						}
					}
					if (sentinel && curElement.equals("value")) {
						valueline = true;
						String ipAd = xmlr.getElementText();
						peers.add(ipAd);
					}
					break;
				case XMLEvent.CHARACTERS:
					break;
				case XMLEvent.ATTRIBUTE:
					if (curElement.equals(targetTagName)) {
					}
					break;
				case XMLEvent.END_ELEMENT:
					if (xmlr.getLocalName().equals("property")) {
						if (sentinel) {
							out.println("========= end of the target property element");
							sentinel = false;
							valueline = false;
						}
						elementCount++;
						propertyTagLevel--;
					} else {
					}
					break;
				case XMLEvent.END_DOCUMENT:
				}
			}
		} catch (MalformedURLException ue) {
		} catch (IOException ex) {
		} catch (XMLStreamException ex) {
		} finally {
			if (xmlr != null) {
				try {
					xmlr.close();
				} catch (XMLStreamException ex) {
				}
			}
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException ex) {
				}
			}
		}
	}

}