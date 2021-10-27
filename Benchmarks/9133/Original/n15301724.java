class n15301724{
    InputStream openURL(URL url) throws IOException, WrongMIMETypeException {
        InputStream is = null;
        if (url.getProtocol().equals("file")) {
            if (debug) {
                System.out.println("Using direct input stream on file url");
            }
            URLConnection urlc = url.openConnection();
            try {
                urlc.connect();
                is = new DataInputStream(urlc.getInputStream());
            } catch (FileNotFoundException e) {
            }
        } else {
            double start = 0;
            if (timing) {
                start = Time.getNow();
            }
            ContentNegotiator cn = null;
            cn = new ContentNegotiator(url);
            Object obj = null;
            obj = cn.getContent();
            if (obj != null) {
                byte[] buf = (byte[]) obj;
                is = new ByteArrayInputStream(buf);
            } else {
                System.err.println("Loader.openURL got null content");
                throw new IOException("Loader.openURL got null content");
            }
            if (timing) {
                double elapsed = Time.getNow() - start;
                System.out.println("Loader: open and buffer URL in: " + numFormat.format(elapsed, 2) + " seconds");
            }
        }
        return is;
    }

}