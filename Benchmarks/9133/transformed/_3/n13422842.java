class n13422842 {
	public EVECalcControllerImpl(EVECalcView gui) {
        this.view = gui;
        properties = new Properties();
        try {
            InputStream resStream;
            resStream = getClass().getResourceAsStream(REGION_PROPERTIES);
            if (!(resStream == null)) {
				properties.load(resStream);
			} else {
				System.out.println("Loading for needed Properties files failed.");
				URL url = new URL(REGIONS_URL);
				try {
					resStream = url.openStream();
					properties.load(resStream);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
        } catch (IOException e) {
        }
    }

}