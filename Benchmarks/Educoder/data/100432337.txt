    public static InputStream getStreamFromSystemIdentifier(String systemId, EntityResolver resolver) throws Exception {
        InputSource source = null;
        InputStream stream = null;
        if (resolver != null) {
            try {
                source = resolver.resolveEntity(null, systemId);
            } catch (Exception e) {
                LogService.instance().log(LogService.ERROR, "DocumentFactory: Unable to resolve '" + systemId + "'");
                LogService.instance().log(LogService.ERROR, e);
            }
        }
        if (source != null) {
            try {
                stream = source.getByteStream();
            } catch (Exception e) {
                LogService.instance().log(LogService.ERROR, "DocumentFactory: Unable to get bytestream from '" + source.getSystemId() + "'");
                LogService.instance().log(LogService.ERROR, e);
            }
        }
        if (stream == null) {
            URL url = new URL(systemId);
            stream = url.openStream();
        }
        return stream;
    }
