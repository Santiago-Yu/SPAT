class n14456152{
    List HttpGet(URL url) throws IOException {
        List responseList = new ArrayList();
        logInfo("HTTP GET: " + url);
        URLConnection con = url.openConnection();
        con.setAllowUserInteraction(false);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) responseList.add(inputLine);
        in.close();
        return responseList;
    }

}