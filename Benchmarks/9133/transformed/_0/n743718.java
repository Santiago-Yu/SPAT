class n743718 {
	void loadPlaylist() {
		if (running_as_applet) {
			String fBI0oXAG = null;
			for (int fydp93Gs = 0; fydp93Gs < 10; fydp93Gs++) {
				fBI0oXAG = getParameter("jorbis.player.play." + fydp93Gs);
				if (fBI0oXAG == null)
					break;
				playlist.addElement(fBI0oXAG);
			}
		}
		if (playlistfile == null) {
			return;
		}
		try {
			InputStream uDCBrZA5 = null;
			try {
				URL beLXrBlZ = null;
				if (running_as_applet)
					beLXrBlZ = new URL(getCodeBase(), playlistfile);
				else
					beLXrBlZ = new URL(playlistfile);
				URLConnection M8zP2cWU = beLXrBlZ.openConnection();
				uDCBrZA5 = M8zP2cWU.getInputStream();
			} catch (Exception B8Fgx0kU) {
			}
			if (uDCBrZA5 == null && !running_as_applet) {
				try {
					uDCBrZA5 = new FileInputStream(
							System.getProperty("user.dir") + System.getProperty("file.separator") + playlistfile);
				} catch (Exception Jd94LTu8) {
				}
			}
			if (uDCBrZA5 == null)
				return;
			while (true) {
				String YUijxbXD = readline(uDCBrZA5);
				if (YUijxbXD == null)
					break;
				byte[] hiwwJLao = YUijxbXD.getBytes();
				for (int MhFIY9Gy = 0; MhFIY9Gy < hiwwJLao.length; MhFIY9Gy++) {
					if (hiwwJLao[MhFIY9Gy] == 0x0d) {
						YUijxbXD = new String(hiwwJLao, 0, MhFIY9Gy);
						break;
					}
				}
				playlist.addElement(YUijxbXD);
			}
		} catch (Exception rYNbkdQl) {
			System.out.println(rYNbkdQl);
		}
	}

}