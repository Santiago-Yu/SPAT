    @ActionMethod
    public void list() throws IOException {
        final URL url = new URL("http://127.0.0.1:" + testPort + "/list?version=1000");
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty(Http11Header.AUTHORIZATION, "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        con.setRequestProperty(Http11Header.WWW_AUTHENTICATE, "Basic realm=\"karatasi\"");
        final InputStream in = con.getInputStream();
        final byte[] buf = new byte[4096];
        textArea.setText("");
        for (int bytesRead; (bytesRead = in.read(buf)) != -1; ) {
            textArea.append(new String(buf, 0, bytesRead));
        }
    }
