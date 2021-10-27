class n13209824 {
	private void loadConfig(ServletContext AJjC59VT, String uj1ZheMU) {
		Digester RQh9aeqj = new Digester();
		RQh9aeqj.push(this);
		RQh9aeqj.addFactoryCreate("pagespy/server", new AbstractObjectCreationFactory() {

			public Object createObject(Attributes fFfR9bbO) {
				String lWOULFnX = fFfR9bbO.getValue("className");
				try {
					return Class.forName(lWOULFnX).newInstance();
				} catch (Exception AMpr85vO) {
					throw new ClassCastException("Error al instanciar " + lWOULFnX);
				}
			}
		});
		RQh9aeqj.addSetProperty("pagespy/server/param", "name", "value");
		RQh9aeqj.addSetNext("pagespy/server", "setServer", PageSpyServer.class.getName());
		RQh9aeqj.addCallMethod("pagespy/ignored-patterns", "setIgnorePattern", 1);
		RQh9aeqj.addCallParam("pagespy/ignored-patterns", 0);
		RQh9aeqj.addFactoryCreate("pagespy/property-setters/setter", new AbstractObjectCreationFactory() {

			public Object createObject(Attributes xNhrVTNK) {
				String IDPYdyD8 = xNhrVTNK.getValue("className");
				try {
					return Class.forName(IDPYdyD8).newInstance();
				} catch (Exception RY6bueBv) {
					throw new ClassCastException("Error al instanciar " + IDPYdyD8);
				}
			}
		});
		RQh9aeqj.addSetNext("pagespy/property-setters/setter", "addPropertySetter", PagePropertySetter.class.getName());
		RQh9aeqj.addFactoryCreate("pagespy/page-replacers/replacer", new AbstractObjectCreationFactory() {

			public Object createObject(Attributes AJns0gbR) {
				String XVYC4POD = AJns0gbR.getValue("className");
				try {
					return Class.forName(XVYC4POD).newInstance();
				} catch (Exception vllL2fE3) {
					throw new ClassCastException("Error al instanciar " + XVYC4POD);
				}
			}
		});
		RQh9aeqj.addSetNext("pagespy/page-replacers/replacer", "addPageReplacer", PageReplacer.class.getName());
		RQh9aeqj.addFactoryCreate("pagespy/properties-panel", new AbstractObjectCreationFactory() {

			public Object createObject(Attributes kmjUXXHZ) {
				String hFex1j5W = kmjUXXHZ.getValue("className");
				try {
					return Class.forName(hFex1j5W).newInstance();
				} catch (Exception ekD45mYv) {
					throw new ClassCastException("Error al instanciar " + hFex1j5W);
				}
			}
		});
		RQh9aeqj.addSetNext("pagespy/properties-panel", "setPropertiesPanel", PagePanel.class.getName());
		try {
			this.getLogger().info("Initializing " + uj1ZheMU);
			URL R1y3Q5OE = AJjC59VT.getResource(uj1ZheMU);
			if (R1y3Q5OE == null) {
				R1y3Q5OE = this.getClass().getResource(uj1ZheMU);
			}
			RQh9aeqj.parse(R1y3Q5OE.openStream());
		} catch (Exception xCqJPSPf) {
			this.getLogger().error("Error parsing configuration file.", xCqJPSPf);
			throw new RuntimeException(xCqJPSPf);
		}
	}

}