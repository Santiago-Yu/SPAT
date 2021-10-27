class n1035597 {
	private Concept fetchDataNeeded(String conceptUri) {
		if (cache.size() > MAX_CACHE)
			cache.clear();
		if (cache.containsKey(conceptUri))
			return this.cache.get(conceptUri);
		try {
			URL url = new URL(conceptUri);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Accept", "application/rdf+xml");
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK
					&& connection.getContentType().contains("application/rdf+xml")) {
				HashMap<String, String> parameters = new HashMap<String, String>();
				InputStream is = connection.getInputStream();
				parameters.put("uri", conceptUri);
				DOMResult outputTarget = new DOMResult();
				Transformer tf = this.templates.getDAOTransformer(keyTemplates, parameters);
				tf.transform(new StreamSource(is), outputTarget);
				Concept concept = ConceptXMLBind.getInstance().restoreConcept(outputTarget.getNode());
				this.cache.put(conceptUri, concept);
				return concept;
			} else {
				logger.error("Unable to get a representation of the resource: " + connection.getResponseCode() + " => "
						+ connection.getContentType());
				throw new RuntimeException("Unable to get a representation of the resource");
			}
		} catch (Exception e) {
			logger.error("Unable to fetch data for concept " + conceptUri, e);
			throw new RuntimeException(e);
		}
	}

}