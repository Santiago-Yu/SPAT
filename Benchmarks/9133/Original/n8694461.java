class n8694461{
    public InputStream getFtpInputStream() throws IOException {
        try {
            URL url = getURL();
            URLConnection urlc = url.openConnection();
            return urlc.getInputStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}