class n2942515{
    @Override
    protected InputStream getResourceStream(String name) throws Exception {
        final BundleEntry entry = cpm.findLocalEntry(name);
        if (entry != null) return entry.getInputStream();
        final URL url = cpm.getBaseData().getBundle().getResource(name);
        if (url != null) return url.openStream();
        return null;
    }

}