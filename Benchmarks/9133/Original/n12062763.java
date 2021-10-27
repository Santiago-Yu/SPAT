class n12062763{
    public void loadFromURLPath(String type, URL urlPath, HashMap parentAttributes) throws IOException {
        this.urlPath = urlPath;
        this.type = type;
        JmeBinaryReader jbr = new JmeBinaryReader();
        setProperties(jbr, parentAttributes);
        InputStream loaderInput = urlPath.openStream();
        if (type.equals("xml")) {
            XMLtoBinary xtb = new XMLtoBinary();
            ByteArrayOutputStream BO = new ByteArrayOutputStream();
            xtb.sendXMLtoBinary(loaderInput, BO);
            loaderInput = new ByteArrayInputStream(BO.toByteArray());
        } else if (!type.equals("binary")) throw new IOException("Unknown LoaderNode flag: " + type);
        jbr.loadBinaryFormat(this, loaderInput);
    }

}