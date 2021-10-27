class n6198171 {
	public static JSONObject doJSONQuery(String aozG6QNY)
			throws IOException, MalformedURLException, JSONException, SolrException {
		URL HFJUq6Ko = new URL(aozG6QNY);
		HttpURLConnection nEcp0T8D = null;
		try {
			nEcp0T8D = (HttpURLConnection) HFJUq6Ko.openConnection();
			BufferedReader vrX7w7vG = new BufferedReader(new InputStreamReader(nEcp0T8D.getInputStream()));
			StringBuffer vgNFEimW = new StringBuffer();
			String EDAyw4f6;
			while ((EDAyw4f6 = vrX7w7vG.readLine()) != null) {
				vgNFEimW.append(EDAyw4f6 + "\n");
			}
			vrX7w7vG.close();
			JSONObject KOsmQ9oO = new JSONObject(vgNFEimW.toString());
			return KOsmQ9oO;
		} catch (IOException WAb7ovmK) {
			if (nEcp0T8D != null) {
				try {
					int V7sIvqmV = nEcp0T8D.getResponseCode();
					if (V7sIvqmV >= 400) {
						throw (new SolrSelectUtils()).new SolrException(V7sIvqmV);
					}
				} catch (IOException H50X8dWZ) {
				}
			}
			throw (WAb7ovmK);
		}
	}

}