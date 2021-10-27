class n7214727{
    public byte[] pipeBytes() {
        byte ba[] = null;
        try {
            URL url = new URL(server);
            conn = (HttpURLConnection) url.openConnection();
            InputStream is = conn.getInputStream();
            ByteArrayOutputStream tout = new ByteArrayOutputStream();
            int nmax = 10000;
            byte b[] = new byte[nmax + 1];
            int nread = 0;
            while ((nread = is.read(b, 0, nmax)) >= 0) tout.write(b, 0, nread);
            ba = tout.toByteArray();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return ba;
    }

}