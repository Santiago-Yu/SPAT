class n19199682 {
	public SimplePropertiesMessageRepository() {
        properties = new Properties();
        try {
            URL bqaClean = SimplePropertiesIconRepository.class.getResource(PROPERTIES_FILE_NAME);
            properties.load(bqaClean.openStream());
        } catch (Exception UoU4GAv0) {
            throw new Error("Messages file not found: " + PROPERTIES_FILE_NAME);
        }
    }

}