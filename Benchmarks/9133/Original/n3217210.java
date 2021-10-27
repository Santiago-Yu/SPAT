class n3217210{
        private boolean request(URI uri, Controller controller, String login, String password) {
            SSLHttpClient client = new SSLHttpClient();
            client.getCredentialsProvider().setCredentials(new AuthScope(uri.getHost(), uri.getPort()), new UsernamePasswordCredentials(login, password));
            HttpGet get = new HttpGet(uri);
            get.addHeader("Accept", "application/xml");
            try {
                HttpResponse response = client.execute(get);
                int code = response.getStatusLine().getStatusCode();
                if (code == HttpStatus.SC_OK) {
                    final InputStream is = response.getEntity().getContent();
                    final XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                    factory.setNamespaceAware(true);
                    final XmlPullParser parser = factory.newPullParser();
                    parser.setInput(is, null);
                    while (parser.next() != XmlPullParser.END_DOCUMENT && !controller.stopped()) {
                        if (parser.getEventType() == XmlPullParser.START_TAG) {
                            String name = parser.getName();
                            if (mEntity.equals(name)) {
                                String id = parser.getAttributeValue(null, "id");
                                if (id != null) {
                                    Item item = new Item(id, parser.nextText());
                                    controller.receiveItem(item);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                controller.error();
                return false;
            }
            return true;
        }

}