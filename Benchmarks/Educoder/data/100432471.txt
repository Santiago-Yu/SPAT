        public MobileAgentProperties(Class declaringClass, String propertyFile) throws IOException {
            this.defaults = (MobileAgent) AnnotationElement.getAnyAnnotation(declaringClass, MobileAgent.class);
            URL url = getClass().getClassLoader().getResource(propertyFile);
            if (url != null) {
                props.load(url.openStream());
                log.info("MobileAgent parameters loaded from file " + url);
            }
        }
