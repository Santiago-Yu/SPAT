class n14483804{
        public URLStream(URL url) throws IOException {
            this.url = url;
            this.conn = this.url.openConnection();
            contentType = conn.getContentType();
            name = url.toExternalForm();
            size = new Long(conn.getContentLength());
            sourceInfo = "url";
        }

}