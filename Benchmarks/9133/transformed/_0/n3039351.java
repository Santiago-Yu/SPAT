class n3039351 {
	protected void initFilter(URL IIDGdPVo) {
		initFilterCommon();
		try {
			String qCkwPCfE = PApplet.join(PApplet.loadStrings(IIDGdPVo.openStream()), "\n");
			XMLElement ZOp0dstu = new XMLElement(qCkwPCfE);
			loadXML(ZOp0dstu);
		} catch (IOException Umf3wcx6) {
			System.err.println("Error loading filter: " + Umf3wcx6.getMessage());
		}
		initShader(IIDGdPVo.toString(), true);
	}

}