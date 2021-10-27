class n10405919{
    private Document getResponse(HttpGet request) throws ClientProtocolException, IOException, ParserConfigurationException, IllegalStateException, SAXException, NoRoutesException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(request);
        if (response.getStatusLine().getStatusCode() != HTTP_STATUS_OK) throw new ClientProtocolException("The HTTP request is wrong.");
        allResponse = EntityUtils.toString(response.getEntity());
        String responseText = "";
        switch(modeOption) {
            case DRIVING:
                try {
                    responseText = allResponse.substring(allResponse.indexOf("<ol"), allResponse.indexOf("</ol>") + 5);
                } catch (Exception e) {
                    throw new NoRoutesException();
                }
                break;
            case WALKING:
                try {
                    responseText = allResponse.substring(allResponse.indexOf("<ol"), allResponse.indexOf("</ol>") + 5);
                } catch (Exception e) {
                    throw new NoRoutesException();
                }
                break;
            case PUBLIC_TRANSIT:
                String responseWithErrors = "";
                try {
                    responseWithErrors = allResponse.substring(allResponse.indexOf("<div id=\"tsp\">"), allResponse.indexOf("<div class=\"ddwpt\" id=\"panel_ddw1\" oi=\"wi1\">"));
                } catch (Exception e) {
                    throw new NoRoutesException();
                }
                responseText = responseWithErrors.replaceAll(".gif\">", ".gif\"/>").replaceAll("colspan=2", "colspan=\"2\"").replaceAll("nowrap", "").replaceAll("&laquo;", "").replaceAll("&nbsp;", "").replaceAll("&raquo;", "");
                break;
        }
        File xmlFile = new File("./data/temp/response.xml");
        PrintWriter writer = new PrintWriter(xmlFile);
        writer.println(responseText);
        writer.close();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        return dBuilder.parse(xmlFile);
    }

}