class n4507906{
    private void sendToURL(String URL, String file) throws Exception {
        URL url = new URL(URL);
        InputStream is = new BufferedInputStream(new FileInputStream(file));
        OutputStream os = url.openConnection().getOutputStream();
        copyDocument(is, os);
        is.close();
        os.close();
    }

}