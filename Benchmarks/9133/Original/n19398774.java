class n19398774{
    public void onMessage(javax.jms.Message aMessage) {
        try {
            String urlStr = "http://203.197.20.2:8080/newgenlibctxt/oai2.0?verb=ListRecords&resumptionToken=100_marc";
            java.net.URL url = new java.net.URL(urlStr);
            java.net.URLConnection urlCon = url.openConnection();
            urlCon.setDoInput(true);
            urlCon.connect();
            InputStream is = urlCon.getInputStream();
            org.jdom.input.SAXBuilder sb = new org.jdom.input.SAXBuilder();
            org.jdom.Document doc = sb.build(is);
            String xmlstr = (new org.jdom.output.XMLOutputter()).outputString(doc);
            doc = null;
            sb = null;
            java.util.Vector vec = new java.util.Vector();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            TextMessage tm = (TextMessage) aMessage;
            String text = tm.getText() + "processed by: message bean on july 13" + hashCode();
            Queue dest = (Queue) aMessage.getJMSReplyTo();
            sendReply(text, dest);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}