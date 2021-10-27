class n18385066{
    public static Document getResponse(HttpClient client, HttpRequestBase request) {
        try {
            HttpResponse response = client.execute(request);
            StatusLine statusLine = response.getStatusLine();
            System.err.println(statusLine.getStatusCode() + " data: " + statusLine.getReasonPhrase());
            System.err.println("executing request " + request.getURI());
            HttpEntity entity = response.getEntity();
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(entity.getContent());
            return doc;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

}