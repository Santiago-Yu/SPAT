class n8711848{
    public boolean urlToSpeech(String urlPath) {
        boolean ok = false;
        try {
            URL url = new URL(urlPath);
            InputStream is = url.openStream();
            ok = streamToSpeech(is);
        } catch (IOException ioe) {
            System.err.println("Can't read data from " + urlPath);
        }
        return ok;
    }

}