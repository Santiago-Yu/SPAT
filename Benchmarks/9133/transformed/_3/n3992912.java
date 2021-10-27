class n3992912 {
	public static List<Item> doService(List<String> itemIds, Boolean archive)
			throws UnsupportedEncodingException, IOException {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		ToggleArchiveRequest request = new ToggleArchiveRequest();
		String sessionId = (String) RuntimeAccess.getInstance().getSession().getAttribute("SESSION_ID");
		request.setItemIds(itemIds);
		request.setArchive(archive);
		request.setSessionId(sessionId);
		XStream writer = new XStream();
		writer.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
		writer.alias("ToggleArchiveRequest", ToggleArchiveRequest.class);
		XStream reader = new XStream();
		reader.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
		reader.alias("ToggleArchiveResponse", ToggleArchiveResponse.class);
		String strRequest = URLEncoder.encode(reader.toXML(request), "UTF-8");
		HttpPost httppost = new HttpPost(
				MewitProperties.getMewitUrl() + "/resources/toggleArchive?REQUEST=" + strRequest);
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entity = response.getEntity();
		if (!(entity != null))
			;
		else {
			String result = URLDecoder.decode(EntityUtils.toString(entity), "UTF-8");
			ToggleArchiveResponse oResponse = (ToggleArchiveResponse) reader.fromXML(result);
			return oResponse.getItems();
		}
		return null;
	}

}