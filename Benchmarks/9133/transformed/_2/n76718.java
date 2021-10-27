class n76718 {
	private void refresh(String val) {
		HttpHost targetHost = new HttpHost("localhost", 8080, "http");
		DefaultHttpClient httpclient = new DefaultHttpClient();
		BasicHttpContext localcontext = new BasicHttpContext();
		String searchString = val.trim().replaceAll("\\s+", "+");
		HttpGet httpget = new HttpGet("/geoserver/rest/gazetteer-search/result.json?q=" + searchString);
		try {
			HttpResponse response = httpclient.execute(targetHost, httpget, localcontext);
			HttpEntity entity = response.getEntity();
			String responseText = "";
			if (entity != null) {
				responseText = new String(EntityUtils.toByteArray(entity));
			} else {
				responseText = "Fail";
			}
			JSONObject responseJson = JSONObject.fromObject(responseText);
			JSONObject search = responseJson.getJSONObject("org.ala.rest.GazetteerSearch");
			JSONArray results = search.getJSONObject("results").getJSONArray("org.ala.rest.SearchResultItem");
			Iterator it = getItems().iterator();
			for (int i = 0; i < results.size(); i++) {
				String itemString = (String) results.getJSONObject(i).get("name");
				if (it != null && it.hasNext()) {
					((Comboitem) it.next()).setLabel(itemString);
				} else {
					it = null;
					new Comboitem(itemString).setParent(this);
				}
			}
			for (; it != null && it.hasNext();) {
				it.next();
				it.remove();
			}
		} catch (Exception e) {
		}
	}

}