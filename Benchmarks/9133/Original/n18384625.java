class n18384625{
    private void setupPool() {
        this.pool = new ObjectPool(this.numConns) {

            protected Object getNewObject() throws IOException {
                URLConnection conn = HTTPMessageDeliveryImpl.this.url.openConnection();
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setUseCaches(false);
                conn.setRequestProperty("Content-Type", "text/xml");
                return conn;
            }
        };
    }

}