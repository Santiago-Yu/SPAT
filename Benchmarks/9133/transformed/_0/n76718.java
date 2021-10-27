class n76718 {
	private void refresh(String EA0dVks4) {
		HttpHost Kn5jY6iu = new HttpHost("localhost", 8080, "http");
		DefaultHttpClient IUSyns89 = new DefaultHttpClient();
		BasicHttpContext sHuJ1tE4 = new BasicHttpContext();
		String xxPnOpzq = EA0dVks4.trim().replaceAll("\\s+", "+");
		HttpGet YS24F9MJ = new HttpGet("/geoserver/rest/gazetteer-search/result.json?q=" + xxPnOpzq);
		try {
			HttpResponse QUwy8fu8 = IUSyns89.execute(Kn5jY6iu, YS24F9MJ, sHuJ1tE4);
			HttpEntity EvQ3BZ1E = QUwy8fu8.getEntity();
			String xzYxJbuM = "";
			if (EvQ3BZ1E != null) {
				xzYxJbuM = new String(EntityUtils.toByteArray(EvQ3BZ1E));
			} else {
				xzYxJbuM = "Fail";
			}
			JSONObject TIkKtu6a = JSONObject.fromObject(xzYxJbuM);
			JSONObject Jliry9iv = TIkKtu6a.getJSONObject("org.ala.rest.GazetteerSearch");
			JSONArray YhPqdqdP = Jliry9iv.getJSONObject("results").getJSONArray("org.ala.rest.SearchResultItem");
			Iterator RYxH0Mdx = getItems().iterator();
			for (int b0SSodWc = 0; b0SSodWc < YhPqdqdP.size(); b0SSodWc++) {
				String BBk7Ek3O = (String) YhPqdqdP.getJSONObject(b0SSodWc).get("name");
				if (RYxH0Mdx != null && RYxH0Mdx.hasNext()) {
					((Comboitem) RYxH0Mdx.next()).setLabel(BBk7Ek3O);
				} else {
					RYxH0Mdx = null;
					new Comboitem(BBk7Ek3O).setParent(this);
				}
			}
			while (RYxH0Mdx != null && RYxH0Mdx.hasNext()) {
				RYxH0Mdx.next();
				RYxH0Mdx.remove();
			}
		} catch (Exception cWzCCHk8) {
		}
	}

}