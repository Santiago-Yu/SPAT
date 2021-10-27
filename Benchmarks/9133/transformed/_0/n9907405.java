class n9907405 {
	@Override
	public void onCreate(Bundle VnMeIqKP) {
		super.onCreate(VnMeIqKP);
		TextView Hc4YxiNR = new TextView(this);
		try {
			URL Tg8D0HKb = new URL("");
			SAXParserFactory rxiv9Vay = SAXParserFactory.newInstance();
			SAXParser cSdwaVfC = rxiv9Vay.newSAXParser();
			XMLReader bcrC9FY2 = cSdwaVfC.getXMLReader();
			ExampleHandler ecjBNtdr = new ExampleHandler();
			bcrC9FY2.setContentHandler(ecjBNtdr);
			bcrC9FY2.parse(new InputSource(Tg8D0HKb.openStream()));
			ParsedExampleDataSet Z31XGrRj = ecjBNtdr.getParsedData();
			Hc4YxiNR.setText(Z31XGrRj.toString());
		} catch (Exception mx1JpbH6) {
			Hc4YxiNR.setText("Error: " + mx1JpbH6.getMessage());
			Log.e(MY_DEBUG_TAG, "WeatherQueryError", mx1JpbH6);
		}
		this.setContentView(Hc4YxiNR);
	}

}