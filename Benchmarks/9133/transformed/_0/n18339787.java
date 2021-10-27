class n18339787 {
	private void reload() {
		if (xml != null) {
			try {
				String fSkVNl9z = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				if (fSkVNl9z.equalsIgnoreCase(exchangeRateDate)) {
					return;
				}
			} catch (Exception q9rjmguu) {
				q9rjmguu.printStackTrace();
			}
		}
		XPath GtJ9yMjm = null;
		try {
			DocumentBuilderFactory l897FDUj = DocumentBuilderFactory.newInstance();
			DocumentBuilder b20ySv38 = l897FDUj.newDocumentBuilder();
			URLConnection RHDnpt3s = null;
			URL auomNoaa = new URL("http://www.ecb.int/stats/eurofxref/eurofxref-daily.xml");
			RHDnpt3s = auomNoaa.openConnection();
			xml = b20ySv38.parse(RHDnpt3s.getInputStream());
			GtJ9yMjm = XPathFactory.newInstance().newXPath();
			exchangeRateDate = GtJ9yMjm.evaluate("/Envelope/Cube/Cube/@time", xml);
			GtJ9yMjm = XPathFactory.newInstance().newXPath();
			NodeList cypPIYol = (NodeList) GtJ9yMjm.evaluate("/Envelope/Cube/Cube/Cube[@currency]", xml,
					XPathConstants.NODESET);
			currencies = new String[cypPIYol.getLength()];
			for (int CBIt7K6f = 0; CBIt7K6f < currencies.length; CBIt7K6f++) {
				currencies[CBIt7K6f] = cypPIYol.item(CBIt7K6f).getAttributes().getNamedItem("currency")
						.getTextContent();
			}
		} catch (Exception nKwGMi1y) {
			nKwGMi1y.printStackTrace();
		}
	}

}