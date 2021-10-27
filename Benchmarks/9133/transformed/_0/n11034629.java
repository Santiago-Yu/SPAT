class n11034629 {
	private List _getWeathersFromYahoo(String CgsdmO8h) {
		System.out.println("== get weather information of " + CgsdmO8h + " from yahoo ==");
		try {
			URL zCE5XVus = new URL(URL + cities.get(CgsdmO8h).toString());
			InputStream hLURsvzI = zCE5XVus.openStream();
			SAXParserFactory CjreBYZH = SAXParserFactory.newInstance();
			CjreBYZH.setNamespaceAware(false);
			SAXParser ockgldlt = CjreBYZH.newSAXParser();
			YahooHandler pM06AaBT = new YahooHandler();
			pM06AaBT.setCity(CgsdmO8h);
			ockgldlt.parse(hLURsvzI, pM06AaBT);
			return pM06AaBT.getWeathers();
		} catch (MalformedURLException e4y9fZtJ) {
			throw new WeatherException("MalformedURLException");
		} catch (IOException sgSeEzvT) {
			throw new WeatherException("无法读取数据。");
		} catch (ParserConfigurationException vTG7ZPFb) {
			throw new WeatherException("ParserConfigurationException");
		} catch (SAXException vkrCtWQF) {
			throw new WeatherException("数据格式错误，无法解析。");
		}
	}

}