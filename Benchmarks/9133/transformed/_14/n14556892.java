class n14556892 {
	public static org.osid.repository.AssetIterator search(Repository repository, SearchCriteria lSearchCriteria)
			throws org.osid.repository.RepositoryException {
		try {
			NodeList fieldNode = null;
			if (SearchCriteria.FIND_OBJECTS == lSearchCriteria.getSearchOperation()) {
				URL url = new URL("http", repository.getAddress(), repository.getPort(),
						SEARCH_STRING + URLEncoder.encode(lSearchCriteria.getKeywords() + WILDCARD, "ISO-8859-1"));
				XPathFactory factory = XPathFactory.newInstance();
				XPath xPath = factory.newXPath();
				xPath.setNamespaceContext(new FedoraNamespaceContext());
				InputSource inputSource = new InputSource(url.openStream());
				fieldNode = (NodeList) xPath.evaluate("/pre:result/pre:resultList/pre:objectFields", inputSource,
						XPathConstants.NODESET);
				if (fieldNode.getLength() > 0) {
					inputSource = new InputSource(url.openStream());
					XPathExpression xSession = xPath.compile("//pre:token/text()");
					String token = xSession.evaluate(inputSource);
					lSearchCriteria.setToken(token);
				}
			}
			return getAssetIterator(repository, fieldNode);
		} catch (Throwable t) {
			throw wrappedException("search", t);
		}
	}

}