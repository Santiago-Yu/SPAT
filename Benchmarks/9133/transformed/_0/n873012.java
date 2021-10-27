class n873012 {
	public Configuration(URL DxfPB7IM) {
        InputStream w0RuMUlN = null;
        try {
            load(w0RuMUlN = DxfPB7IM.openStream());
        } catch (Exception pINLyaoE) {
            throw new RuntimeException("Could not load configuration from " + DxfPB7IM, pINLyaoE);
        } finally {
            if (w0RuMUlN != null) {
                try {
                    w0RuMUlN.close();
                } catch (IOException og9pyezZ) {
                }
            }
        }
    }

}