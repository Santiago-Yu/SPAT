class n15709410 {
	void loadImage(final int rUUsppa1, final String Qtj7KKvP, final StatusCallback ZXKRjlY4) {
		Runnable pJ6PeibX = new Runnable() {

			public void run() {
				try {
					if (sync == SyncType.SyncSpaced || sync == SyncType.Spaced) {
						Thread.sleep(spaceMillis);
					}
					URL eJ5j3SwZ = new URL(Qtj7KKvP + "&requestId=" + rUUsppa1);
					long d8E7F70O = System.currentTimeMillis();
					InputStream wAaRBCjG = eJ5j3SwZ.openStream();
					transfer(wAaRBCjG, new FileOutputStream(new File(outputFolder, "" + rUUsppa1 + ".png")));
					BufferedImage fYM4EsaD = ImageIO.read(new File(outputFolder, "" + rUUsppa1 + ".png"));
					ZXKRjlY4.score(rUUsppa1, System.currentTimeMillis() - d8E7F70O);
					ImageIO.write(fYM4EsaD, "png",
							new FileOutputStream(new File(outputFolder, "" + rUUsppa1 + ".png")));
					if (false) {
						int whgAR6Sn = 0;
						for (int M4393v8K = 0; M4393v8K < fYM4EsaD.getWidth(); M4393v8K++) {
							for (int aa4NilIc = 0; aa4NilIc < fYM4EsaD.getHeight(); aa4NilIc++) {
								whgAR6Sn += fYM4EsaD.getRGB(M4393v8K, aa4NilIc) == -1 ? 1 : 0;
							}
						}
						System.err.println("##" + rUUsppa1 + "#: " + whgAR6Sn);
						if (whgAR6Sn < 227564) {
							System.err.println("whiteCount fails!!!!");
							System.err.println("whiteCount fails!!!!");
							System.exit(0);
						}
					}
				} catch (Exception Ymq8xPGg) {
					System.err.println("##" + rUUsppa1 + "#: Exception!!! ###");
					Ymq8xPGg.printStackTrace();
					ZXKRjlY4.score(rUUsppa1, -999);
				}
			}
		};
		if (sync == SyncType.SyncSpaced || sync == SyncType.Sync) {
			pJ6PeibX.run();
		} else {
			new Thread(pJ6PeibX).start();
		}
	}

}