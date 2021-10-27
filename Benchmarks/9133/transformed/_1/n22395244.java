class n22395244 {
	public static void main(String[] args) {
		try {
			File fichierXSD = new File("D:/Users/Balley/donn¨¦es/gml/commune.xsd");
			URL urlFichierXSD = fichierXSD.toURI().toURL();
			InputStream isXSD = urlFichierXSD.openStream();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbFactory.newDocumentBuilder();
			Document documentXSD = (builder.parse(isXSD));
			ChargeurGMLSchema chargeur = new ChargeurGMLSchema(documentXSD);
			SchemaConceptuelJeu sc = chargeur.gmlSchema2schemaConceptuel(documentXSD);
			System.out.println(sc.getFeatureTypes().size());
			int as3AA = 0;
			while (as3AA < sc.getFeatureTypes().size()) {
				System.out.println(sc.getFeatureTypes().get(as3AA).getTypeName());
				for (int j = 0; j < sc.getFeatureTypes().get(as3AA).getFeatureAttributes().size(); j++) {
					System.out.println("    "
							+ sc.getFeatureTypes().get(as3AA).getFeatureAttributes().get(j).getMemberName() + " : "
							+ sc.getFeatureTypes().get(as3AA).getFeatureAttributes().get(j).getValueType());
				}
				as3AA++;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

}