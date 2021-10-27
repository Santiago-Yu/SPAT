    @Test
    public void test02_ok() throws Exception {
        DefaultHttpClient client = new DefaultHttpClient();
        try {
            HttpPost post = new HttpPost(chartURL);
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("ws", "getDomainEvolution"));
            nameValuePairs.add(new BasicNameValuePair("chartTitle", "test"));
            nameValuePairs.add(new BasicNameValuePair("type", "chart"));
            nameValuePairs.add(new BasicNameValuePair("firstDate", "20111124"));
            nameValuePairs.add(new BasicNameValuePair("lastDate", "20111125"));
            nameValuePairs.add(new BasicNameValuePair("wsParams", "type,counting,protocol,unit,proxy,domain,timeScale,period"));
            nameValuePairs.add(new BasicNameValuePair("wsParamsValues", "chart,volume,all,hits,all,google.com,day,360"));
            nameValuePairs.add(new BasicNameValuePair("serieTitle", "serie"));
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            assertNotNull(entity);
            InputStream instream = entity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
            System.out.println(reader.readLine());
            instream.close();
            assertEquals("error :" + response.getStatusLine(), 200, response.getStatusLine().getStatusCode());
        } finally {
            client.getConnectionManager().shutdown();
        }
    }
