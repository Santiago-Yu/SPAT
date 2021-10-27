    private MediaWikiResult getFromUri(String url) throws OntologyServiceException {
        try {
            logger.info("getting " + url);
            HttpURLConnection connection = (java.net.HttpURLConnection) new URL(url).openConnection();
            connection.setRequestProperty("User-Agent", "OntoCat-" + Math.random());
            BufferedInputStream bin = new BufferedInputStream(connection.getInputStream());
            JAXBContext jaxbContext = JAXBContext.newInstance("uk.ac.ebi.ontocat.mediawiki.jaxb");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (MediaWikiResult) unmarshaller.unmarshal(bin);
        } catch (Exception e) {
            e.printStackTrace();
            throw new OntologyServiceException(e);
        }
    }
