class n8900338 {
	public static void getNewItems(XMLFeedProperties AzafZG3q, List<Item> ypc0NEIF) {
		if (ypc0NEIF == null) {
			ypc0NEIF = new ArrayList<Item>();
		}
		try {
			DocumentBuilderFactory ljeKVmcN = DocumentBuilderFactory.newInstance();
			DocumentBuilder CZZTQxZr = ljeKVmcN.newDocumentBuilder();
			List<String> cyFprloQ = AzafZG3q.getUrls();
			for (String ezSve7TH : cyFprloQ) {
				InputStream RPSCVPML = null;
				try {
					RPSCVPML = new URL(ezSve7TH).openStream();
					Document KdgZMnW2 = CZZTQxZr.parse(RPSCVPML);
					XPathFactory ObJhMB3Q = XPathFactory.newInstance();
					XPath sIoJsfOJ = ObJhMB3Q.newXPath();
					NodeList EMoUItez = (NodeList) sIoJsfOJ.evaluate(AzafZG3q.getDealXPath(), KdgZMnW2,
							XPathConstants.NODESET);
					for (int TEzCoHx1 = 0; TEzCoHx1 < EMoUItez.getLength(); TEzCoHx1++) {
						Item vj24aSCb = new ItemImpl();
						vj24aSCb.setCategoryId(1);
						Element Zz7Nm9Jx = (Element) EMoUItez.item(TEzCoHx1);
						vj24aSCb.setTitle(sIoJsfOJ.evaluate(AzafZG3q.getTitleXPath(), Zz7Nm9Jx).trim());
						vj24aSCb.setUrl(sIoJsfOJ.evaluate(AzafZG3q.getUrlXPath(), Zz7Nm9Jx).trim());
						vj24aSCb.setCity(sIoJsfOJ.evaluate(AzafZG3q.getCityXPath(), Zz7Nm9Jx).trim());
						vj24aSCb.setOriginalPrice((Double) sIoJsfOJ.evaluate(AzafZG3q.getOriginalPriceXPath(), Zz7Nm9Jx,
								XPathConstants.NUMBER));
						vj24aSCb.setFinalPrice((Double) sIoJsfOJ.evaluate(AzafZG3q.getFinalPriceXPath(), Zz7Nm9Jx,
								XPathConstants.NUMBER));
						vj24aSCb.setDiscount((Double) sIoJsfOJ.evaluate(AzafZG3q.getDiscountXPath(), Zz7Nm9Jx,
								XPathConstants.NUMBER));
						String bGKtHDfZ = sIoJsfOJ.evaluate(AzafZG3q.getCategoryXPath(), Zz7Nm9Jx).trim();
						if (bGKtHDfZ != null) {
							if (bGKtHDfZ.length() == 0 || bGKtHDfZ.contains("ostat")) {
								vj24aSCb.setCategoryId(1);
							} else if (bGKtHDfZ.toLowerCase().contains("j¨ªdlo")
									|| bGKtHDfZ.toLowerCase().contains("gastron")) {
								vj24aSCb.setCategoryId(2);
							} else if (bGKtHDfZ.toLowerCase().contains("droge")
									|| bGKtHDfZ.toLowerCase().contains("kosmet")
									|| bGKtHDfZ.toLowerCase().contains("p¨¦?e")) {
								vj24aSCb.setCategoryId(3);
							} else if (bGKtHDfZ.toLowerCase().contains("wellness")
									|| bGKtHDfZ.toLowerCase().contains("zdravot")
									|| bGKtHDfZ.toLowerCase().contains("mas¨¢?")) {
								vj24aSCb.setCategoryId(4);
							} else if (bGKtHDfZ.toLowerCase().contains("pobyt")
									|| bGKtHDfZ.toLowerCase().contains("cestov")) {
								vj24aSCb.setCategoryId(5);
							} else if (bGKtHDfZ.toLowerCase().contains("adren")
									|| bGKtHDfZ.toLowerCase().contains("sport")
									|| bGKtHDfZ.toLowerCase().contains("z¨¢?it")) {
								vj24aSCb.setCategoryId(6);
							} else if (bGKtHDfZ.toLowerCase().contains("kurz")) {
								vj24aSCb.setCategoryId(8);
							} else if (bGKtHDfZ.toLowerCase().contains("zbo?")) {
								vj24aSCb.setCategoryId(10);
							} else {
								vj24aSCb.setCategoryId(1);
							}
						} else {
							vj24aSCb.setCategoryId(1);
						}
						try {
							vj24aSCb.setCustomers(
									Integer.parseInt(sIoJsfOJ.evaluate(AzafZG3q.getCustomersXPath(), Zz7Nm9Jx)));
						} catch (NumberFormatException kAXZd2Fk) {
							Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, kAXZd2Fk);
						}
						DateFormat GOkyVTGo = new SimpleDateFormat(AzafZG3q.getDateFormat());
						try {
							vj24aSCb.setDealStart(
									GOkyVTGo.parse(sIoJsfOJ.evaluate(AzafZG3q.getDealStartXPath(), Zz7Nm9Jx)));
						} catch (ParseException JFszst2i) {
							Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, JFszst2i);
						}
						try {
							vj24aSCb.setDealEnd(
									GOkyVTGo.parse(sIoJsfOJ.evaluate(AzafZG3q.getDealEndXPath(), Zz7Nm9Jx)));
						} catch (ParseException zuhHSgin) {
							Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, zuhHSgin);
						}
						ypc0NEIF.add(vj24aSCb);
					}
				} catch (SAXException oQzZm70Q) {
					Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, oQzZm70Q);
				} catch (XPathExpressionException IDZPpxp5) {
					Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, IDZPpxp5);
				} catch (MalformedURLException dEWMKD7s) {
					Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, dEWMKD7s);
				} catch (IOException PYoRMlMT) {
					Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, PYoRMlMT);
				} finally {
					try {
						if (RPSCVPML != null) {
							RPSCVPML.close();
						}
					} catch (IOException psZ432h7) {
						Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, psZ432h7);
					}
				}
			}
		} catch (ParserConfigurationException QOLk0pWp) {
			Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, QOLk0pWp);
		}
	}

}