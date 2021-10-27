class n22986029{
    private boolean doDelete(String identifier) throws IOException, MalformedURLException {
        URL url = new URL(baseurl.toString() + "/" + identifier);
        HttpURLConnection huc = (HttpURLConnection) (url.openConnection());
        huc.setRequestMethod("DELETE");
        huc.connect();
        if (huc.getResponseCode() == 200) {
            return true;
        } else return false;
    }

}