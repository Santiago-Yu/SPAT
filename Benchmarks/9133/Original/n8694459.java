class n8694459{
    public OutputStream getOutputStream() throws IOException {
        try {
            URL url = getURL();
            URLConnection urlc = url.openConnection();
            return urlc.getOutputStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}