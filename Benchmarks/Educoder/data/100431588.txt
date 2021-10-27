    @Override
    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        if ((url == null) || (proxy == null)) {
            throw new IllegalArgumentException(Messages.getString("luni.1B"));
        }
        return new HttpsURLConnectionImpl(url, getDefaultPort(), proxy);
    }
