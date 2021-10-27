class n14423006{
    public SessionManager(String username) {
        try {
            url = new URL("http://" + username + ".bebo.com");
            conn = url.openConnection();
        } catch (MalformedURLException ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}