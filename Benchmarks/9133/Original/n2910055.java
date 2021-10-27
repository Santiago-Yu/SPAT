class n2910055{
    private Store openConnection(String url) throws MessagingException {
        URLName urlName = new URLName(url);
        log.debug("opening " + urlName.getProtocol() + " conection to " + urlName.getHost());
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props);
        Store store = session.getStore(urlName);
        store.connect();
        return store;
    }

}