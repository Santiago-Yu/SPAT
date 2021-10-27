class n20370107{
    public boolean refresh() {
        try {
            URLConnection conn = url.openConnection();
            conn.setUseCaches(false);
            if (credential != null) conn.setRequestProperty("Authorization", credential);
            conn.connect();
            int status = ((HttpURLConnection) conn).getResponseCode();
            if (status == 401 || status == 403) errorMessage = (credential == null ? PASSWORD_MISSING : PASSWORD_INCORRECT); else if (status == 404) errorMessage = NOT_FOUND; else if (status != 200) errorMessage = COULD_NOT_RETRIEVE; else {
                InputStream in = conn.getInputStream();
                byte[] httpData = TinyWebServer.slurpContents(in, true);
                synchronized (this) {
                    data = httpData;
                    dataProvider = null;
                }
                errorMessage = null;
                refreshDate = new Date();
                String owner = conn.getHeaderField(OWNER_HEADER_FIELD);
                if (owner != null) setLocalAttr(OWNER_ATTR, owner);
                store();
                return true;
            }
        } catch (UnknownHostException uhe) {
            errorMessage = NO_SUCH_HOST;
        } catch (ConnectException ce) {
            errorMessage = COULD_NOT_CONNECT;
        } catch (IOException ioe) {
            errorMessage = COULD_NOT_RETRIEVE;
        }
        return false;
    }

}