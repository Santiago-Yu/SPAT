class n1527633{
    public String getWebcontent(final String link, final String postdata) {
        final StringBuffer response = new StringBuffer();
        try {
            DisableSSLCertificateCheckUtil.disableChecks();
            final URL url = new URL(link);
            final URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            final OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(postdata);
            wr.flush();
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String content = "";
            while ((content = rd.readLine()) != null) {
                response.append(content);
                response.append('\n');
            }
            wr.close();
            rd.close();
        } catch (final Exception e) {
            LOG.error("getWebcontent(String link, String postdata): " + e.toString() + "\012" + link + "\012" + postdata);
        }
        return response.toString();
    }

}