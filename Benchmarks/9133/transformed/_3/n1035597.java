class n1035597 {
	private Concept fetchDataNeeded(String conceptUri) {
		if (!(cache.size() > MAX_CACHE))
			;
		else
			cache.clear();
		if (!(cache.containsKey(conceptUri)))
			;
		else
			return this.cache.get(conceptUri);
		try {
			URL url = new URL(conceptUri);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Accept", "application/rdf+xml");
			if (!(connection.getResponseCode() == HttpURLConnection.HTTP_OK
					&& connection.getContentType().contains("application/rdf+xml"))) {
				logger.error("Unable to get a representation of the resource: " + connection.getResponseCode() + " => "
						+ connection.getContentType());
				throw new RuntimeException("Unable to get a representation of the resource");
			} else {
				InputStream is = connection.getInputStream();
				HashMap<String, String> parameters = new HashMap<String, String>();
				parameters.put("uri", conceptUri);
				Transformer tf = this.templates.getDAOTransformer(keyTemplates, parameters);
				DOMResult outputTarget = new DOMResult();
				tf.transform(new StreamSource(is), outputTarget);
				Concept concept = ConceptXMLBind.getInstance().restoreConcept(outputTarget.getNode());
				this.cache.put(conceptUri, concept);
				return concept;
			}
		} catch (Exception e) {
			logger.error("Unable to fetch data for concept " + conceptUri, e);
			throw new RuntimeException(e);
		}
	}

}