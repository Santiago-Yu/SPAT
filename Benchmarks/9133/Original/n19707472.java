class n19707472{
    private void loadRDFURL(URL url) throws RDFParseException, RepositoryException {
        URI urlContext = valueFactory.createURI(url.toString());
        try {
            URLConnection urlConn = url.openConnection();
            urlConn.setRequestProperty("Accept", "application/rdf+xml");
            InputStream is = urlConn.getInputStream();
            repoConn.add(is, url.toString(), RDFFormat.RDFXML, urlContext);
            is.close();
            repoConn.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}