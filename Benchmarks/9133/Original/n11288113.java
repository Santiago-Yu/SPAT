class n11288113{
    public AssemblyConfig load() {
        AssemblyConfig assembly = null;
        Digester digester = createParser();
        try {
            if (inputStream != null) {
                if (logger.isDebugEnabled()) {
                    logger.debug("XML config loader is parsing an inputstream:" + inputStream);
                }
                assembly = (AssemblyConfig) digester.parse(inputStream);
            } else if (file != null) {
                if (logger.isDebugEnabled()) {
                    logger.debug("XML config loader is parsing a file:" + file);
                }
                assembly = (AssemblyConfig) digester.parse(file);
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug("XML config loader is parsing a URI:" + uri);
                }
                URL url = new URL(uri);
                inputStream = url.openStream();
                assembly = (AssemblyConfig) digester.parse(inputStream);
            }
            if (assembly != null) {
                logger.debug("Services from XML configuration are: ");
                logger.debug(assembly.toString());
            } else {
                throw new AssemblyConfigException("Unable to parse the XML assembly configuration. " + "HINT: Please check the schema/grammar of the supplied " + "XML document and verify the XML namespace is correct.");
            }
        } catch (IOException ioe) {
            throw new AssemblyConfigException("I/O failure, unable to process configuration", ioe);
        } catch (SAXException sxe) {
            throw new AssemblyConfigException("XML Reader failure, unable to process configuration", sxe);
        }
        return assembly;
    }

}