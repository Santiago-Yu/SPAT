class n22225661{
    public InputSource resolveEntity(String publicId, String systemId) {
        String resolved = null;
        if (systemId != null) {
            try {
                resolved = catalog.resolveSystem(systemId);
            } catch (MalformedURLException me) {
                debug(1, "Malformed URL exception trying to resolve", publicId);
                resolved = null;
            } catch (IOException ie) {
                debug(1, "I/O exception trying to resolve", publicId);
                resolved = null;
            }
        }
        if (resolved == null) {
            if (publicId != null) {
                try {
                    resolved = catalog.resolvePublic(publicId, systemId);
                } catch (MalformedURLException me) {
                    debug(1, "Malformed URL exception trying to resolve", publicId);
                } catch (IOException ie) {
                    debug(1, "I/O exception trying to resolve", publicId);
                }
            }
            if (resolved != null) {
                debug(2, "Resolved", publicId, resolved);
            }
        } else {
            debug(2, "Resolved", systemId, resolved);
        }
        if (resolved == null && retryBadSystemIds && publicId != null && systemId != null) {
            URL systemURL = null;
            try {
                systemURL = new URL(systemId);
            } catch (MalformedURLException e) {
                try {
                    systemURL = new URL("file:///" + systemId);
                } catch (MalformedURLException e2) {
                    systemURL = null;
                }
            }
            if (systemURL != null) {
                try {
                    InputStream iStream = systemURL.openStream();
                    InputSource iSource = new InputSource(systemId);
                    iSource.setPublicId(publicId);
                    iSource.setByteStream(iStream);
                    return iSource;
                } catch (Exception e) {
                }
            }
            debug(2, "Failed to open", systemId);
            debug(2, "\tAttempting catalog lookup without system identifier.");
            return resolveEntity(publicId, null);
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
                debug(1, "Failed to create InputSource", resolved);
                return null;
            }
        }
        return null;
    }

}