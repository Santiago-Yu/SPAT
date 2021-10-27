class n9685053{
    public Result request(URL url) {
        try {
            return xmlUtil.unmarshall(urlOpener.openStream(url));
        } catch (FileNotFoundException e) {
            log.info("File not found: " + url);
        } catch (IOException e) {
            log.error("Failed to read from url: " + url + ". " + e.getMessage(), e);
        }
        return null;
    }

}