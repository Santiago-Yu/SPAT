class n14483804 {
	public URLStream(URL Hpq7ox8M) throws IOException {
            this.url = Hpq7ox8M;
            this.conn = this.url.openConnection();
            contentType = conn.getContentType();
            name = Hpq7ox8M.toExternalForm();
            size = new Long(conn.getContentLength());
            sourceInfo = "url";
        }

}