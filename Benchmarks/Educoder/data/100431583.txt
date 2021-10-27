    public InputStream getInputStream() throws TGBrowserException {
        try {
            if (!this.isFolder()) {
                URL url = new URL(this.url);
                InputStream stream = url.openStream();
                return stream;
            }
        } catch (Throwable throwable) {
            throw new TGBrowserException(throwable);
        }
        return null;
    }
