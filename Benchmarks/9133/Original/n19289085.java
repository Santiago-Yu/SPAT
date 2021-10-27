class n19289085{
    public void testSendMessage() throws ClientProtocolException, IOException {
        String textMessage = "La%20sua%20prenotazione%20e60%20andata%20a%20buon%20fine";
        String customerPhoneNumber = "+393345730726";
        DefaultHttpClient httpclient = new DefaultHttpClient();
        String other = "http://smswizard.globalitalia.it/smsgateway/send.asp";
        String urlProva = other + "?" + "Account=sardricerche" + "&Password=v8LomdZT" + "&PhoneNumbers=+393345730726" + "&SMSData=" + textMessage + "&Recipients=1" + "&Sender=+393337589951" + "&ID=11762";
        HttpPost httpPost = new HttpPost(urlProva);
        HttpResponse response = httpclient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String txt = EntityUtils.toString(entity);
    }

}