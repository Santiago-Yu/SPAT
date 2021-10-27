class n13167991{
    public void connectToUrl(String url_address) {
        message = new StringBuffer("");
        try {
            URL url = new URL(url_address);
            try {
                HttpsURLConnection httpsConnection = (HttpsURLConnection) url.openConnection();
                httpsConnection.setDoOutput(false);
                httpsConnection.connect();
                message.append("<BR>\n Connection Code:[" + httpsConnection.getResponseCode() + "]");
                message.append("<BR>\n Response Message:[" + httpsConnection.getResponseMessage() + "]");
                InputStreamReader insr = new InputStreamReader(httpsConnection.getInputStream());
                BufferedReader in = new BufferedReader(insr);
                fullStringBuffer = new StringBuffer("");
                String temp = in.readLine();
                while (temp != null) {
                    fullStringBuffer.append(temp);
                    temp = in.readLine();
                }
                in.close();
            } catch (IOException e) {
                message.append("<BR>\n [Error][IOException][" + e.getMessage() + "]");
            }
        } catch (MalformedURLException e) {
            message.append("<BR>\n [Error][MalformedURLException][" + e.getMessage() + "]");
        } catch (Exception e) {
            message.append("<BR>\n [Error][Exception][" + e.getMessage() + "]");
        }
    }

}