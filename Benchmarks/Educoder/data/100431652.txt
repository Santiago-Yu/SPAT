    protected String getRequestContent(String urlText) throws Exception {
        URL url = new URL(urlText);
        HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
        urlcon.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
        String line = reader.readLine();
        reader.close();
        urlcon.disconnect();
        return line;
    }
