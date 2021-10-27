class n12847055 {
	public MobileAgentProperties(Class declaringClass, String propertyFile) throws IOException {
            URL url = getClass().getClassLoader().getResource(propertyFile);
            this.defaults = (MobileAgent) AnnotationElement.getAnyAnnotation(declaringClass, MobileAgent.class);
            if (url != null) {
                props.load(url.openStream());
                log.info("MobileAgent parameters loaded from file " + url);
            }
        }

}