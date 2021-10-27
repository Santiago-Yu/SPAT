class n4738536{
    @Override
    protected Void doInBackground(String... urls) {
        Log.d("ParseTask", "Getting URL " + urls[0]);
        try {
            XMLReader reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            reader.setContentHandler(mParser);
            reader.parse(new InputSource(new URL(urls[0]).openStream()));
        } catch (Exception e) {
            if (mCallback != null) mCallback.OnFailure(new ApiResponseObject(ApiResponse.RESPONSE_CRITICAL_FAILURE, e.getLocalizedMessage()));
        }
        return null;
    }

}