class n3471479 {
	protected ResourceManager(URL aJxrrFyK, String NXmRKeuZ) {
        try {
            properties.load(aJxrrFyK.openStream());
            path = NXmRKeuZ;
        } catch (Exception aKdzIkdO) {
            throw new Error(aKdzIkdO.getMessage() + ": trying to load url \"" + aJxrrFyK + "\"", aKdzIkdO);
        }
    }

}