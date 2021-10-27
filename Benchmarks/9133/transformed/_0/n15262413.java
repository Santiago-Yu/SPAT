class n15262413 {
	void loadPlaylist() {
		if (running_as_applet) {
			String mDIXZSVz = null;
			for (int LthMvhEL = 0; LthMvhEL < 10; LthMvhEL++) {
				mDIXZSVz = getParameter("jorbis.player.play." + LthMvhEL);
				if (mDIXZSVz == null) {
					break;
				}
				playlist.addElement(mDIXZSVz);
			}
		}
		if (playlistfile == null) {
			return;
		}
		try {
			InputStream oM5ICg68 = null;
			try {
				URL BWUOvgBA = null;
				if (running_as_applet) {
					BWUOvgBA = new URL(getCodeBase(), playlistfile);
				} else {
					BWUOvgBA = new URL(playlistfile);
				}
				URLConnection BkxXZc8u = BWUOvgBA.openConnection();
				oM5ICg68 = BkxXZc8u.getInputStream();
			} catch (Exception MAoFRh9D) {
			}
			if (oM5ICg68 == null && !running_as_applet) {
				try {
					oM5ICg68 = new FileInputStream(
							System.getProperty("user.dir") + System.getProperty("file.separator") + playlistfile);
				} catch (Exception E8M28d6k) {
				}
			}
			if (oM5ICg68 == null) {
				return;
			}
			while (true) {
				String EDwehMt7 = readline(oM5ICg68);
				if (EDwehMt7 == null) {
					break;
				}
				byte[] xnEU2mrD = EDwehMt7.getBytes();
				for (int RLeUdtPi = 0; RLeUdtPi < xnEU2mrD.length; RLeUdtPi++) {
					if (xnEU2mrD[RLeUdtPi] == 0x0d) {
						EDwehMt7 = new String(xnEU2mrD, 0, RLeUdtPi);
						break;
					}
				}
				playlist.addElement(EDwehMt7);
			}
		} catch (Exception S8yEkZVi) {
			System.out.println(S8yEkZVi);
		}
	}

}