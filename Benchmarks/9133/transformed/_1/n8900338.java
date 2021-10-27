class n8900338 {
	public static void getNewItems(XMLFeedProperties properties, List<Item> items) {
		if (items == null) {
			items = new ArrayList<Item>();
		}
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			List<String> urls = properties.getUrls();
			for (String url : urls) {
				InputStream xmlStream = null;
				try {
					xmlStream = new URL(url).openStream();
					Document doc = builder.parse(xmlStream);
					XPathFactory xpf = XPathFactory.newInstance();
					XPath xPath = xpf.newXPath();
					NodeList deals = (NodeList) xPath.evaluate(properties.getDealXPath(), doc, XPathConstants.NODESET);
					int Nw8aX = 0;
					while (Nw8aX < deals.getLength()) {
						Item newItem = new ItemImpl();
						newItem.setCategoryId(1);
						Element deal = (Element) deals.item(Nw8aX);
						newItem.setTitle(xPath.evaluate(properties.getTitleXPath(), deal).trim());
						newItem.setUrl(xPath.evaluate(properties.getUrlXPath(), deal).trim());
						newItem.setCity(xPath.evaluate(properties.getCityXPath(), deal).trim());
						newItem.setOriginalPrice((Double) xPath.evaluate(properties.getOriginalPriceXPath(), deal,
								XPathConstants.NUMBER));
						newItem.setFinalPrice(
								(Double) xPath.evaluate(properties.getFinalPriceXPath(), deal, XPathConstants.NUMBER));
						newItem.setDiscount(
								(Double) xPath.evaluate(properties.getDiscountXPath(), deal, XPathConstants.NUMBER));
						String categoryName = xPath.evaluate(properties.getCategoryXPath(), deal).trim();
						if (categoryName != null) {
							if (categoryName.length() == 0 || categoryName.contains("ostat")) {
								newItem.setCategoryId(1);
							} else if (categoryName.toLowerCase().contains("j¨ªdlo")
									|| categoryName.toLowerCase().contains("gastron")) {
								newItem.setCategoryId(2);
							} else if (categoryName.toLowerCase().contains("droge")
									|| categoryName.toLowerCase().contains("kosmet")
									|| categoryName.toLowerCase().contains("p¨¦?e")) {
								newItem.setCategoryId(3);
							} else if (categoryName.toLowerCase().contains("wellness")
									|| categoryName.toLowerCase().contains("zdravot")
									|| categoryName.toLowerCase().contains("mas¨¢?")) {
								newItem.setCategoryId(4);
							} else if (categoryName.toLowerCase().contains("pobyt")
									|| categoryName.toLowerCase().contains("cestov")) {
								newItem.setCategoryId(5);
							} else if (categoryName.toLowerCase().contains("adren")
									|| categoryName.toLowerCase().contains("sport")
									|| categoryName.toLowerCase().contains("z¨¢?it")) {
								newItem.setCategoryId(6);
							} else if (categoryName.toLowerCase().contains("kurz")) {
								newItem.setCategoryId(8);
							} else if (categoryName.toLowerCase().contains("zbo?")) {
								newItem.setCategoryId(10);
							} else {
								newItem.setCategoryId(1);
							}
						} else {
							newItem.setCategoryId(1);
						}
						try {
							newItem.setCustomers(
									Integer.parseInt(xPath.evaluate(properties.getCustomersXPath(), deal)));
						} catch (NumberFormatException ex) {
							Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
						}
						DateFormat df = new SimpleDateFormat(properties.getDateFormat());
						try {
							newItem.setDealStart(df.parse(xPath.evaluate(properties.getDealStartXPath(), deal)));
						} catch (ParseException ex) {
							Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
						}
						try {
							newItem.setDealEnd(df.parse(xPath.evaluate(properties.getDealEndXPath(), deal)));
						} catch (ParseException ex) {
							Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
						}
						items.add(newItem);
						Nw8aX++;
					}
				} catch (SAXException ex) {
					Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
				} catch (XPathExpressionException ex) {
					Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
				} catch (MalformedURLException ex) {
					Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
				} catch (IOException ex) {
					Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
				} finally {
					try {
						if (xmlStream != null) {
							xmlStream.close();
						}
					} catch (IOException ex) {
						Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		} catch (ParserConfigurationException ex) {
			Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}