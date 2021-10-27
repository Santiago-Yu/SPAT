class n6397699{
    public void process(String number) {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(Constants.TRAIN_INFO_URL.value());
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair(Constants.TRAIN_NUMBER_POST_PARAM_NAME.value(), number));
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httpPost);
            InputStream is = response.getEntity().getContent();
            Document doc = getDocument(is);
            XPathFactory factory = XPathFactory.newInstance();
            XPath xpath = factory.newXPath();
            XPathExpression expr = xpath.compile(Constants.XPATH_TRAIN_STOPS_INFO.value());
            Object result = expr.evaluate(doc, XPathConstants.NODESET);
            NodeList nodes = (NodeList) result;
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < nodes.getLength(); i++) {
                list.add(nodes.item(i).getNodeValue());
            }
            parse(list);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }

}