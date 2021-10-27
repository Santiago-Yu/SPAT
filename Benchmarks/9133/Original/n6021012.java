class n6021012{
    public static void parseEdges(URL url, Graph g, Dictionary airportToVertex) throws FileNotFoundException, FlightException {
        InputStream is = null;
        try {
            is = url.openStream();
        } catch (IOException e) {
            throw new FlightException("IO Error: cannot read from URL " + url.toString());
        }
        Reader reader = new BufferedReader(new InputStreamReader(is));
        Parser.parseEdges(reader, g, airportToVertex);
    }

}