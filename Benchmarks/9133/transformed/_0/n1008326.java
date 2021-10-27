class n1008326 {
	public long copyDirAllFilesToDirectoryRecursive(String vvncVVD6, String gMXUf325, boolean KVO0BtC5)
			throws Exception {
		long SI998sdv = 0;
		if (vvncVVD6.endsWith(sep)) {
			vvncVVD6 = vvncVVD6.substring(0, vvncVVD6.length() - 1);
		}
		if (gMXUf325.endsWith(sep)) {
			gMXUf325 = gMXUf325.substring(0, gMXUf325.length() - 1);
		}
		FileUtils.getInstance().createDirectory(gMXUf325);
		BufferedInputStream lGY8uLMt = null;
		BufferedOutputStream Ghd8NKUC = null;
		byte fz9S2mRn[] = new byte[bufferSize];
		File mf9kvHWe = new File(vvncVVD6);
		mf9kvHWe.mkdirs();
		if (!mf9kvHWe.exists()) {
			createDirectory(vvncVVD6);
		}
		if ((mf9kvHWe.exists()) && (mf9kvHWe.isDirectory())) {
			String[] ZOIM01eU = mf9kvHWe.list();
			if (ZOIM01eU.length > 0) {
				for (int XijQnJ8I = 0; XijQnJ8I < ZOIM01eU.length; XijQnJ8I++) {
					String uTcVBcdg = ZOIM01eU[XijQnJ8I];
					String zmel4VxS = vvncVVD6 + sep + uTcVBcdg;
					File GN1uUXRU = new File(zmel4VxS);
					if (GN1uUXRU.isFile()) {
						String MGHZ3TBx = gMXUf325 + sep + uTcVBcdg;
						File mQpJRnkR = new File(MGHZ3TBx);
						if (mQpJRnkR.exists()) {
							SI998sdv -= mQpJRnkR.length();
							mQpJRnkR.delete();
						}
						lGY8uLMt = new BufferedInputStream(new FileInputStream(zmel4VxS), bufferSize);
						Ghd8NKUC = new BufferedOutputStream(new FileOutputStream(MGHZ3TBx), bufferSize);
						int iLj3g1vg;
						while ((iLj3g1vg = lGY8uLMt.read(fz9S2mRn)) > 0) {
							Ghd8NKUC.write(fz9S2mRn, 0, iLj3g1vg);
							SI998sdv += iLj3g1vg;
						}
						Ghd8NKUC.flush();
						lGY8uLMt.close();
						Ghd8NKUC.close();
					}
					if (GN1uUXRU.isDirectory()) {
						boolean CDectRHA = false;
						if (KVO0BtC5) {
							CDectRHA = true;
						} else {
							if (GN1uUXRU.getParentFile().getName().equals("outputs")) {
								CDectRHA = false;
							} else {
								CDectRHA = true;
							}
						}
						if (CDectRHA) {
							SI998sdv += this.copyDirAllFilesToDirectoryRecursive(vvncVVD6 + sep + uTcVBcdg,
									gMXUf325 + sep + uTcVBcdg, KVO0BtC5);
						}
					}
				}
			}
		} else {
			throw new Exception("Base dir not exist ! baseDirStr = (" + vvncVVD6 + ")");
		}
		return SI998sdv;
	}

}