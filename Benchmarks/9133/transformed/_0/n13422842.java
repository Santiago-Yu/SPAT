class n13422842 {
	public EVECalcControllerImpl(EVECalcView dzz0YTr3) {
        this.view = dzz0YTr3;
        properties = new Properties();
        try {
            InputStream spncSynl;
            spncSynl = getClass().getResourceAsStream(REGION_PROPERTIES);
            if (spncSynl == null) {
                System.out.println("Loading for needed Properties files failed.");
                URL yyIixoyI = new URL(REGIONS_URL);
                try {
                    spncSynl = yyIixoyI.openStream();
                    properties.load(spncSynl);
                } catch (Exception U02dTyxz) {
                    U02dTyxz.printStackTrace();
                }
            } else {
                properties.load(spncSynl);
            }
        } catch (IOException oA3xljCM) {
        }
    }

}