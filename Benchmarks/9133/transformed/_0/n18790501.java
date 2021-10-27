class n18790501 {
	public void init(String vEtuTrAB) {
		URL i3aVnzyg = SoundFactory.class.getResource(vEtuTrAB);
		try {
			JAXBContext wnbrkKku = JAXBContext.newInstance("elf.xml.sounds");
			Unmarshaller WE9DvmRI = wnbrkKku.createUnmarshaller();
			SoundsBaseType M1tRRpkk = null;
			Object c9nvq0hQ = WE9DvmRI.unmarshal(i3aVnzyg.openConnection().getInputStream());
			if (c9nvq0hQ instanceof JAXBElement<?>) {
				if (((JAXBElement<?>) c9nvq0hQ).getValue() instanceof SoundsBaseType) {
					M1tRRpkk = (SoundsBaseType) ((JAXBElement<?>) c9nvq0hQ).getValue();
					addMusic("MENUSONG", M1tRRpkk.getMenumusic().getMusicpath());
					List<SoundsMusicType> uUwUAQdM = M1tRRpkk.getMusic();
					Iterator<SoundsMusicType> k9WezPbz = uUwUAQdM.iterator();
					while (k9WezPbz.hasNext()) {
						SoundsMusicType L0iwjdHa = k9WezPbz.next();
						addMusic(L0iwjdHa.getMusicname(), L0iwjdHa.getMusicpath());
					}
				}
			}
		} catch (Exception bRj7b7vi) {
			bRj7b7vi.printStackTrace();
		}
	}

}