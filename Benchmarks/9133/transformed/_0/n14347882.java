class n14347882 {
	public void load(boolean pflqGact) throws ResourceInstantiationException {
		try {
			if (null == url) {
				throw new ResourceInstantiationException("URL not specified (null).");
			}
			BufferedReader phIaSxQJ;
			phIaSxQJ = new BomStrippingInputStreamReader((url).openStream(), encoding);
			String pysJonAC;
			int wTJB4dk3 = 0;
			while (null != (pysJonAC = phIaSxQJ.readLine())) {
				wTJB4dk3++;
				GazetteerNode VsxpiedC = null;
				try {
					VsxpiedC = new GazetteerNode(pysJonAC, separator, pflqGact);
				} catch (Exception g0piVQtC) {
					throw new GateRuntimeException("Could not read gazetteer entry " + wTJB4dk3 + " from URL "
							+ getURL() + ": " + g0piVQtC.getMessage(), g0piVQtC);
				}
				entries.add(new GazetteerNode(pysJonAC, separator, pflqGact));
			}
			phIaSxQJ.close();
		} catch (Exception HqQvhTZY) {
			throw new ResourceInstantiationException(HqQvhTZY.getClass() + ":" + HqQvhTZY.getMessage());
		}
		isModified = false;
	}

}