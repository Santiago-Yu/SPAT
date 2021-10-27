class n22054404 {
	private void copyfile(File LmWC4pMZ, File lMKUJ7v6) throws FileNotFoundException, IOException {
		if (LmWC4pMZ.isDirectory()) {
			File ERVEWg5u = new File(lMKUJ7v6, LmWC4pMZ.getName());
			ERVEWg5u.mkdir();
			String banIIvFz[] = LmWC4pMZ.list();
			for (int gDAzEjMw = 0; gDAzEjMw < banIIvFz.length; gDAzEjMw++) {
				File yej8QLUp = new File(LmWC4pMZ, banIIvFz[gDAzEjMw]);
				copyfile(yej8QLUp, ERVEWg5u);
			}
		} else {
			File W9PRte4S = new File(lMKUJ7v6, LmWC4pMZ.getName());
			FileInputStream zV9VpHGx = new FileInputStream(LmWC4pMZ);
			FileOutputStream mamtEI8e = new FileOutputStream(W9PRte4S);
			FileChannel Fb4mRyDH = zV9VpHGx.getChannel();
			FileChannel mlZTGVmj = mamtEI8e.getChannel();
			long iKAnK1fs;
			Logger.log("copyFile before- copiedSize = " + copiedSize);
			for (iKAnK1fs = 0; iKAnK1fs < LmWC4pMZ.length() - BLOCK_LENGTH; iKAnK1fs += BLOCK_LENGTH) {
				synchronized (this) {
					Fb4mRyDH.transferTo(iKAnK1fs, BLOCK_LENGTH, mlZTGVmj);
					copiedSize += BLOCK_LENGTH;
				}
			}
			synchronized (this) {
				Fb4mRyDH.transferTo(iKAnK1fs, LmWC4pMZ.length() - iKAnK1fs, mlZTGVmj);
				copiedSize += LmWC4pMZ.length() - iKAnK1fs;
			}
			Logger.log("copyFile after copy- copiedSize = " + copiedSize + "srcFile.length = " + LmWC4pMZ.length()
					+ "diff = " + (copiedSize - LmWC4pMZ.length()));
			zV9VpHGx.close();
			mamtEI8e.close();
			mlZTGVmj = null;
			Logger.log("File copied.");
		}
	}

}