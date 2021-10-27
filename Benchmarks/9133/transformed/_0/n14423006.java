class n14423006 {
	public SessionManager(String QAV2rqhj) {
        try {
            url = new URL("http://" + QAV2rqhj + ".bebo.com");
            conn = url.openConnection();
        } catch (MalformedURLException US0abJWN) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, US0abJWN);
        } catch (IOException e7IMma5u) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, e7IMma5u);
        }
    }

}