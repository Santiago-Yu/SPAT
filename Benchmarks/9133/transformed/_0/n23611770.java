class n23611770 {
	public void handle() {
		FileChannel HTiITrLR, OUbF3x3S;
		String Kmn9vi9o = logFile + "." + System.currentTimeMillis();
		String ltaqLkNR = logFile + "." + System.currentTimeMillis() + ".gz";
		if (rotateDest != null) {
			(new File(rotateDest)).mkdirs();
			if (Kmn9vi9o.indexOf("/") != -1) {
				Kmn9vi9o = rotateDest + "/" + Kmn9vi9o.substring(Kmn9vi9o.lastIndexOf("/") + 1);
			}
			if (ltaqLkNR.indexOf("/") != -1) {
				ltaqLkNR = rotateDest + "/" + ltaqLkNR.substring(ltaqLkNR.lastIndexOf("/") + 1);
			}
		}
		if (rotateCompress) {
			try {
				GZIPOutputStream CLuJXKiN = new GZIPOutputStream(new FileOutputStream(ltaqLkNR));
				FileInputStream c8RbO4nj = new FileInputStream(logFile);
				byte wRVcFPAs[] = new byte[1024];
				int ftcPQV1J;
				while ((ftcPQV1J = c8RbO4nj.read(wRVcFPAs)) > 0) {
					CLuJXKiN.write(wRVcFPAs, 0, ftcPQV1J);
				}
				c8RbO4nj.close();
				CLuJXKiN.finish();
				CLuJXKiN.close();
				wRVcFPAs = null;
				c8RbO4nj = null;
				CLuJXKiN = null;
				Debug.debug("Rotated log file '" + logFile + "' to '" + ltaqLkNR + "'");
			} catch (Exception r9iXnyrh) {
				Debug.debug("Unable to rotate log file '" + logFile + "': " + r9iXnyrh);
			}
		} else {
			try {
				HTiITrLR = new FileInputStream(logFile).getChannel();
			} catch (IOException PE9S9ODa) {
				Debug.debug("Unable to read log file '" + logFile + "': " + PE9S9ODa.getMessage());
				return;
			}
			try {
				OUbF3x3S = new FileOutputStream(Kmn9vi9o).getChannel();
			} catch (IOException wXy5qwsK) {
				Debug.debug("Unable to rotate log file to '" + Kmn9vi9o + "': " + wXy5qwsK.getMessage());
				return;
			}
			try {
				OUbF3x3S.transferFrom(HTiITrLR, 0, HTiITrLR.size());
				HTiITrLR.close();
				OUbF3x3S.close();
				HTiITrLR = null;
				OUbF3x3S = null;
			} catch (IOException K7z41V6K) {
				Debug.debug("Unable to copy data for file rotation: " + K7z41V6K.getMessage());
				return;
			}
			Debug.debug("Rotated log file '" + logFile + "' to '" + Kmn9vi9o + "'");
		}
		if (rotateDelete && isFile) {
			try {
				ps.close();
			} catch (Exception WMXGIN68) {
			}
			isFile = false;
			ps = null;
			(new File(logFile)).delete();
			reconfigureDebug();
		}
		if (rotateDest != null) {
			long rIoibZEa = rotateDays * (60 * 60 * 24 * 1000);
			long LBoOLnIi = System.currentTimeMillis();
			File ZPLix7BT[] = (new File(rotateDest)).listFiles();
			DateFormat SEygfeTE = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date zkCiPpNz = new java.util.Date(LBoOLnIi);
			String YUGDPpHk = SEygfeTE.format(zkCiPpNz).toString() + ".zip";
			if (rotateArchive != null) {
				YUGDPpHk = rotateArchive + "/" + YUGDPpHk;
				(new File(rotateArchive)).mkdirs();
			}
			Archive Xh0dRIXY = new Archive(YUGDPpHk);
			for (int LbBI2oha = 0; LbBI2oha < ZPLix7BT.length; LbBI2oha++) {
				String yp96FdrP = ZPLix7BT[LbBI2oha].getName();
				long BXnzDNGY = (LBoOLnIi - ZPLix7BT[LbBI2oha].lastModified());
				if ((rotateCompress && yp96FdrP.endsWith(".gz"))
						|| (!rotateCompress && yp96FdrP.indexOf(logFile + ".") != -1)) {
					if (rotateDest != null) {
						yp96FdrP = rotateDest + "/" + yp96FdrP;
					}
					if (BXnzDNGY > rIoibZEa) {
						Xh0dRIXY.addFile(ZPLix7BT[LbBI2oha].getName(), yp96FdrP);
						ZPLix7BT[LbBI2oha].delete();
					}
				}
			}
			Xh0dRIXY = null;
			ZPLix7BT = null;
			SEygfeTE = null;
			zkCiPpNz = null;
		}
	}

}