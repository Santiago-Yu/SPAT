class n22975594{
    public String getInternetData() throws Exception {
        BufferedReader in = null;
        String data = null;
        try {
            HttpClient client = new DefaultHttpClient();
            URI website = new URI("http://code.google.com/p/gadi-works");
            HttpGet request = new HttpGet();
            request.setURI(website);
            HttpResponse response = client.execute(request);
            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String l = "";
            String nl = System.getProperty("line.separator");
            while ((l = in.readLine()) != null) {
                sb.append(l + nl);
            }
            in.close();
            data = sb.toString();
            return data;
        } finally {
            if (in != null) {
                try {
                    in.close();
                    return data;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}