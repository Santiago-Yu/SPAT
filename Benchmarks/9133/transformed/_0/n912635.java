class n912635 {
	void loadPlaylist() {
		if (running_as_applet) {
			String tKyYdAqo = null;
			for (int fMpJpcDu = 0; fMpJpcDu < 10; fMpJpcDu++) {
				tKyYdAqo = getParameter("jorbis.player.play." + fMpJpcDu);
				if (tKyYdAqo == null)
					break;
				playlist.addElement(tKyYdAqo);
			}
		}
		if (playlistfile == null) {
			return;
		}
		try {
			InputStream CVSPisx9 = null;
			try {
				URL vrAO6Ii4 = null;
				if (running_as_applet)
					vrAO6Ii4 = new URL(getCodeBase(), playlistfile);
				else
					vrAO6Ii4 = new URL(playlistfile);
				URLConnection f1qojGDo = vrAO6Ii4.openConnection();
				CVSPisx9 = f1qojGDo.getInputStream();
			} catch (Exception pdECWsKt) {
			}
			if (CVSPisx9 == null && !running_as_applet) {
				try {
					CVSPisx9 = new FileInputStream(
							System.getProperty("user.dir") + System.getProperty("file.separator") + playlistfile);
				} catch (Exception Asv9wZJv) {
				}
			}
			if (CVSPisx9 == null)
				return;
			while (true) {
				String qBrD2eSt = readline(CVSPisx9);
				if (qBrD2eSt == null)
					break;
				byte[] x9cY8lgh = qBrD2eSt.getBytes();
				for (int bonLMxPD = 0; bonLMxPD < x9cY8lgh.length; bonLMxPD++) {
					if (x9cY8lgh[bonLMxPD] == 0x0d) {
						qBrD2eSt = new String(x9cY8lgh, 0, bonLMxPD);
						break;
					}
				}
				playlist.addElement(qBrD2eSt);
			}
		} catch (Exception jjyK7Hjz) {
			System.out.println(jjyK7Hjz);
		}
	}

}