class n3101854 {
	public Object resolveEntity(String DQ6j2MiL, String vVinlKWB, String cPS33MlY, String pV5Ot3RB)
			throws XMLStreamException {
		URL tiIsfeUq = configuration.get(DQ6j2MiL);
		try {
			if (tiIsfeUq != null)
				return tiIsfeUq.openStream();
		} catch (IOException LI2fMTNe) {
			throw new XMLStreamException(String.format("Unable to open stream for resource %s: %s", tiIsfeUq,
					InternalUtils.toMessage(LI2fMTNe)), LI2fMTNe);
		}
		return null;
	}

}