class n314795 {
	public Configuration(URL vOE4aBSy) {
        InputStream SAyHJNDp = null;
        try {
            load(SAyHJNDp = vOE4aBSy.openStream());
        } catch (Exception ysF8lLMo) {
            throw new RuntimeException("Could not load configuration from " + vOE4aBSy, ysF8lLMo);
        } finally {
            if (SAyHJNDp != null) {
                try {
                    SAyHJNDp.close();
                } catch (IOException Yn1oItco) {
                }
            }
        }
    }

}