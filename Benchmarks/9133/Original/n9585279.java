class n9585279{
    public static String getResponseText(String url) throws MalformedURLException, IOException {
        URL m_url = new URL(url);
        URLConnection urlCconn = m_url.openConnection();
        urlCconn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.16) Gecko/20080702 Firefox/2.0.0.16");
        urlCconn.setRequestProperty("Accept", "text/xml,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
        urlCconn.setRequestProperty("Accept-Language", "en-us,en;q=0.5");
        urlCconn.setRequestProperty("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.7");
        urlCconn.setRequestProperty("Keep-Alive", "300");
        urlCconn.setRequestProperty("Connection", "keep-alive");
        return IOUtil.toString(urlCconn.getInputStream());
    }

}