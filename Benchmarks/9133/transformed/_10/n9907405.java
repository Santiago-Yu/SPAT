class n9907405 {
	@Override
	public void onCreate(Bundle icicle) {
		TextView tv = new TextView(this);
		super.onCreate(icicle);
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			URL url = new URL("");
			SAXParser sp = spf.newSAXParser();
			ExampleHandler myExampleHandler = new ExampleHandler();
			XMLReader xr = sp.getXMLReader();
			xr.setContentHandler(myExampleHandler);
			xr.parse(new InputSource(url.openStream()));
			ParsedExampleDataSet parsedExampleDataSet = myExampleHandler.getParsedData();
			tv.setText(parsedExampleDataSet.toString());
		} catch (Exception e) {
			tv.setText("Error: " + e.getMessage());
			Log.e(MY_DEBUG_TAG, "WeatherQueryError", e);
		}
		this.setContentView(tv);
	}

}