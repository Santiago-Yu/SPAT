class n19915605{
    public static String Execute(HttpRequestBase httprequest) throws IOException, ClientProtocolException {
        httprequest.setHeader("Accept", "application/json");
        httprequest.setHeader("Content-type", "application/json");
        String result = "";
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = httpclient.execute(httprequest);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            result += line + "\n";
        }
        return result;
    }

}