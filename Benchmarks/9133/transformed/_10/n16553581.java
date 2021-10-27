class n16553581 {
	public Item findById(String itemId) throws UnsupportedEncodingException, IOException {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String sessionId = (String) RuntimeAccess.getInstance().getSession().getAttribute("SESSION_ID");
		FindItemByIdRequest request = new FindItemByIdRequest();
		request.setItemID(itemId);
		request.setSessionId(sessionId);
		XStream writer = new XStream();
		writer.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
		writer.alias("FindItemByIdRequest", FindItemByIdRequest.class);
		XStream reader = new XStream();
		reader.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
		reader.alias("FindItemByIdResponse", FindItemByIdResponse.class);
		String strRequest = URLEncoder.encode(reader.toXML(request), "UTF-8");
		HttpGet httpget = new HttpGet(MewitProperties.getMewitUrl() + "/resources/findItemById?REQUEST=" + strRequest);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			String result = URLDecoder.decode(EntityUtils.toString(entity), "UTF-8");
			FindItemByIdResponse fibiResponse = (FindItemByIdResponse) reader.fromXML(result);
			return fibiResponse.getItem();
		}
		return null;
	}

}