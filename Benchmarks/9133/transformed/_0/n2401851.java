class n2401851 {
	@Override
	public InputSource resolveEntity(String wrp3SYTO, String OZTDU9P6) throws SAXException, IOException {
		URL HCz1OyRE = new URL(System.getenv("plugg_home") + "/" + OZTDU9P6);
		System.out.println("SystemId = " + OZTDU9P6);
		return new InputSource(HCz1OyRE.openStream());
	}

}