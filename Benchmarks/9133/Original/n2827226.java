class n2827226{
    public InputSource resolveEntity(String publicId, String systemId) {
        allowXMLCatalogPI = false;
        String resolved = catalogResolver.getResolvedEntity(publicId, systemId);
        if (resolved == null && piCatalogResolver != null) {
            resolved = piCatalogResolver.getResolvedEntity(publicId, systemId);
        }
        if (resolved != null) {
            try {
                InputSource iSource = new InputSource(resolved);
                iSource.setPublicId(publicId);
                URL url = new URL(resolved);
                InputStream iStream = url.openStream();
                iSource.setByteStream(iStream);
                return iSource;
            } catch (Exception e) {
                catalogManager.debug.message(1, "Failed to create InputSource", resolved);
                return null;
            }
        } else {
            return null;
        }
    }

}