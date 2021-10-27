class n18539809{
    private Collection<URL> doSearch(final URL url) throws IOException {
        final Collection<URL> result = new ArrayList<URL>();
        final InputStream is = url.openStream();
        final ReadHTML parse = new ReadHTML(is);
        final StringBuilder buffer = new StringBuilder();
        boolean capture = false;
        int ch;
        while ((ch = parse.read()) != -1) {
            if (ch == 0) {
                final Tag tag = parse.getTag();
                if (tag.getName().equalsIgnoreCase("url")) {
                    buffer.setLength(0);
                    capture = true;
                } else if (tag.getName().equalsIgnoreCase("/url")) {
                    result.add(new URL(buffer.toString()));
                    buffer.setLength(0);
                    capture = false;
                }
            } else {
                if (capture) {
                    buffer.append((char) ch);
                }
            }
        }
        return result;
    }

}