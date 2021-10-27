class n9793280{
    public SqlScript(URL url, IDbDialect platform, boolean failOnError, String delimiter, Map<String, String> replacementTokens) {
        try {
            fileName = url.getFile();
            fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
            log.log(LogLevel.INFO, "Loading sql from script %s", fileName);
            init(IoUtils.readLines(new InputStreamReader(url.openStream(), "UTF-8")), platform, failOnError, delimiter, replacementTokens);
        } catch (IOException ex) {
            log.error(ex);
            throw new RuntimeException(ex);
        }
    }

}