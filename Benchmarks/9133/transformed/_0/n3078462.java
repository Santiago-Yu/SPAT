class n3078462 {
	public void handle() {
		FileChannel elpZjZcc, B9HhvYZJ;
		String Yo8uvkeX = databaseName + ".script." + System.currentTimeMillis();
		String axjFQyol = databaseName + ".script." + System.currentTimeMillis() + ".gz";
		if (rotateDest != null) {
			(new File(rotateDest)).mkdirs();
			if (Yo8uvkeX.indexOf("/") != -1) {
				Yo8uvkeX = rotateDest + "/" + Yo8uvkeX.substring(Yo8uvkeX.lastIndexOf("/") + 1);
			}
			if (axjFQyol.indexOf("/") != -1) {
				axjFQyol = rotateDest + "/" + axjFQyol.substring(axjFQyol.lastIndexOf("/") + 1);
			}
		}
		if (rotateCompress) {
			try {
				GZIPOutputStream x9s62Wr1 = new GZIPOutputStream(new FileOutputStream(axjFQyol));
				FileInputStream PYjvJ6EO = new FileInputStream(databaseName + ".script");
				byte FAhlJdQc[] = new byte[1024];
				int xIqRaMgH;
				while ((xIqRaMgH = PYjvJ6EO.read(FAhlJdQc)) > 0) {
					x9s62Wr1.write(FAhlJdQc, 0, xIqRaMgH);
				}
				PYjvJ6EO.close();
				x9s62Wr1.finish();
				x9s62Wr1.close();
				FAhlJdQc = null;
				PYjvJ6EO = null;
				x9s62Wr1 = null;
				Debug.debug("Rotated database file '" + databaseName + ".script' to '" + axjFQyol + "'");
			} catch (Exception SKndbt1r) {
				Debug.debug("Unable to rotate database file '" + databaseName + ".script': " + SKndbt1r);
			}
		} else {
			try {
				elpZjZcc = new FileInputStream(databaseName + ".script").getChannel();
			} catch (IOException RhcbfUji) {
				Debug.debug("Unable to read file '" + databaseName + ".script' for database rotation.");
				return;
			}
			try {
				B9HhvYZJ = new FileOutputStream(Yo8uvkeX).getChannel();
			} catch (IOException n0UhBD4t) {
				Debug.debug("Unable to rotate file to '" + Yo8uvkeX + "': " + n0UhBD4t.getMessage());
				return;
			}
			try {
				B9HhvYZJ.transferFrom(elpZjZcc, 0, elpZjZcc.size());
				elpZjZcc.close();
				B9HhvYZJ.close();
				elpZjZcc = null;
				B9HhvYZJ = null;
			} catch (IOException BPN9Sx57) {
				Debug.debug("Unable to copy data for file rotation: " + BPN9Sx57.getMessage());
				return;
			}
			Debug.debug("Rotated database file '" + databaseName + ".script' to '" + Yo8uvkeX + "'");
		}
		if (rotateDest != null) {
			long SHsPqKMg = rotateDays * (60 * 60 * 24 * 1000);
			long BF9LREdJ = System.currentTimeMillis();
			File Zw2771jN[] = (new File(rotateDest)).listFiles();
			DateFormat fxSr72GH = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date BAgob0pH = new java.util.Date(BF9LREdJ);
			String GsGlNs14 = fxSr72GH.format(BAgob0pH).toString() + ".zip";
			if (rotateArchive != null) {
				GsGlNs14 = rotateArchive + "/" + GsGlNs14;
				(new File(rotateArchive)).mkdirs();
			}
			Archive Kt5lTyHb = new Archive(GsGlNs14);
			for (int twFsMdK5 = 0; twFsMdK5 < Zw2771jN.length; twFsMdK5++) {
				String zyu5m4L0 = Zw2771jN[twFsMdK5].getName();
				long iHnULYP8 = (BF9LREdJ - Zw2771jN[twFsMdK5].lastModified());
				if ((rotateCompress && zyu5m4L0.endsWith(".gz"))
						|| (!rotateCompress && zyu5m4L0.indexOf(".script.") != -1)) {
					if (rotateDest != null) {
						zyu5m4L0 = rotateDest + "/" + zyu5m4L0;
					}
					if (iHnULYP8 > SHsPqKMg) {
						Kt5lTyHb.addFile(Zw2771jN[twFsMdK5].getName(), zyu5m4L0);
						Zw2771jN[twFsMdK5].delete();
					}
				}
			}
			Kt5lTyHb = null;
			Zw2771jN = null;
			fxSr72GH = null;
			BAgob0pH = null;
		}
	}

}