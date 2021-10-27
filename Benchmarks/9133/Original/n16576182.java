class n16576182{
    public alto.io.Output openOutput() throws java.io.IOException {
        URL url = this.url;
        if (null != url) {
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            if (connection instanceof alto.net.Connection) {
                ((alto.net.Connection) connection).setReference(this);
            }
            return new ReferenceOutputStream(this, connection);
        }
        HttpMessage container = this.write();
        return new ReferenceOutputStream(this, container);
    }

}