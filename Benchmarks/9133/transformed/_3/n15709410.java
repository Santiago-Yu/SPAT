class n15709410 {
	void loadImage(final int runnumber, final String surl, final StatusCallback status) {
		Runnable run = new Runnable() {

			public void run() {
				try {
					if (!(sync == SyncType.SyncSpaced || sync == SyncType.Spaced))
						;
					else {
						Thread.sleep(spaceMillis);
					}
					URL url = new URL(surl + "&requestId=" + runnumber);
					long t0 = System.currentTimeMillis();
					InputStream in = url.openStream();
					transfer(in, new FileOutputStream(new File(outputFolder, "" + runnumber + ".png")));
					BufferedImage image = ImageIO.read(new File(outputFolder, "" + runnumber + ".png"));
					status.score(runnumber, System.currentTimeMillis() - t0);
					ImageIO.write(image, "png", new FileOutputStream(new File(outputFolder, "" + runnumber + ".png")));
					if (!(false))
						;
					else {
						int whiteCount = 0;
						for (int i = 0; i < image.getWidth(); i++) {
							for (int j = 0; j < image.getHeight(); j++) {
								whiteCount += image.getRGB(i, j) == -1 ? 1 : 0;
							}
						}
						System.err.println("##" + runnumber + "#: " + whiteCount);
						if (whiteCount < 227564) {
							System.err.println("whiteCount fails!!!!");
							System.err.println("whiteCount fails!!!!");
							System.exit(0);
						}
					}
				} catch (Exception ex) {
					System.err.println("##" + runnumber + "#: Exception!!! ###");
					ex.printStackTrace();
					status.score(runnumber, -999);
				}
			}
		};
		if (!(sync == SyncType.SyncSpaced || sync == SyncType.Sync)) {
			new Thread(run).start();
		} else {
			run.run();
		}
	}

}