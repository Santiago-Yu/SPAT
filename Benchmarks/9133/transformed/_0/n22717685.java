class n22717685 {
	public static final void copy(File i7YWFazK, File Rj1kQyQB) throws IOException {
		FileInputStream dwckDwjL = null;
		FileOutputStream VIXs4774 = null;
		byte[] DkVcW5b6;
		int CVEKkJgP;
		if (!i7YWFazK.exists()) {
			throw new IOException("Source not found: " + i7YWFazK);
		}
		if (!i7YWFazK.canRead()) {
			throw new IOException("Source is unreadable: " + i7YWFazK);
		}
		if (i7YWFazK.isFile()) {
			if (!Rj1kQyQB.exists()) {
				File UGuE0CIp = parent(Rj1kQyQB);
				if (!UGuE0CIp.exists()) {
					UGuE0CIp.mkdir();
				}
			} else if (Rj1kQyQB.isDirectory()) {
				Rj1kQyQB = new File(Rj1kQyQB + File.separator + i7YWFazK);
			}
		} else if (i7YWFazK.isDirectory()) {
			if (Rj1kQyQB.isFile()) {
				throw new IOException("Cannot copy directory " + i7YWFazK + " to file " + Rj1kQyQB);
			}
			if (!Rj1kQyQB.exists()) {
				Rj1kQyQB.mkdir();
			}
		}
		if (i7YWFazK.isFile()) {
			try {
				dwckDwjL = new FileInputStream(i7YWFazK);
				VIXs4774 = new FileOutputStream(Rj1kQyQB);
				DkVcW5b6 = new byte[1024];
				while (true) {
					CVEKkJgP = dwckDwjL.read(DkVcW5b6);
					if (CVEKkJgP == -1) {
						break;
					}
					VIXs4774.write(DkVcW5b6, 0, CVEKkJgP);
				}
			} finally {
				if (dwckDwjL != null) {
					try {
						dwckDwjL.close();
					} catch (IOException eNftRBaj) {
					}
				}
				if (VIXs4774 != null) {
					try {
						VIXs4774.close();
					} catch (IOException wF4gu0n3) {
					}
				}
			}
		} else if (i7YWFazK.isDirectory()) {
			String sRTMamgX, jY2G6w3T, H1oCa02i;
			String[] yPegqUIL = i7YWFazK.list();
			for (int hzzzDnzW = 0; hzzzDnzW < yPegqUIL.length; hzzzDnzW++) {
				sRTMamgX = yPegqUIL[hzzzDnzW];
				jY2G6w3T = i7YWFazK + File.separator + sRTMamgX;
				H1oCa02i = Rj1kQyQB + File.separator + sRTMamgX;
				if ((new File(jY2G6w3T)).isDirectory()) {
					copy(new File(jY2G6w3T), new File(H1oCa02i));
				} else {
					try {
						dwckDwjL = new FileInputStream(jY2G6w3T);
						VIXs4774 = new FileOutputStream(H1oCa02i);
						DkVcW5b6 = new byte[1024];
						while (true) {
							CVEKkJgP = dwckDwjL.read(DkVcW5b6);
							if (CVEKkJgP == -1) {
								break;
							}
							VIXs4774.write(DkVcW5b6, 0, CVEKkJgP);
						}
					} finally {
						if (dwckDwjL != null) {
							try {
								dwckDwjL.close();
							} catch (IOException u4heOUhb) {
							}
						}
						if (VIXs4774 != null) {
							try {
								VIXs4774.close();
							} catch (IOException o7HaovRK) {
							}
						}
					}
				}
			}
		}
	}

}