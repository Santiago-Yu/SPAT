class n1969721{
    @Override
    public final boolean exists() {
        try {
            final URLConnection uc = this.url.openConnection();
            uc.connect();
            uc.getInputStream().close();
            return true;
        } catch (final IOException e) {
            return false;
        }
    }

}