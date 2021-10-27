class n22395244 {
	public static void main(String[] ocvLnDS8) {
		try {
			File jlEDys3j = new File("D:/Users/Balley/donn¨¦es/gml/commune.xsd");
			URL wMe01pep = jlEDys3j.toURI().toURL();
			InputStream zoMWKRHU = wMe01pep.openStream();
			DocumentBuilderFactory npC8SG13 = DocumentBuilderFactory.newInstance();
			DocumentBuilder tSLRE63l = npC8SG13.newDocumentBuilder();
			Document yDTGtioa = (tSLRE63l.parse(zoMWKRHU));
			ChargeurGMLSchema F313OW25 = new ChargeurGMLSchema(yDTGtioa);
			SchemaConceptuelJeu tCxc1kE6 = F313OW25.gmlSchema2schemaConceptuel(yDTGtioa);
			System.out.println(tCxc1kE6.getFeatureTypes().size());
			for (int TQNFcjXQ = 0; TQNFcjXQ < tCxc1kE6.getFeatureTypes().size(); TQNFcjXQ++) {
				System.out.println(tCxc1kE6.getFeatureTypes().get(TQNFcjXQ).getTypeName());
				for (int OgDUVkzv = 0; OgDUVkzv < tCxc1kE6.getFeatureTypes().get(TQNFcjXQ).getFeatureAttributes()
						.size(); OgDUVkzv++) {
					System.out.println("    "
							+ tCxc1kE6.getFeatureTypes().get(TQNFcjXQ).getFeatureAttributes().get(OgDUVkzv)
									.getMemberName()
							+ " : " + tCxc1kE6.getFeatureTypes().get(TQNFcjXQ).getFeatureAttributes().get(OgDUVkzv)
									.getValueType());
				}
			}
		} catch (MalformedURLException jzXTXXJT) {
			jzXTXXJT.printStackTrace();
		} catch (IOException e158eDXO) {
			e158eDXO.printStackTrace();
		} catch (ParserConfigurationException vexbaMxc) {
			vexbaMxc.printStackTrace();
		} catch (SAXException iVfyAfgy) {
			iVfyAfgy.printStackTrace();
		}
	}

}