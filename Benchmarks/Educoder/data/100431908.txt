    private static InputStream getCMSResultAsStream(String rqlQuery) throws RQLException {
        OutputStreamWriter osr = null;
        try {
            URL url = new URL("http", HOST, FILE);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            osr = new OutputStreamWriter(conn.getOutputStream());
            osr.write(rqlQuery);
            osr.flush();
            return conn.getInputStream();
        } catch (IOException ioe) {
            throw new RQLException("IO Exception reading result from server", ioe);
        } finally {
            if (osr != null) {
                try {
                    osr.close();
                } catch (IOException ioe) {
                }
            }
        }
    }
