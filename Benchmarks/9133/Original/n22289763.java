class n22289763{
    InputStream openReader(String s) {
        System.err.println("Fetcher: trying url " + s);
        try {
            URL url = new URL(s);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            return url.openStream();
        } catch (IOException e) {
        }
        return null;
    }

}