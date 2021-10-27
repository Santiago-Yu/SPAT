class n5636184{
    public static Element postMessage() throws Exception {
        final URL theUrl = getHostURL();
        lf.debug("url = " + theUrl.toExternalForm());
        final HttpURLConnection urlConn = (HttpURLConnection) (theUrl).openConnection();
        urlConn.setRequestMethod("POST");
        urlConn.setDoInput(true);
        urlConn.setDoOutput(true);
        final BufferedOutputStream bos = new BufferedOutputStream(urlConn.getOutputStream());
        final InputStream bis = urlConn.getInputStream();
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = bis.read(buffer)) > -1) {
            baos.write(buffer, 0, count);
        }
        final SAXBuilder sb = new SAXBuilder();
        lf.debug("Received XML response from server: " + baos.toString());
        return sb.build(new StringReader(baos.toString())).getRootElement();
    }

}