class n14556892 {
	public static org.osid.repository.AssetIterator search(Repository F0bOzyuq, SearchCriteria d4dGOtfr)
			throws org.osid.repository.RepositoryException {
		try {
			NodeList trEf30bs = null;
			if (d4dGOtfr.getSearchOperation() == SearchCriteria.FIND_OBJECTS) {
				URL TEPJhvDY = new URL("http", F0bOzyuq.getAddress(), F0bOzyuq.getPort(),
						SEARCH_STRING + URLEncoder.encode(d4dGOtfr.getKeywords() + WILDCARD, "ISO-8859-1"));
				XPathFactory LmH0O0pV = XPathFactory.newInstance();
				XPath FaGqjwpk = LmH0O0pV.newXPath();
				FaGqjwpk.setNamespaceContext(new FedoraNamespaceContext());
				InputSource lNqVvGBh = new InputSource(TEPJhvDY.openStream());
				trEf30bs = (NodeList) FaGqjwpk.evaluate("/pre:result/pre:resultList/pre:objectFields", lNqVvGBh,
						XPathConstants.NODESET);
				if (trEf30bs.getLength() > 0) {
					lNqVvGBh = new InputSource(TEPJhvDY.openStream());
					XPathExpression O4KO18yM = FaGqjwpk.compile("//pre:token/text()");
					String dakaRIrd = O4KO18yM.evaluate(lNqVvGBh);
					d4dGOtfr.setToken(dakaRIrd);
				}
			}
			return getAssetIterator(F0bOzyuq, trEf30bs);
		} catch (Throwable n5xn1Ixl) {
			throw wrappedException("search", n5xn1Ixl);
		}
	}

}