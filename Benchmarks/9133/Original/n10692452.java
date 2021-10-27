class n10692452{
    public boolean config(URL url, boolean throwsException) throws IllegalArgumentException {
        try {
            final MetaRoot conf = UjoManagerXML.getInstance().parseXML(new BufferedInputStream(url.openStream()), MetaRoot.class, this);
            config(conf);
            return true;
        } catch (Exception e) {
            if (throwsException) {
                throw new IllegalArgumentException("Configuration file is not valid ", e);
            } else {
                return false;
            }
        }
    }

}