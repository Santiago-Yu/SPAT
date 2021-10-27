class n14752945{
    protected String getPostRequestContent(String urlText, String... postParams) throws Exception {
        URL url = new URL(urlText);
        HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
        urlcon.setRequestMethod("POST");
        urlcon.setUseCaches(false);
        urlcon.setDoOutput(true);
        PrintStream ps = new PrintStream(urlcon.getOutputStream());
        for (String param : postParams) {
            ps.print(param);
        }
        ps.close();
        urlcon.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
        String line = reader.readLine();
        reader.close();
        urlcon.disconnect();
        return line;
    }

}