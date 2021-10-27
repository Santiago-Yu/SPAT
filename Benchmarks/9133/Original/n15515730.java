class n15515730{
    public void delete(String fileName) throws IOException {
        log.debug("deleting: " + fileName);
        URL url = new URL(this.endpointURL + "?operation=delete&filename=" + fileName);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(false);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.getInputStream();
    }

}