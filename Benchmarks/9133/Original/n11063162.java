class n11063162{
    public int getResponseCode(URI uri) {
        int response = -1;
        try {
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            response = connection.getResponseCode();
        } catch (MalformedURLException m) {
            throw new MalformedURLException("URL not correct");
        } catch (IOException e) {
            throw new IOException("can open connection");
        } finally {
            return response;
        }
    }

}