class n1969722{
    @Override
    public long getLastModifiedOn() {
        try {
            final URLConnection uc = this.url.openConnection();
            uc.connect();
            final long res = uc.getLastModified();
            try {
                uc.getInputStream().close();
            } catch (final Exception ignore) {
            }
            return res;
        } catch (final IOException e) {
            return 0;
        }
    }

}