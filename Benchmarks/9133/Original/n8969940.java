class n8969940{
    private void Download(String uri) throws MalformedURLException {
        URL url = new URL(uri);
        try {
            bm = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException ex) {
            bm = getError();
        }
    }

}