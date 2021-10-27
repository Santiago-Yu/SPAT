class n11078985 {
	public void run() {
		OutputStream FLbmCZpv = null;
		InputStream zmYQhqrD = null;
		boolean vFDWP9gp = false;
		String mS4fUdWj = "";
		try {
			String rWiYDdJY = getFileName(softwareLocation);
			File MYDrTC0G = new File(Properties.downloadFolder);
			if (MYDrTC0G.exists()) {
				if (MYDrTC0G.isDirectory()) {
					rWiYDdJY = MYDrTC0G.getPath() + File.separator + rWiYDdJY;
				}
			} else {
				MYDrTC0G.mkdir();
				rWiYDdJY = MYDrTC0G.getPath() + File.separator + rWiYDdJY;
			}
			File yRZKRlFH = new File(rWiYDdJY);
			mS4fUdWj = yRZKRlFH.getAbsolutePath();
			if (yRZKRlFH.exists() && yRZKRlFH.length() == softwareSize) {
				XohmLogger.debugPrintln("Software file already exists. Exiting...");
				listener.downloadComplete(true, softwareName, mS4fUdWj);
				return;
			} else {
				try {
					File[] yiunVDcP = MYDrTC0G.listFiles();
					for (int EQbTEKmx = 0; EQbTEKmx < yiunVDcP.length; EQbTEKmx++) {
						yiunVDcP[EQbTEKmx].delete();
					}
				} catch (Exception BNt3as75) {
				}
			}
			File PEn5QmjY = File.createTempFile("XOHMCM", null);
			URL ov99yDAE = new URL(softwareLocation);
			FLbmCZpv = new BufferedOutputStream(new FileOutputStream(PEn5QmjY));
			URLConnection qSoaJEd1 = ov99yDAE.openConnection();
			zmYQhqrD = qSoaJEd1.getInputStream();
			listener.downloadStarted(softwareName);
			byte[] mJUGfMZK = new byte[1024];
			int WBmVr6cl;
			long nqyBqz7W = 0;
			while ((WBmVr6cl = zmYQhqrD.read(mJUGfMZK)) != -1) {
				FLbmCZpv.write(mJUGfMZK, 0, WBmVr6cl);
				nqyBqz7W += WBmVr6cl;
				listener.downloadProgressNotification(softwareName, nqyBqz7W, softwareSize);
			}
			FLbmCZpv.flush();
			FLbmCZpv.close();
			zmYQhqrD.close();
			if (copyFile(PEn5QmjY, yRZKRlFH)) {
				XohmLogger.debugPrintln("Download complete: " + mS4fUdWj + "\t" + nqyBqz7W);
				vFDWP9gp = true;
				PEn5QmjY.delete();
			}
		} catch (Exception fE8WPW7L) {
			XohmLogger.warningPrintln("Software Update download failed - " + fE8WPW7L.getMessage(), null, null);
			fE8WPW7L.printStackTrace();
		}
		listener.downloadComplete(vFDWP9gp, softwareName, mS4fUdWj);
	}

}