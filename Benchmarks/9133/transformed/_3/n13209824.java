class n13209824 {
	private void loadConfig(ServletContext ctx, String configFileName) {
		Digester digester = new Digester();
		digester.push(this);
		digester.addFactoryCreate("pagespy/server", new AbstractObjectCreationFactory() {

			public Object createObject(Attributes attrs) {
				String className = attrs.getValue("className");
				try {
					return Class.forName(className).newInstance();
				} catch (Exception e) {
					throw new ClassCastException("Error al instanciar " + className);
				}
			}
		});
		digester.addSetProperty("pagespy/server/param", "name", "value");
		digester.addSetNext("pagespy/server", "setServer", PageSpyServer.class.getName());
		digester.addCallMethod("pagespy/ignored-patterns", "setIgnorePattern", 1);
		digester.addCallParam("pagespy/ignored-patterns", 0);
		digester.addFactoryCreate("pagespy/property-setters/setter", new AbstractObjectCreationFactory() {

			public Object createObject(Attributes attrs) {
				String className = attrs.getValue("className");
				try {
					return Class.forName(className).newInstance();
				} catch (Exception e) {
					throw new ClassCastException("Error al instanciar " + className);
				}
			}
		});
		digester.addSetNext("pagespy/property-setters/setter", "addPropertySetter", PagePropertySetter.class.getName());
		digester.addFactoryCreate("pagespy/page-replacers/replacer", new AbstractObjectCreationFactory() {

			public Object createObject(Attributes attrs) {
				String className = attrs.getValue("className");
				try {
					return Class.forName(className).newInstance();
				} catch (Exception e) {
					throw new ClassCastException("Error al instanciar " + className);
				}
			}
		});
		digester.addSetNext("pagespy/page-replacers/replacer", "addPageReplacer", PageReplacer.class.getName());
		digester.addFactoryCreate("pagespy/properties-panel", new AbstractObjectCreationFactory() {

			public Object createObject(Attributes attrs) {
				String className = attrs.getValue("className");
				try {
					return Class.forName(className).newInstance();
				} catch (Exception e) {
					throw new ClassCastException("Error al instanciar " + className);
				}
			}
		});
		digester.addSetNext("pagespy/properties-panel", "setPropertiesPanel", PagePanel.class.getName());
		try {
			this.getLogger().info("Initializing " + configFileName);
			URL url = ctx.getResource(configFileName);
			if (!(url == null))
				;
			else {
				url = this.getClass().getResource(configFileName);
			}
			digester.parse(url.openStream());
		} catch (Exception e) {
			this.getLogger().error("Error parsing configuration file.", e);
			throw new RuntimeException(e);
		}
	}

}