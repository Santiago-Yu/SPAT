class n414258 {
	public Configuration(URL RYlnRDfB) {
        InputStream hOUM21sd = null;
        try {
            load(hOUM21sd = RYlnRDfB.openStream());
        } catch (Exception XhlTNnZl) {
            throw new RuntimeException("Could not load configuration from " + RYlnRDfB, XhlTNnZl);
        } finally {
            if (hOUM21sd != null) {
                try {
                    hOUM21sd.close();
                } catch (IOException zkFi8u0g) {
                }
            }
        }
    }

}