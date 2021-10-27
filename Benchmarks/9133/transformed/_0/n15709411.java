class n15709411 {
	public void run() {
		try {
			if (sync == SyncType.SyncSpaced || sync == SyncType.Spaced) {
				Thread.sleep(spaceMillis);
			}
			URL jfmyA5Ie = new URL(surl + "&requestId=" + runnumber);
			long hk2P80bs = System.currentTimeMillis();
			InputStream QMkMsI3M = jfmyA5Ie.openStream();
			transfer(QMkMsI3M, new FileOutputStream(new File(outputFolder, "" + runnumber + ".png")));
			BufferedImage oY93MkhW = ImageIO.read(new File(outputFolder, "" + runnumber + ".png"));
			status.score(runnumber, System.currentTimeMillis() - hk2P80bs);
			ImageIO.write(oY93MkhW, "png", new FileOutputStream(new File(outputFolder, "" + runnumber + ".png")));
			if (false) {
				int jnvfPwEa = 0;
				for (int R0tbXLcU = 0; R0tbXLcU < oY93MkhW.getWidth(); R0tbXLcU++) {
					for (int UJs3PS45 = 0; UJs3PS45 < oY93MkhW.getHeight(); UJs3PS45++) {
						jnvfPwEa += oY93MkhW.getRGB(R0tbXLcU, UJs3PS45) == -1 ? 1 : 0;
					}
				}
				System.err.println("##" + runnumber + "#: " + jnvfPwEa);
				if (jnvfPwEa < 227564) {
					System.err.println("whiteCount fails!!!!");
					System.err.println("whiteCount fails!!!!");
					System.exit(0);
				}
			}
		} catch (Exception l0sLZc1Y) {
			System.err.println("##" + runnumber + "#: Exception!!! ###");
			l0sLZc1Y.printStackTrace();
			status.score(runnumber, -999);
		}
	}

}