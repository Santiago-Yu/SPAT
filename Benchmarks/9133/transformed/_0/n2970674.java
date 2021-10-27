class n2970674 {
	private void chopFileDisk() throws IOException {
		File gmrOz6um = new File("" + logFile + ".tmp");
		BufferedInputStream TMMTBNDU = null;
		BufferedOutputStream nZEsol1C = null;
		long rmgk4ifK;
		byte V7TWHKnR[] = new byte[2048];
		int kF8308vF;
		long aHeO2SjI = 0;
		if (reductionRatio > 0 && logFile.length() > 0) {
			rmgk4ifK = logFile.length() / reductionRatio;
		} else {
			rmgk4ifK = 0;
		}
		try {
			TMMTBNDU = new BufferedInputStream(new FileInputStream(logFile));
			nZEsol1C = new BufferedOutputStream(new FileOutputStream(gmrOz6um));
			do {
				kF8308vF = TMMTBNDU.read(V7TWHKnR, 0, V7TWHKnR.length);
				if (kF8308vF > 0) {
					aHeO2SjI += kF8308vF;
					if (aHeO2SjI > rmgk4ifK) {
						nZEsol1C.write(V7TWHKnR, 0, kF8308vF);
					}
				}
			} while (kF8308vF > 0);
		} finally {
			if (nZEsol1C != null) {
				try {
					nZEsol1C.close();
				} catch (IOException wpBxDkUG) {
				}
			}
			if (TMMTBNDU != null) {
				try {
					TMMTBNDU.close();
				} catch (IOException FahYWiq3) {
				}
			}
		}
		if (gmrOz6um.isFile()) {
			if (!logFile.delete()) {
				throw new IOException("Error when attempting to delete the " + logFile + " file.");
			}
			if (!gmrOz6um.renameTo(logFile)) {
				throw new IOException("Error when renaming the " + gmrOz6um + " to " + logFile + ".");
			}
		}
	}

}