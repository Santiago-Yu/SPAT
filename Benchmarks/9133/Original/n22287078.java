class n22287078{
    @Override
    List<String> HttpGet(URL url) throws IOException {
        List<String> responseList = new ArrayList<String>();
        Logger.getInstance().logInfo("HTTP GET: " + url, null, getGatewayId());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setConnectTimeout(20000);
        con.setAllowUserInteraction(false);
        responseList.add(con.getResponseCode() + " " + con.getResponseMessage());
        InputStream inputStream = con.getErrorStream();
        if (inputStream == null) inputStream = con.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        String inputLine;
        while ((inputLine = in.readLine()) != null) responseList.add(inputLine);
        in.close();
        return responseList;
    }

}