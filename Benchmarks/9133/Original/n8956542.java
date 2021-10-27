class n8956542{
    public static InputStream retrievePricesHTML(String username, String password) throws IOException, SAXException {
        List<String> cookies = new ArrayList<String>();
        URL url = new URL("http://motormouth.com.au/default_fl.aspx");
        HttpURLConnection loginConnection = (HttpURLConnection) url.openConnection();
        String viewStateValue = HTMLParser.parseHTMLInputTagValue(new InputStreamReader(loginConnection.getInputStream()), "__VIEWSTATE");
        setCookies(cookies, loginConnection);
        HttpURLConnection postCredsConnection = (HttpURLConnection) url.openConnection();
        postCredsConnection.setDoOutput(true);
        postCredsConnection.setRequestMethod("POST");
        postCredsConnection.setInstanceFollowRedirects(false);
        postCredsConnection.setRequestProperty("Cookie", buildCookieString(cookies));
        OutputStreamWriter postCredsWriter = new OutputStreamWriter(postCredsConnection.getOutputStream());
        postCredsWriter.append("__VIEWSTATE=").append(URLEncoder.encode(viewStateValue, "UTF-8")).append('&');
        postCredsWriter.append("Login_Module1%3Ausername=").append(URLEncoder.encode(username, "UTF-8")).append('&');
        postCredsWriter.append("Login_Module1%3Apassword=").append(URLEncoder.encode(password, "UTF-8")).append('&');
        postCredsWriter.append("Login_Module1%3AButtonLogin.x=0").append('&');
        postCredsWriter.append("Login_Module1%3AButtonLogin.y=0");
        postCredsWriter.flush();
        postCredsWriter.close();
        int postResponseCode = postCredsConnection.getResponseCode();
        if (postResponseCode == 302) {
            setCookies(cookies, postCredsConnection);
            URL dataUrl = new URL(url, postCredsConnection.getHeaderField("Location"));
            HttpURLConnection dataConnection = (HttpURLConnection) dataUrl.openConnection();
            dataConnection.setRequestProperty("Cookie", buildCookieString(cookies));
            InputStream dataInputStream = dataConnection.getInputStream();
            return dataInputStream;
        } else if (postResponseCode == 200) {
            URL dataUrl = new URL(url, "/secure/mymotormouth.aspx");
            HttpURLConnection dataConnection = (HttpURLConnection) dataUrl.openConnection();
            dataConnection.setRequestProperty("Cookie", buildCookieString(cookies));
            InputStream dataInputStream = dataConnection.getInputStream();
            return dataInputStream;
        } else {
            return null;
        }
    }

}