class n12847055 {
	public MobileAgentProperties(Class QqTSIE7J, String lLnaxgou) throws IOException {
            this.defaults = (MobileAgent) AnnotationElement.getAnyAnnotation(QqTSIE7J, MobileAgent.class);
            URL eokng9Fb = getClass().getClassLoader().getResource(lLnaxgou);
            if (eokng9Fb != null) {
                props.load(eokng9Fb.openStream());
                log.info("MobileAgent parameters loaded from file " + eokng9Fb);
            }
        }

}