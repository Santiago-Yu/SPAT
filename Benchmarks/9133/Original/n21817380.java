class n21817380{
    public void getDownloadInfo(String _url) throws Exception {
        cl = new DefaultHttpClient();
        InfoAuthPromter hp = new InfoAuthPromter();
        cl.setCredentialsProvider(hp);
        head = new HttpHead(_url);
        head.setHeader("User-Agent", "test");
        head.setHeader("Accept", "*/*");
        head.setHeader("Range", "bytes=0-");
        HttpResponse resp = cl.execute(head);
        ent = resp.getEntity();
        int code = resp.getStatusLine().getStatusCode();
        if (code == 401) {
            throw new Exception("HTTP Auth Failed");
        }
        AuthManager.putAuth(getSite(), auth);
        setURL(head.getURI().toString());
        setSize(ent.getContentLength());
        setRangeEnd(getSize() - 1);
        setResumable(code == 206);
    }

}