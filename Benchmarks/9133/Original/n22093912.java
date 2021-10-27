class n22093912{
    private byte[] getResponseFromHttp(byte[] ocspPackage, URL url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        try {
            con.setRequestMethod(OCSPLoginModule.POST);
        } catch (ProtocolException e) {
            throw new IOException(e.getMessage(), e);
        }
        con.setRequestProperty(OCSPLoginModule.CONTENT_TYPE, OCSPLoginModule.APPLICATION_OCSP_REQUEST);
        OutputStream os = null;
        try {
            os = con.getOutputStream();
            os.write(ocspPackage);
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw e;
        } finally {
            os.close();
        }
        InputStream in = null;
        byte[] respBytes = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            in = con.getInputStream();
            int b = in.read();
            while (b != -1) {
                baos.write(b);
                b = in.read();
            }
            baos.flush();
        } finally {
            in.close();
            con.disconnect();
        }
        respBytes = baos.toByteArray();
        return respBytes;
    }

}