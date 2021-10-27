class n1038900{
    public static SOAPMessage call(SOAPMessage request, URL url) throws IOException, SOAPException {
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.connect();
        request.writeTo(conn.getOutputStream());
        MessageFactory mf = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        return mf.createMessage(null, conn.getInputStream());
    }

}