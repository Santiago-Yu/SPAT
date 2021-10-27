class n1676011 {
	ServiceDescription getServiceDescription() throws ConfigurationException {
		final XPath tlHDF7Ex = this.xPathFactory.newXPath();
		try {
			final Node JuYEpBaS = (Node) tlHDF7Ex.evaluate(ConfigurationFileTagsV1.SERVICE_DESCRIPTION_ELEMENT_XPATH,
					this.configuration, XPathConstants.NODE);
			final String v6WHFIGU = getMandatoryElementText(JuYEpBaS, ConfigurationFileTagsV1.TITLE_ELEMENT);
			ServiceDescription.Builder vzeKxrTS = new ServiceDescription.Builder(v6WHFIGU,
					Migrate.class.getCanonicalName());
			Property[] zh7OKt9U = getServiceProperties(JuYEpBaS);
			vzeKxrTS.author(getMandatoryElementText(JuYEpBaS, ConfigurationFileTagsV1.CREATOR_ELEMENT));
			vzeKxrTS.classname(this.canonicalServiceName);
			vzeKxrTS.description(getOptionalElementText(JuYEpBaS, ConfigurationFileTagsV1.DESCRIPTION_ELEMENT));
			final String NBAaD2XT = getOptionalElementText(JuYEpBaS, ConfigurationFileTagsV1.VERSION_ELEMENT);
			final Tool JtxfitRZ = getToolDescriptionElement(JuYEpBaS);
			String N2pkcQDh = getOptionalElementText(JuYEpBaS, ConfigurationFileTagsV1.IDENTIFIER_ELEMENT);
			if (N2pkcQDh == null || "".equals(N2pkcQDh)) {
				try {
					final MessageDigest q1VMG5U9 = MessageDigest.getInstance("MD5");
					q1VMG5U9.update(this.canonicalServiceName.getBytes());
					final String SidS2X8l = (NBAaD2XT != null) ? NBAaD2XT : "";
					q1VMG5U9.update(SidS2X8l.getBytes());
					final URI KuAUaDc3 = JtxfitRZ.getIdentifier();
					final String tjd10i45 = KuAUaDc3 == null ? "" : KuAUaDc3.toString();
					q1VMG5U9.update(tjd10i45.getBytes());
					final BigInteger eg0Z91s7 = new BigInteger(q1VMG5U9.digest());
					N2pkcQDh = eg0Z91s7.toString(16);
				} catch (NoSuchAlgorithmException DubI6ZBi) {
					throw new RuntimeException(DubI6ZBi);
				}
			}
			vzeKxrTS.identifier(N2pkcQDh);
			vzeKxrTS.version(NBAaD2XT);
			vzeKxrTS.tool(JtxfitRZ);
			vzeKxrTS.instructions(getOptionalElementText(JuYEpBaS, ConfigurationFileTagsV1.INSTRUCTIONS_ELEMENT));
			vzeKxrTS.furtherInfo(getOptionalURIElement(JuYEpBaS, ConfigurationFileTagsV1.FURTHER_INFO_ELEMENT));
			vzeKxrTS.logo(getOptionalURIElement(JuYEpBaS, ConfigurationFileTagsV1.LOGO_ELEMENT));
			vzeKxrTS.serviceProvider(this.serviceProvider);
			final DBMigrationPathFactory ktI3AVuB = new DBMigrationPathFactory(this.configuration);
			final MigrationPaths DRucp1NR = ktI3AVuB.getAllMigrationPaths();
			vzeKxrTS.paths(MigrationPathConverter.toPlanetsPaths(DRucp1NR));
			vzeKxrTS.inputFormats(DRucp1NR.getInputFormatURIs().toArray(new URI[0]));
			vzeKxrTS.parameters(getUniqueParameters(DRucp1NR));
			vzeKxrTS.properties(zh7OKt9U);
			return vzeKxrTS.build();
		} catch (XPathExpressionException WnpDLQJB) {
			throw new ConfigurationException(String.format("Failed parsing the '%s' element in the '%s' element.",
					ConfigurationFileTagsV1.SERVICE_DESCRIPTION_ELEMENT_XPATH, this.configuration.getNodeName()),
					WnpDLQJB);
		} catch (NullPointerException XWdB1n0i) {
			throw new ConfigurationException(String.format("Failed parsing the '%s' element in the '%s' element.",
					ConfigurationFileTagsV1.SERVICE_DESCRIPTION_ELEMENT_XPATH, this.configuration.getNodeName()),
					XWdB1n0i);
		}
	}

}