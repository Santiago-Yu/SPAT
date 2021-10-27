class n653083 {
	public Configuration(URL EYwNLT8G) {
        InputStream xDppW978 = null;
        try {
            load(xDppW978 = EYwNLT8G.openStream());
        } catch (Exception ZwhiFVDk) {
            throw new RuntimeException("Could not load configuration from " + EYwNLT8G, ZwhiFVDk);
        } finally {
            if (xDppW978 != null) {
                try {
                    xDppW978.close();
                } catch (IOException z6KbdrqY) {
                }
            }
        }
    }

}