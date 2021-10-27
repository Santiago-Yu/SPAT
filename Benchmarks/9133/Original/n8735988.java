class n8735988{
    public synchronized void readProject(URL url, boolean addMembers) throws IOException {
        _url = url;
        try {
            readProject(url.openStream(), addMembers);
        } catch (IOException e) {
            Argo.log.info("Couldn't open InputStream in ArgoParser.load(" + url + ") " + e);
            e.printStackTrace();
            lastLoadMessage = e.toString();
            throw e;
        }
    }

}