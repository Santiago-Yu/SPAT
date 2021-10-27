class n19707472 {
	private void loadRDFURL(URL j6Zdqs9m) throws RDFParseException, RepositoryException {
		URI EOVh6yiC = valueFactory.createURI(j6Zdqs9m.toString());
		try {
			URLConnection YL33q8ei = j6Zdqs9m.openConnection();
			YL33q8ei.setRequestProperty("Accept", "application/rdf+xml");
			InputStream V7NRSlcI = YL33q8ei.getInputStream();
			repoConn.add(V7NRSlcI, j6Zdqs9m.toString(), RDFFormat.RDFXML, EOVh6yiC);
			V7NRSlcI.close();
			repoConn.commit();
		} catch (IOException V05Ozfcd) {
			V05Ozfcd.printStackTrace();
		}
	}

}