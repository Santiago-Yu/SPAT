class n6989198{
    public static boolean isInternetReachable() {
        try {
            URL url = new URL("http://code.google.com/p/ilias-userimport/downloads/list");
            HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
            Object objData = urlConnect.getContent();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}