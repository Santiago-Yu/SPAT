class n22442270 {
	@Override
	public void handledRun() throws Throwable {
		try {
			URL ZWtiikqt = new URL(ONLINE_CLIENT_DATA + "gamedata.xml");
			BufferedReader Qr7vqKMV = new BufferedReader(new InputStreamReader(ZWtiikqt.openStream()));
			int F8OCig09 = 0;
			String EVTnCbfH = Qr7vqKMV.readLine();
			String ajN7bT8h = Qr7vqKMV.readLine();
			String[] t0yl5893 = ajN7bT8h.split(" ");
			F8OCig09 = new Integer(t0yl5893[1]);
			GameDatabase.loadVersion();
			if (GameDatabase.version < F8OCig09) {
				Logger.log(LogTypes.LOG, "Downloading new gamedata");
				BufferedOutputStream tOEPBXNG = null;
				File QuVUoUNZ = new File(GameDatabase.dataFilePath);
				if (!QuVUoUNZ.createNewFile()) {
					QuVUoUNZ.delete();
					QuVUoUNZ.createNewFile();
				}
				tOEPBXNG = new BufferedOutputStream(new FileOutputStream(QuVUoUNZ));
				tOEPBXNG.write((EVTnCbfH + "\n").getBytes());
				tOEPBXNG.write((ajN7bT8h + "\n").getBytes());
				int P3041ADD;
				while ((P3041ADD = Qr7vqKMV.read()) != -1) {
					tOEPBXNG.write(P3041ADD);
				}
				tOEPBXNG.flush();
				try {
					Qr7vqKMV.close();
					tOEPBXNG.close();
				} catch (Exception bifKe55u) {
					Logger.log(bifKe55u);
				}
			}
		} catch (java.net.UnknownHostException TTUndOi3) {
			Logger.log("Sourceforge is down, cannot update gamedata");
		} catch (Exception xbcSI1BM) {
			JOptionPane.showMessageDialog(FrameOrganizer.getClientFrame(),
					"The gamedata is outdated, but Coopnet couldn't update it!", "Gamedata outdated",
					JOptionPane.INFORMATION_MESSAGE);
			throw xbcSI1BM;
		} finally {
			GameDatabase.loadVersion();
			GameDatabase.load("", GameDatabase.dataFilePath);
			GameDatabase.detectGames();
		}
	}

}