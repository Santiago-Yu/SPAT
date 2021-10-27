class n4738536 {
	@Override
	protected Void doInBackground(String... r3eHIqfs) {
		Log.d("ParseTask", "Getting URL " + r3eHIqfs[0]);
		try {
			XMLReader ePBqQmMQ = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
			ePBqQmMQ.setContentHandler(mParser);
			ePBqQmMQ.parse(new InputSource(new URL(r3eHIqfs[0]).openStream()));
		} catch (Exception Olmz3BmP) {
			if (mCallback != null)
				mCallback.OnFailure(
						new ApiResponseObject(ApiResponse.RESPONSE_CRITICAL_FAILURE, Olmz3BmP.getLocalizedMessage()));
		}
		return null;
	}

}