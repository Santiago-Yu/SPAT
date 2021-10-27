class n6908734{
    public <E extends Exception> void doWithConnection(String httpAddress, ICallableWithParameter<Void, URLConnection, E> toDo) throws E, ConnectionException {
        URLConnection connection;
        try {
            URL url = new URL(httpAddress);
            connection = url.openConnection();
        } catch (MalformedURLException e) {
            throw new ConnectionException("Connecting to " + httpAddress + " got", e);
        } catch (IOException e) {
            throw new ConnectionException("Connecting to " + httpAddress + " got", e);
        }
        authenticationHandler.doWithProxyAuthentication(connection, toDo);
    }

}