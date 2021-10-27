class n22430601{
    public Service findServiceFor(final int serviceID) throws JAXBException, IOException, BadResponseException {
        final String USER_AGENT = "SBSIVisual (CSBE, University of Edinburgh)";
        String urlToConnectTo = "http://www.biocatalogue.org/services/" + serviceID;
        URL url = new URL(urlToConnectTo);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("User-Agent", USER_AGENT);
        conn.setRequestProperty("Accept", "application/xml");
        int iResponseCode = conn.getResponseCode();
        InputStream serverResponse = null;
        switch(iResponseCode) {
            case HttpURLConnection.HTTP_OK:
                serverResponse = conn.getInputStream();
                break;
            case HttpURLConnection.HTTP_BAD_REQUEST:
                throw new BadResponseException("Received BadResponse from server:" + HttpURLConnection.HTTP_BAD_REQUEST);
        }
        Service service = new ResponseParser<Service>().getObjectFor(serverResponse, Service.class);
        return service;
    }

}