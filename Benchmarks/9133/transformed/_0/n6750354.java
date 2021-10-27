class n6750354 {
	HTTPValuePatternComponent(final String RzL9VuNW, final long VHw5qByI) throws IOException {
        seedRandom = new Random(VHw5qByI);
        random = new ThreadLocal<Random>();
        final ArrayList<String> zWzTbrQD = new ArrayList<String>(100);
        final URL xV85IeJi = new URL(RzL9VuNW);
        final HttpURLConnection qs8ut4dA = (HttpURLConnection) xV85IeJi.openConnection();
        final BufferedReader DqLCqQbR = new BufferedReader(new InputStreamReader(qs8ut4dA.getInputStream()));
        try {
            while (true) {
                final String o9KFz6Wn = DqLCqQbR.readLine();
                if (o9KFz6Wn == null) {
                    break;
                }
                zWzTbrQD.add(o9KFz6Wn);
            }
        } finally {
            DqLCqQbR.close();
        }
        if (zWzTbrQD.isEmpty()) {
            throw new IOException(ERR_VALUE_PATTERN_COMPONENT_EMPTY_FILE.get());
        }
        lines = new String[zWzTbrQD.size()];
        zWzTbrQD.toArray(lines);
    }

}