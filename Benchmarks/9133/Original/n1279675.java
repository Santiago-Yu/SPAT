class n1279675{
    public Mappings read() {
        Mappings result = null;
        InputStream stream = null;
        try {
            XMLParser parser = new XMLParser();
            stream = url.openStream();
            result = parser.parse(stream);
        } catch (Throwable e) {
            log.error("Error in loading dozer mapping file url: [" + url + "] : " + e);
            MappingUtils.throwMappingException(e);
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                MappingUtils.throwMappingException(e);
            }
        }
        return result;
    }

}