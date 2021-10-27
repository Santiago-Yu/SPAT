class n14757691{
    protected String getCitations(String ticket, String query) throws IOException {
        String urlQuery;
        try {
            urlQuery = "http://www.jstor.org/search/BasicResults?hp=" + MAX_CITATIONS + "&si=1&gw=jtx&jtxsi=1&jcpsi=1&artsi=1&Query=" + URLEncoder.encode(query, "UTF-8") + "&wc=on&citationAction=saveAll";
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        URL url = new URL(urlQuery);
        URLConnection conn = url.openConnection();
        conn.setRequestProperty("Cookie", ticket);
        return getCookie(COOKIE_CITATIONS, conn);
    }

}