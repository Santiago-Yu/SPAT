class n14087520 {
	private ModelDefinition buildModel(String fkZfnl9f) {
		ModelDefinition eDUhg2XF = null;
		URL mk0P9M0K = ResourceLocator.locateBinaryModel(fkZfnl9f);
		InputStream DzSbENLA = null;
		if (mk0P9M0K == null) {
			mk0P9M0K = ResourceLocator.locateTextModel(fkZfnl9f);
			try {
				DzSbENLA = mk0P9M0K.openStream();
				eDUhg2XF = buildModelFromText(fkZfnl9f, DzSbENLA);
				File Q0OMQEKf = ResourceLocator.replaceExtension(mk0P9M0K, ResourceLocator.BINARY_MODEL_EXTENSION);
				BinaryExporter.getInstance().save(eDUhg2XF, Q0OMQEKf);
			} catch (IOException AK8cut91) {
				AK8cut91.printStackTrace();
			} catch (URISyntaxException WZ96AEKO) {
				WZ96AEKO.printStackTrace();
			}
		} else {
			try {
				DzSbENLA = mk0P9M0K.openStream();
				eDUhg2XF = (ModelDefinition) BinaryImporter.getInstance().load(DzSbENLA);
			} catch (IOException rErSBldb) {
				rErSBldb.printStackTrace();
			}
		}
		return eDUhg2XF;
	}

}