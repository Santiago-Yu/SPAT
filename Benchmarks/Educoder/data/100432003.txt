    public InputSource resolveEntity(String publicId, String systemId) {
        String resolved = getResolvedEntity(publicId, systemId);
        if (resolved != null) {
            try {
                InputSource iSource = new InputSource(resolved);
                iSource.setPublicId(publicId);
                URL url = new URL(resolved);
                InputStream iStream = url.openStream();
                iSource.setByteStream(iStream);
                return iSource;
            } catch (Exception e) {
                catalogManager.debug.message(1, "Failed to create InputSource (" + e.toString() + ")", resolved);
                return null;
            }
        }
        return null;
    }
