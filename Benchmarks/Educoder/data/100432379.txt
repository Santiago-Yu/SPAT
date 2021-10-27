    public static String retrieveData(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-agent", "MZmine 2");
        InputStream is = connection.getInputStream();
        if (is == null) {
            throw new IOException("Could not establish a connection to " + url);
        }
        StringBuffer buffer = new StringBuffer();
        try {
            InputStreamReader reader = new InputStreamReader(is, "UTF-8");
            char[] cb = new char[1024];
            int amtRead = reader.read(cb);
            while (amtRead > 0) {
                buffer.append(cb, 0, amtRead);
                amtRead = reader.read(cb);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        is.close();
        return buffer.toString();
    }
