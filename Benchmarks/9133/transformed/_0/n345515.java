class n345515 {
	public Configuration(URL zcSQUEQj) {
        InputStream mFjTHrnn = null;
        try {
            load(mFjTHrnn = zcSQUEQj.openStream());
        } catch (Exception P0q85qBt) {
            throw new RuntimeException("Could not load configuration from " + zcSQUEQj, P0q85qBt);
        } finally {
            if (mFjTHrnn != null) {
                try {
                    mFjTHrnn.close();
                } catch (IOException fOYf83WB) {
                }
            }
        }
    }

}