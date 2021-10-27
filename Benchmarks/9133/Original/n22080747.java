class n22080747{
    @Test
    public void testCustomerResource() throws Exception {
        DefaultHttpClient client = new DefaultHttpClient();
        System.out.println("**** CustomerResource No Query params ***");
        HttpGet get = new HttpGet("http://localhost:9095/customers");
        HttpResponse response = client.execute(get);
        Assert.assertEquals(200, response.getStatusLine().getStatusCode());
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
        System.out.println("**** CustomerResource With Query params ***");
        get = new HttpGet("http://localhost:9095/customers?start=1&size=3");
        response = client.execute(get);
        Assert.assertEquals(200, response.getStatusLine().getStatusCode());
        reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
        System.out.println("**** CustomerResource With UriInfo and Query params ***");
        get = new HttpGet("http://localhost:9095/customers/uriinfo?start=2&size=2");
        response = client.execute(get);
        Assert.assertEquals(200, response.getStatusLine().getStatusCode());
        reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
    }

}