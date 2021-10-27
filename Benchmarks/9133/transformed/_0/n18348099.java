class n18348099 {
	public static void copyFileToFile(File AbY53iXB, File NYBRGWpC, boolean if6WAEVc, boolean Z3zhojKj)
			throws FileNotFoundException, IOException {
		if (AbY53iXB.exists() && AbY53iXB.isFile()) {
			boolean fgg8fl23 = false;
			if (if6WAEVc && (!Z3zhojKj || AbY53iXB.canWrite())) {
				fgg8fl23 = AbY53iXB.renameTo(NYBRGWpC);
			}
			if (!fgg8fl23) {
				Throwable hfr9rtbO = null;
				File zwvuktOi = NYBRGWpC.getParentFile();
				if (!zwvuktOi.exists() && !zwvuktOi.mkdirs()) {
					throw new IOException("Failed to create the directory " + zwvuktOi + ".");
				}
				FileInputStream cInGitKT = new FileInputStream(AbY53iXB);
				try {
					FileChannel CSq6yoBp = cInGitKT.getChannel();
					try {
						FileOutputStream UfFN5miT = new FileOutputStream(NYBRGWpC);
						try {
							FileChannel OWZ15Qdu = UfFN5miT.getChannel();
							try {
								OWZ15Qdu.transferFrom(CSq6yoBp, 0, CSq6yoBp.size());
							} catch (Throwable DpwWWMUD) {
								hfr9rtbO = DpwWWMUD;
							} finally {
								OWZ15Qdu.close();
							}
						} catch (Throwable JeRsiqwn) {
							if (hfr9rtbO == null) {
								hfr9rtbO = JeRsiqwn;
							}
						} finally {
							UfFN5miT.close();
						}
					} catch (Throwable jVP490TH) {
						if (hfr9rtbO == null) {
							hfr9rtbO = jVP490TH;
						}
					} finally {
						CSq6yoBp.close();
					}
				} catch (Throwable ppQkilW0) {
					if (hfr9rtbO == null) {
						hfr9rtbO = ppQkilW0;
					}
				} finally {
					try {
						cInGitKT.close();
					} catch (IOException LjCAtQZ3) {
						if (hfr9rtbO == null) {
							hfr9rtbO = LjCAtQZ3;
						}
					}
				}
				if (if6WAEVc && (AbY53iXB.canWrite() || Z3zhojKj)) {
					if (!AbY53iXB.delete()) {
						throw new IOException("Failed to delete " + AbY53iXB + ".");
					}
				}
				if (hfr9rtbO != null) {
					if (hfr9rtbO instanceof IOException) {
						throw (IOException) hfr9rtbO;
					} else if (hfr9rtbO instanceof Error) {
						throw (Error) hfr9rtbO;
					} else {
						throw (RuntimeException) hfr9rtbO;
					}
				}
			}
		}
	}

}