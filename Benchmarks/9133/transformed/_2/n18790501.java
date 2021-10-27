class n18790501 {
	public void init(String file) {
		URL url = SoundFactory.class.getResource(file);
		try {
			JAXBContext context = JAXBContext.newInstance("elf.xml.sounds");
			Unmarshaller unmarshaller = context.createUnmarshaller();
			SoundsBaseType root = null;
			Object tmpobj = unmarshaller.unmarshal(url.openConnection().getInputStream());
			if (tmpobj instanceof JAXBElement<?>) {
				if (((JAXBElement<?>) tmpobj).getValue() instanceof SoundsBaseType) {
					root = (SoundsBaseType) ((JAXBElement<?>) tmpobj).getValue();
					addMusic("MENUSONG", root.getMenumusic().getMusicpath());
					List<SoundsMusicType> musiclist = root.getMusic();
					Iterator<SoundsMusicType> it = musiclist.iterator();
					for (; it.hasNext();) {
						SoundsMusicType smt = it.next();
						addMusic(smt.getMusicname(), smt.getMusicpath());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}