class n20469230{
    public static final void main(String[] args) throws Exception {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://www.apache.org/");
        System.out.println("executing request " + httpget.getURI());
        HttpResponse response = httpclient.execute(httpget);
        System.out.println("----------------------------------------");
        System.out.println(response.getStatusLine());
        System.out.println("----------------------------------------");
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            try {
                System.out.println(reader.readLine());
            } catch (IOException ex) {
                throw ex;
            } catch (RuntimeException ex) {
                httpget.abort();
                throw ex;
            } finally {
                reader.close();
            }
        }
    }

}