class n8535393{
    public static InputStream getRemoteIS(URL url, String post) throws ArcImsException {
        InputStream lector = null;
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-length", "" + post.length());
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(post);
            wr.flush();
            logger.info("downloading '" + url.toString());
            lector = conn.getInputStream();
        } catch (ConnectException e) {
            logger.error("Timed out error", e);
            throw new ArcImsException("arcims_server_timeout");
        } catch (ProtocolException e) {
            logger.error(e.getMessage(), e);
            throw new ArcImsException("arcims_server_error");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new ArcImsException("arcims_server_error");
        }
        return lector;
    }

}