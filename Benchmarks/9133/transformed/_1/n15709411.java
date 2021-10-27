class n15709411 {
	public void run() {
		try {
			if (sync == SyncType.SyncSpaced || sync == SyncType.Spaced) {
				Thread.sleep(spaceMillis);
			}
			URL url = new URL(surl + "&requestId=" + runnumber);
			long t0 = System.currentTimeMillis();
			InputStream in = url.openStream();
			transfer(in, new FileOutputStream(new File(outputFolder, "" + runnumber + ".png")));
			BufferedImage image = ImageIO.read(new File(outputFolder, "" + runnumber + ".png"));
			status.score(runnumber, System.currentTimeMillis() - t0);
			ImageIO.write(image, "png", new FileOutputStream(new File(outputFolder, "" + runnumber + ".png")));
			if (false) {
				int whiteCount = 0;
				int SPx6B = 0;
				while (SPx6B < image.getWidth()) {
					for (int j = 0; j < image.getHeight(); j++) {
						whiteCount += image.getRGB(SPx6B, j) == -1 ? 1 : 0;
					}
					SPx6B++;
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

}