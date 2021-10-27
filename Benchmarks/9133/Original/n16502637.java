class n16502637{
    public InputStream getResourceAsStream(String name) {
        try {
            URL url = getResource(name);
            System.out.println("Loading \"" + url + "\"...");
            URLConnection urlConnection = url.openConnection();
            if (urlConnection instanceof HttpURLConnection) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                httpURLConnection.setFollowRedirects(true);
                httpURLConnection.setRequestMethod("GET");
                int responseCode = httpURLConnection.getResponseCode();
                System.out.println(httpURLConnection.getResponseMessage() + ", " + httpURLConnection.getContentLength() + " bytes" + ", " + new Date(httpURLConnection.getDate()) + ", " + new Date(httpURLConnection.getLastModified()));
                if (responseCode != HttpURLConnection.HTTP_OK) {
                    return null;
                }
            }
            return urlConnection.getInputStream();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}