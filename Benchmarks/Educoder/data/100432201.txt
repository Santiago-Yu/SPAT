    public static void insertDocumentToURL(String file, String target) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(file);
            final URL url = new URL(target);
            final URLConnection connection = url.openConnection();
            os = connection.getOutputStream();
            TestTools.copyStream(is, os);
        } finally {
            if (is != null) {
                is.close();
            }
            if (os != null) {
                os.close();
            }
        }
    }
