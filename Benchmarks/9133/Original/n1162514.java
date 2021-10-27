class n1162514{
    private LSInput resolveResource(String aPublicId, String aSystemId, String aBaseURI, boolean baseUsed) {
        LSInput lsInput = new DefaultLSInput();
        lsInput.setPublicId(aPublicId);
        lsInput.setSystemId(aSystemId);
        String base = null;
        try {
            int baseEndPos = -1;
            if (aBaseURI != null) {
                baseEndPos = aBaseURI.lastIndexOf("/");
            }
            if (baseEndPos <= 0) {
                if (baseUsed) {
                    return null;
                } else {
                    return resolveResource(aPublicId, aSystemId, schemaBasePath + "/" + aSystemId, true);
                }
            }
            base = aBaseURI.substring(0, baseEndPos);
            URL url = new URL(base + "/" + aSystemId);
            lsInput.setByteStream(url.openConnection().getInputStream());
            return lsInput;
        } catch (IOException e) {
            return resolveResource(aPublicId, aSystemId, base, baseUsed);
        }
    }

}