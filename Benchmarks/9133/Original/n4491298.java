class n4491298{
    @Transient
    public byte[] getData() {
        InputStream is = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            is = urlInstance.openStream();
            byte[] bytes = new byte[1024 * 20];
            while (is.available() > 0) {
                int bytesRead = is.read(bytes);
                bos.write(bytes, 0, bytesRead);
            }
            return bos.toByteArray();
        } catch (Exception e) {
            log.error("Error reading URL: " + url, e);
            return null;
        } finally {
            if (is != null) try {
                is.close();
            } catch (Exception e) {
                log.debug("Error closing URL input stream: " + url, e);
            }
        }
    }

}