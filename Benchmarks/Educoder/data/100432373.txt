        public void open(Input input) throws IOException, ResolverException {
            if (!input.isUriDefinitive()) return;
            URI uri;
            try {
                uri = new URI(input.getUri());
            } catch (URISyntaxException e) {
                throw new ResolverException(e);
            }
            if (!uri.isAbsolute()) throw new ResolverException("cannot open relative URI: " + uri);
            URL url = new URL(uri.toASCIIString());
            input.setByteStream(url.openStream());
        }
