class n9907405{
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        TextView tv = new TextView(this);
        try {
            URL url = new URL("");
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            XMLReader xr = sp.getXMLReader();
            ExampleHandler myExampleHandler = new ExampleHandler();
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