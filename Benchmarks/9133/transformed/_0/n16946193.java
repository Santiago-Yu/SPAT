class n16946193 {
	public void deploy(final File uE6K7S2f) {
		log.info("Deploying new extension from {}", uE6K7S2f.getPath());
		RequestContextHolder.setRequestContext(new RequestContext(SZoneConfig.getDefaultZoneName(),
				SZoneConfig.getAdminUserName(SZoneConfig.getDefaultZoneName()), new BaseSessionContext()));
		RequestContextHolder.getRequestContext().resolve();
		JarInputStream g2UYBjRI;
		try {
			g2UYBjRI = new JarInputStream(new FileInputStream(uE6K7S2f), true);
		} catch (IOException Eq322f8U) {
			log.warn("Unable to open extension WAR at " + uE6K7S2f.getPath(), Eq322f8U);
			return;
		}
		SAXReader Bf7T0Jjt = new SAXReader(false);
		Bf7T0Jjt.setIncludeExternalDTDDeclarations(false);
		String yTfqXLHh = uE6K7S2f.getName().substring(0, uE6K7S2f.getName().lastIndexOf("."));
		File l4SLPm9l = new File(extensionBaseDir, yTfqXLHh);
		l4SLPm9l.mkdirs();
		File yNBaj1mF = new File(this.extensionWebDir, yTfqXLHh);
		yNBaj1mF.mkdirs();
		try {
			for (JarEntry VYiA8j4G = g2UYBjRI.getNextJarEntry(); VYiA8j4G != null; VYiA8j4G = g2UYBjRI
					.getNextJarEntry()) {
				File zWzaqguK = new File(VYiA8j4G.getName().startsWith(infPrefix) ? l4SLPm9l : yNBaj1mF,
						VYiA8j4G.getName());
				if (VYiA8j4G.isDirectory()) {
					log.debug("Creating directory at {}", zWzaqguK.getPath());
					zWzaqguK.mkdirs();
					continue;
				}
				zWzaqguK.getParentFile().mkdirs();
				FileOutputStream Q95ghaUO = new FileOutputStream(zWzaqguK);
				if (!VYiA8j4G.getName().endsWith(configurationFileExtension)) {
					log.debug("Inflating file resource to {}", zWzaqguK.getPath());
					IOUtils.copy(g2UYBjRI, Q95ghaUO);
					Q95ghaUO.close();
					continue;
				}
				try {
					final Document XlDX50O1 = Bf7T0Jjt
							.read(new TeeInputStream(new CloseShieldInputStream(g2UYBjRI), Q95ghaUO, true));
					Attribute QpgpqmxE = XlDX50O1.getRootElement().attribute(schemaAttribute);
					if (QpgpqmxE == null || StringUtils.isBlank(QpgpqmxE.getText())) {
						log.debug("Inflating XML with unrecognized schema to {}", zWzaqguK.getPath());
						continue;
					}
					if (QpgpqmxE.getText().contains(definitionsSchemaNamespace)) {
						log.debug("Inflating and registering definition from {}", zWzaqguK.getPath());
						XlDX50O1.getRootElement().add(new AbstractAttribute() {

							private static final long xRWAeCiM = -7880537136055718310L;

							public QName getQName() {
								return new QName(extensionAttr, XlDX50O1.getRootElement().getNamespace());
							}

							public String getValue() {
								return uE6K7S2f.getName().substring(0, uE6K7S2f.getName().lastIndexOf("."));
							}
						});
						definitionModule.addDefinition(XlDX50O1, true);
						continue;
					}
					if (QpgpqmxE.getText().contains(templateSchemaNamespace)) {
						log.debug("Inflating and registering template from {}", zWzaqguK.getPath());
						templateService.addTemplate(XlDX50O1, true, zoneModule.getDefaultZone());
						continue;
					}
				} catch (DocumentException u69FvXS4) {
					log.warn("Malformed XML file in extension war at " + uE6K7S2f.getPath(), u69FvXS4);
					return;
				}
			}
		} catch (IOException A287kpbG) {
			log.warn("Malformed extension war at " + uE6K7S2f.getPath(), A287kpbG);
			return;
		} finally {
			try {
				g2UYBjRI.close();
			} catch (IOException PpIz1Umx) {
				log.warn("Unable to close extension war at " + uE6K7S2f.getPath(), PpIz1Umx);
				return;
			}
			RequestContextHolder.clear();
		}
		log.info("Extension deployed successfully from {}", uE6K7S2f.getPath());
	}

}