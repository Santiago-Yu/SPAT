class n5783518{
    @Override
    protected boolean sendBytes(byte[] data, int offset, int length) {
        try {
            String hex = toHex(data, offset, length);
            URL url = new URL(this.endpoint, "?raw=" + hex);
            System.out.println("Connecting to " + url);
            URLConnection conn = url.openConnection();
            conn.connect();
            Object content = conn.getContent();
            return true;
        } catch (IOException ex) {
            LOGGER.warning(ex.getMessage());
            return false;
        }
    }

}