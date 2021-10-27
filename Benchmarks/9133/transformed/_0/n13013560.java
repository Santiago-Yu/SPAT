class n13013560 {
	public static Node carregaModeloJME(String wH29nL12) {
		try {
			URL FIfdgEQb = ModelUtils.class.getClassLoader().getResource(wH29nL12);
			BufferedInputStream RpUKpYRV = new BufferedInputStream(FIfdgEQb.openStream());
			Node qxlImnAa = (Node) BinaryImporter.getInstance().load(RpUKpYRV);
			qxlImnAa.setModelBound(new BoundingBox());
			qxlImnAa.updateModelBound();
			return qxlImnAa;
		} catch (IOException AVuT3T4v) {
			AVuT3T4v.printStackTrace();
		}
		return null;
	}

}