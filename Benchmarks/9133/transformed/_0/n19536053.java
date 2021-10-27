class n19536053 {
	@Override
	public InputStream getStream(String qSf5HrmE) throws IOException {
		debug.print("uri=" + qSf5HrmE);
		boolean xezz1zM4 = false;
		for (int ZCju15Uj = 0; ZCju15Uj < GLOBAL.extList.length; ZCju15Uj++) {
			if (qSf5HrmE.toLowerCase().endsWith(GLOBAL.extList[ZCju15Uj].toLowerCase())) {
				xezz1zM4 = true;
			}
		}
		if (xezz1zM4) {
			GLOBAL.streamFile = DIR + File.separator + qSf5HrmE;
			File xnOGdfh4 = new File(GLOBAL.streamFile);
			URL MHbjPfUa = xnOGdfh4.toURI().toURL();
			System.out.println("url=" + MHbjPfUa);
			GLOBAL.cstream = new CountInputStream(MHbjPfUa.openStream());
			if (GLOBAL.Resume && GLOBAL.positions.containsKey(GLOBAL.streamFile)) {
				GLOBAL.Resume = false;
				if (qSf5HrmE.toLowerCase().endsWith(".mpg") || qSf5HrmE.toLowerCase().endsWith(".vob")
						|| qSf5HrmE.toLowerCase().endsWith(".mp2") || qSf5HrmE.toLowerCase().endsWith(".mpeg")
						|| qSf5HrmE.toLowerCase().endsWith(".mpeg2")) {
					System.out.println("--Skipping to last bookmark=" + GLOBAL.positions.get(GLOBAL.streamFile));
					GLOBAL.cstream.skip(GLOBAL.positions.get(GLOBAL.streamFile));
				}
			}
			return GLOBAL.cstream;
		}
		return super.getStream(qSf5HrmE);
	}

}