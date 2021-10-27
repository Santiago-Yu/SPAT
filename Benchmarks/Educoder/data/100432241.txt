    public static long getFileSize(String address) {
        URL url = null;
        try {
            url = new URL(address);
            System.err.println("Indirizzo valido - " + url.toString().substring(0, 10) + "...");
        } catch (MalformedURLException ex) {
            System.err.println("Indirizzo non valido!");
        }
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Range", "bytes=0-");
            connection.connect();
            return connection.getContentLength();
        } catch (IOException ioe) {
            System.err.println("I/O error!");
            return 0;
        }
    }
