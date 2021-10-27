class n1035597 {
	private Concept fetchDataNeeded(String vSMopgnp) {
		if (cache.size() > MAX_CACHE)
			cache.clear();
		if (cache.containsKey(vSMopgnp))
			return this.cache.get(vSMopgnp);
		try {
			URL pvK6fL58 = new URL(vSMopgnp);
			HttpURLConnection dtdQXd7X = (HttpURLConnection) pvK6fL58.openConnection();
			dtdQXd7X.setInstanceFollowRedirects(true);
			dtdQXd7X.setRequestProperty("Accept", "application/rdf+xml");
			if (dtdQXd7X.getResponseCode() == HttpURLConnection.HTTP_OK
					&& dtdQXd7X.getContentType().contains("application/rdf+xml")) {
				InputStream aOrGQbbw = dtdQXd7X.getInputStream();
				HashMap<String, String> EgNaMeZz = new HashMap<String, String>();
				EgNaMeZz.put("uri", vSMopgnp);
				Transformer MGxuyTg7 = this.templates.getDAOTransformer(keyTemplates, EgNaMeZz);
				DOMResult BkhlHgrL = new DOMResult();
				MGxuyTg7.transform(new StreamSource(aOrGQbbw), BkhlHgrL);
				Concept UiLqhkdl = ConceptXMLBind.getInstance().restoreConcept(BkhlHgrL.getNode());
				this.cache.put(vSMopgnp, UiLqhkdl);
				return UiLqhkdl;
			} else {
				logger.error("Unable to get a representation of the resource: " + dtdQXd7X.getResponseCode() + " => "
						+ dtdQXd7X.getContentType());
				throw new RuntimeException("Unable to get a representation of the resource");
			}
		} catch (Exception vzVMeyoH) {
			logger.error("Unable to fetch data for concept " + vSMopgnp, vzVMeyoH);
			throw new RuntimeException(vzVMeyoH);
		}
	}

}