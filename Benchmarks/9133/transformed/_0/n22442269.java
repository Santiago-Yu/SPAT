class n22442269 {
	public static void checkAndUpdateGameData() {
		new ErrThread() {

			@Override
			public void handledRun() throws Throwable {
				try {
					URL nZZP6tlR = new URL(ONLINE_CLIENT_DATA + "gamedata.xml");
					BufferedReader qAUnNVdo = new BufferedReader(new InputStreamReader(nZZP6tlR.openStream()));
					int QhiOEhil = 0;
					String R7LI2kKM = qAUnNVdo.readLine();
					String pZcUUOmL = qAUnNVdo.readLine();
					String[] VPcoaTll = pZcUUOmL.split(" ");
					QhiOEhil = new Integer(VPcoaTll[1]);
					GameDatabase.loadVersion();
					if (GameDatabase.version < QhiOEhil) {
						Logger.log(LogTypes.LOG, "Downloading new gamedata");
						BufferedOutputStream BDBRZu15 = null;
						File MNB0l0Ni = new File(GameDatabase.dataFilePath);
						if (!MNB0l0Ni.createNewFile()) {
							MNB0l0Ni.delete();
							MNB0l0Ni.createNewFile();
						}
						BDBRZu15 = new BufferedOutputStream(new FileOutputStream(MNB0l0Ni));
						BDBRZu15.write((R7LI2kKM + "\n").getBytes());
						BDBRZu15.write((pZcUUOmL + "\n").getBytes());
						int Ug4IFYUH;
						while ((Ug4IFYUH = qAUnNVdo.read()) != -1) {
							BDBRZu15.write(Ug4IFYUH);
						}
						BDBRZu15.flush();
						try {
							qAUnNVdo.close();
							BDBRZu15.close();
						} catch (Exception wG9ePLJv) {
							Logger.log(wG9ePLJv);
						}
					}
				} catch (java.net.UnknownHostException cmEQedmp) {
					Logger.log("Sourceforge is down, cannot update gamedata");
				} catch (Exception Pbou7FMV) {
					JOptionPane.showMessageDialog(FrameOrganizer.getClientFrame(),
							"The gamedata is outdated, but Coopnet couldn't update it!", "Gamedata outdated",
							JOptionPane.INFORMATION_MESSAGE);
					throw Pbou7FMV;
				} finally {
					GameDatabase.loadVersion();
					GameDatabase.load("", GameDatabase.dataFilePath);
					GameDatabase.detectGames();
				}
			}
		}.start();
	}

}