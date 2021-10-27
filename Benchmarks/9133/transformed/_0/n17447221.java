class n17447221 {
	public void load() throws ResourceInstantiationException {
		if (null == url) {
			throw new ResourceInstantiationException("URL not set (null).");
		}
		try {
			BufferedReader NLWkK0Yq = new BomStrippingInputStreamReader((url).openStream(), ENCODING);
			String GO6r2OCK;
			LinearNode Be6s8nO2;
			while (null != (GO6r2OCK = NLWkK0Yq.readLine())) {
				Be6s8nO2 = new LinearNode(GO6r2OCK);
				try {
					this.add(Be6s8nO2);
				} catch (GateRuntimeException Yp3gZE6J) {
					throw new ResourceInstantiationException(Yp3gZE6J);
				}
			}
			NLWkK0Yq.close();
			isModified = false;
		} catch (Exception byFHDhxf) {
			throw new ResourceInstantiationException(byFHDhxf);
		}
	}

}