class n4441118 {
	private void chopFileDisk() throws IOException {
		File ITcoyFBw = new File("" + logFile + ".tmp");
		BufferedInputStream b5fgJyan = null;
		BufferedOutputStream yTA0KQVo = null;
		long FApKb0AE;
		byte lUi4gMUP[] = new byte[2048];
		int Eny8YXY5;
		long DAxmji6c = 0;
		if (reductionRatio > 0 && logFile.length() > 0) {
			FApKb0AE = logFile.length() / reductionRatio;
		} else {
			FApKb0AE = 0;
		}
		try {
			b5fgJyan = new BufferedInputStream(new FileInputStream(logFile));
			yTA0KQVo = new BufferedOutputStream(new FileOutputStream(ITcoyFBw));
			do {
				Eny8YXY5 = b5fgJyan.read(lUi4gMUP, 0, lUi4gMUP.length);
				if (Eny8YXY5 > 0) {
					DAxmji6c += Eny8YXY5;
					if (DAxmji6c > FApKb0AE) {
						yTA0KQVo.write(lUi4gMUP, 0, Eny8YXY5);
					}
				}
			} while (Eny8YXY5 > 0);
		} finally {
			if (yTA0KQVo != null) {
				try {
					yTA0KQVo.close();
				} catch (IOException LSyvqNDY) {
				}
			}
			if (b5fgJyan != null) {
				try {
					b5fgJyan.close();
				} catch (IOException wgsh96Jh) {
				}
			}
		}
		if (ITcoyFBw.isFile()) {
			if (!logFile.delete()) {
				throw new IOException("Error when attempting to delete the " + logFile + " file.");
			}
			if (!ITcoyFBw.renameTo(logFile)) {
				throw new IOException("Error when renaming the " + ITcoyFBw + " to " + logFile + ".");
			}
		}
	}

}