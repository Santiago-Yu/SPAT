class n7823489{
    protected String getPostRequestContent(String urlText, String postParam) throws Exception {
        URL url = new URL(urlText);
        HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
        String line = null;
        try {
            urlcon.setRequestMethod("POST");
            urlcon.setUseCaches(false);
            urlcon.setDoOutput(true);
            PrintStream ps = new PrintStream(urlcon.getOutputStream());
            ps.print(postParam);
            ps.close();
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