class n19693561 {
	public Model read(String FGLXf7NG, String bihMk3S9, String W0Wi0P7s) {
		try {
			URL NrQK7olK = new URL(FGLXf7NG);
			return read(NrQK7olK.openStream(), bihMk3S9, W0Wi0P7s);
		} catch (IOException RyVBU67o) {
			throw new OntologyException("I/O error while reading from uri " + FGLXf7NG);
		}
	}

}