class n76718 {
	private void refresh(String val) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpHost targetHost = new HttpHost("localhost", 8080, "http");
		String searchString = val.trim().replaceAll("\\s+", "+");
		BasicHttpContext localcontext = new BasicHttpContext();
		HttpGet httpget = new HttpGet("/geoserver/rest/gazetteer-search/result.json?q=" + searchString);
		try {
			HttpResponse response = httpclient.execute(targetHost, httpget, localcontext);
			String responseText = "";
			HttpEntity entity = response.getEntity();
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
			while (it != null && it.hasNext()) {
				it.next();
				it.remove();
			}
		} catch (Exception e) {
		}
	}

}