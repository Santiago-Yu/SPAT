class n7823490{
    protected String getRequestContent(String urlText) throws Exception {
        URL url = new URL(urlText);
        HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
        String line = null;
        try {
            urlcon.setUseCaches(false);
            urlcon.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
            line = reader.readLine();
            reader.close();
        } finally {
            urlcon.disconnect();
        }
        return line;
    }

}