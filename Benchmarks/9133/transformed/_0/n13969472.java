class n13969472 {
	protected void readLockssConfigFile(URL oJwmZnK0, List<String> eSuIK7Y4) {
		PrintWriter VsLnRiq6 = null;
		try {
			VsLnRiq6 = new PrintWriter(new OutputStreamWriter(System.out, "utf8"), true);
			VsLnRiq6.println("unicode-output-ready");
		} catch (UnsupportedEncodingException p8tP0d1G) {
			System.out.println(p8tP0d1G.toString());
			return;
		}
		XMLInputFactory ERu7x4cL = XMLInputFactory.newInstance();
		ERu7x4cL.setProperty("javax.xml.stream.isCoalescing", java.lang.Boolean.TRUE);
		ERu7x4cL.setProperty("javax.xml.stream.isNamespaceAware", java.lang.Boolean.TRUE);
		XMLStreamReader Fz4X91MQ = null;
		BufferedInputStream LmGWBRaU = null;
		long aEdVlxrF = System.currentTimeMillis();
		VsLnRiq6.println("Starting to parse the remote config xml[" + oJwmZnK0 + "]");
		int U2aSe07P = 0;
		int xLnmR8FM = 0;
		int VdWM4EA4 = 0;
		try {
			LmGWBRaU = new BufferedInputStream(oJwmZnK0.openStream());
			Fz4X91MQ = ERu7x4cL.createXMLStreamReader(LmGWBRaU, "utf8");
			int DQs0UDdF = Fz4X91MQ.getEventType();
			String B3rWKkfv = "";
			String FOvkQnE3 = "property";
			String JaQorpsX = "id.initialV3PeerList";
			boolean iW2kyElp = false;
			boolean u1M6X1p8 = false;
			while (Fz4X91MQ.hasNext()) {
				DQs0UDdF = Fz4X91MQ.next();
				switch (DQs0UDdF) {
				case XMLEvent.START_ELEMENT:
					B3rWKkfv = Fz4X91MQ.getLocalName();
					if (B3rWKkfv.equals("property")) {
						xLnmR8FM++;
						VdWM4EA4++;
						int ylHAD8sA = Fz4X91MQ.getAttributeCount();
						if (ylHAD8sA > 0) {
							for (int HH7S7VvS = 0; HH7S7VvS < ylHAD8sA; HH7S7VvS++) {
								if (Fz4X91MQ.getAttributeValue(HH7S7VvS).equals(JaQorpsX)) {
									iW2kyElp = true;
									VsLnRiq6.println("!!!!!! hit the" + JaQorpsX);
									VsLnRiq6.println("attr=" + Fz4X91MQ.getAttributeName(HH7S7VvS));
									VsLnRiq6.println("vl=" + Fz4X91MQ.getAttributeValue(HH7S7VvS));
									VsLnRiq6.println(
											">>>>>>>>>>>>>> start :property tag (" + xLnmR8FM + ") >>>>>>>>>>>>>>");
									VsLnRiq6.println(
											">>>>>>>>>>>>>> property tag level (" + VdWM4EA4 + ") >>>>>>>>>>>>>>");
									VsLnRiq6.print(Fz4X91MQ.getAttributeName(HH7S7VvS).toString());
									VsLnRiq6.print("=");
									VsLnRiq6.print("\"");
									VsLnRiq6.print(Fz4X91MQ.getAttributeValue(HH7S7VvS));
									VsLnRiq6.println("");
								}
							}
						}
					}
					if (iW2kyElp && B3rWKkfv.equals("value")) {
						u1M6X1p8 = true;
						String sFnDs41f = Fz4X91MQ.getElementText();
						eSuIK7Y4.add(sFnDs41f);
					}
					break;
				case XMLEvent.CHARACTERS:
					break;
				case XMLEvent.ATTRIBUTE:
					if (B3rWKkfv.equals(FOvkQnE3)) {
					}
					break;
				case XMLEvent.END_ELEMENT:
					if (Fz4X91MQ.getLocalName().equals("property")) {
						if (iW2kyElp) {
							VsLnRiq6.println("========= end of the target property element");
							iW2kyElp = false;
							u1M6X1p8 = false;
						}
						U2aSe07P++;
						VdWM4EA4--;
					} else {
					}
					break;
				case XMLEvent.END_DOCUMENT:
				}
			}
		} catch (MalformedURLException dMoyJGnX) {
		} catch (IOException J74Ae9gI) {
		} catch (XMLStreamException bL7prbd6) {
		} finally {
			if (Fz4X91MQ != null) {
				try {
					Fz4X91MQ.close();
				} catch (XMLStreamException F21zprK1) {
				}
			}
			if (LmGWBRaU != null) {
				try {
					LmGWBRaU.close();
				} catch (IOException T9X3XY01) {
				}
			}
		}
	}

}