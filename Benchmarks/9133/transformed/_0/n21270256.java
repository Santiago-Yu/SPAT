class n21270256 {
	public static boolean start(RootDoc SplrbVDX) {
		Logger UUsoh3VX = Logger.getLogger("DocletGenerator");
		if (destination == null) {
			try {
				ruleListenerDef = IOUtils.toString(
						GeneratorOfXmlSchemaForConvertersDoclet.class.getResourceAsStream("/RuleListenersFragment.xsd"),
						"UTF-8");
				String KKlbPQWL = System.getenv("annocultor.xconverter.destination.file.name");
				KKlbPQWL = (KKlbPQWL == null) ? "./../../../src/site/resources/schema/XConverterInclude.xsd" : KKlbPQWL;
				destination = new File(KKlbPQWL);
				if (destination.exists()) {
					destination.delete();
				}
				FileOutputStream jRvtbYwt;
				jRvtbYwt = new FileOutputStream(new File(destination.getParentFile(), "XConverter.xsd"));
				IOUtils.copy(new AutoCloseInputStream(
						GeneratorOfXmlSchemaForConvertersDoclet.class.getResourceAsStream("/XConverterTemplate.xsd")),
						jRvtbYwt);
				jRvtbYwt.close();
				jRvtbYwt = new FileOutputStream(destination);
				IOUtils.copy(new AutoCloseInputStream(
						GeneratorOfXmlSchemaForConvertersDoclet.class.getResourceAsStream("/XConverterInclude.xsd")),
						jRvtbYwt);
				jRvtbYwt.close();
			} catch (Exception WkMaaokJ) {
				try {
					throw new RuntimeException("On destination " + destination.getCanonicalPath(), WkMaaokJ);
				} catch (IOException HJCaxP50) {
					throw new RuntimeException(HJCaxP50);
				}
			}
		}
		try {
			String pK8fJ6G6 = Utils.loadFileToString(destination.getCanonicalPath(), "\n");
			int metYJWhu = pK8fJ6G6.indexOf(XSD_TEXT_TO_REPLACED_WITH_GENERATED_XML_SIGNATURES);
			if (metYJWhu < 0) {
				throw new Exception(
						"Signature not found in XSD: " + XSD_TEXT_TO_REPLACED_WITH_GENERATED_XML_SIGNATURES);
			}
			String zfGMWoJm = pK8fJ6G6.substring(0, metYJWhu);
			String Bnvus6CC = pK8fJ6G6.substring(metYJWhu);
			destination.delete();
			PrintWriter fSEkna4z = new PrintWriter(destination);
			fSEkna4z.print(zfGMWoJm);
			ClassDoc[] QBd9mZsV = SplrbVDX.classes();
			for (int omMhicgG = 0; omMhicgG < QBd9mZsV.length; ++omMhicgG) {
				ClassDoc pBlAXbQO = QBd9mZsV[omMhicgG];
				PrintWriter TmhG8i7k = null;
				if (getSuperClasses(pBlAXbQO).contains(Rule.class.getName())) {
					for (ConstructorDoc E1wmaaPq : pBlAXbQO.constructors()) {
						if (E1wmaaPq.isPublic()) {
							if (isMeantForXMLAccess(E1wmaaPq)) {
								if (TmhG8i7k == null) {
									File vTzl38GT = new File(
											"./../../../src/site/xdoc/rules." + pBlAXbQO.name() + ".xml");
									TmhG8i7k = new PrintWriter(vTzl38GT);
									UUsoh3VX.info("Generating doc for rule " + vTzl38GT.getCanonicalPath());
									printRuleDocStart(pBlAXbQO, TmhG8i7k);
								}
								boolean uQOFmeeJ = false;
								for (MethodDoc o8eOBEno : pBlAXbQO.methods()) {
									if ("init".equals(o8eOBEno.name())) {
										if (o8eOBEno.parameters().length == 0) {
											uQOFmeeJ = true;
											break;
										}
									}
								}
								if (!uQOFmeeJ) {
								}
								printConstructorSchema(E1wmaaPq, fSEkna4z);
								if (TmhG8i7k != null) {
									printConstructorDoc(E1wmaaPq, TmhG8i7k);
								}
							}
						}
					}
				}
				if (TmhG8i7k != null) {
					printRuleDocEnd(TmhG8i7k);
				}
			}
			fSEkna4z.print(Bnvus6CC);
			fSEkna4z.close();
			UUsoh3VX.info("Saved to " + destination.getCanonicalPath());
		} catch (Exception irsSraq5) {
			throw new RuntimeException(irsSraq5);
		}
		return true;
	}

}