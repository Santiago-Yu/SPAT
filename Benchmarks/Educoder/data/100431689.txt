    private void reload() {
        if (xml != null) {
            try {
                String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                if (currentDate.equalsIgnoreCase(exchangeRateDate)) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        XPath xpath = null;
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            URLConnection conn = null;
            URL url = new URL("http://www.ecb.int/stats/eurofxref/eurofxref-daily.xml");
            conn = url.openConnection();
            xml = docBuilder.parse(conn.getInputStream());
            xpath = XPathFactory.newInstance().newXPath();
            exchangeRateDate = xpath.evaluate("/Envelope/Cube/Cube/@time", xml);
            xpath = XPathFactory.newInstance().newXPath();
            NodeList currenciesNode = (NodeList) xpath.evaluate("/Envelope/Cube/Cube/Cube[@currency]", xml, XPathConstants.NODESET);
            currencies = new String[currenciesNode.getLength()];
            for (int i = 0; i < currencies.length; i++) {
                currencies[i] = currenciesNode.item(i).getAttributes().getNamedItem("currency").getTextContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
