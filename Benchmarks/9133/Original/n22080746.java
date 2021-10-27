class n22080746{
    @Test
    public void testCarResource() throws Exception {
        DefaultHttpClient client = new DefaultHttpClient();
        System.out.println("**** CarResource Via @MatrixParam ***");
        HttpGet get = new HttpGet("http://localhost:9095/cars/matrix/mercedes/e55;color=black/2006");
        HttpResponse response = client.execute(get);
        Assert.assertEquals(200, response.getStatusLine().getStatusCode());
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
        System.out.println("**** CarResource Via PathSegment ***");
        get = new HttpGet("http://localhost:9095/cars/segment/mercedes/e55;color=black/2006");
        response = client.execute(get);
        Assert.assertEquals(200, response.getStatusLine().getStatusCode());
        reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
        System.out.println("**** CarResource Via PathSegments ***");
        get = new HttpGet("http://localhost:9095/cars/segments/mercedes/e55/amg/year/2006");
        response = client.execute(get);
        Assert.assertEquals(200, response.getStatusLine().getStatusCode());
        reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
        System.out.println("**** CarResource Via PathSegment ***");
        get = new HttpGet("http://localhost:9095/cars/uriinfo/mercedes/e55;color=black/2006");
        response = client.execute(get);
        Assert.assertEquals(200, response.getStatusLine().getStatusCode());
        reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
        System.out.println();
        System.out.println();
    }

}