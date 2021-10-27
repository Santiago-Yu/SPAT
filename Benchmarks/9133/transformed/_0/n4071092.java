class n4071092 {
	public static String harvestForUser(Node iqNUfN4r, String tu5pVxQB, Boolean Gi0yvS6v) {
		FTPClient iTyBe4Ra = new FTPClient();
		OutputStream gfXXk14j = null;
		Calendar oYahldy5 = Calendar.getInstance();
		oYahldy5.set(Calendar.DAY_OF_MONTH, oYahldy5.get(Calendar.DAY_OF_MONTH) - 1);
		Date ZA09wsW8 = oYahldy5.getTime();
		String OZ1RTI2C = "";
		try {
			Session MBsrda27 = CustomSystemSession.create(r);
			iTyBe4Ra.connect(ftpHostname);
			iTyBe4Ra.login(ftpUsername, ftpPassword);
			FTPFile[] G6WDgwBU = iTyBe4Ra.listFiles();
			if (G6WDgwBU != null) {
				for (FTPFile M6GPKqLq : G6WDgwBU) {
					String f5NVzib7 = M6GPKqLq.getName();
					if (tu5pVxQB.equals(f5NVzib7)) {
						OZ1RTI2C += "Found account " + f5NVzib7 + ".\n";
						iTyBe4Ra.changeWorkingDirectory("/" + f5NVzib7 + "/");
						FTPFile[] Pr2iaTJP = iTyBe4Ra.listFiles();
						if (Pr2iaTJP != null && iqNUfN4r != null) {
							for (FTPFile lCPPhFbN : Pr2iaTJP) {
								String XHY6okwk = lCPPhFbN.getName();
								OZ1RTI2C += "Exploring " + f5NVzib7 + "/" + XHY6okwk + ".\n";
								iTyBe4Ra.changeWorkingDirectory("/" + f5NVzib7 + "/" + XHY6okwk + "/");
								FTPFile[] QP78vs0r = iTyBe4Ra.listFiles();
								if (QP78vs0r != null) {
									for (FTPFile hevKj882 : QP78vs0r) {
										String ZYr4dslt = hevKj882.getName();
										OZ1RTI2C += "Exploring " + f5NVzib7 + "/" + XHY6okwk + "/" + ZYr4dslt + ".\n";
										iTyBe4Ra.changeWorkingDirectory(
												"/" + f5NVzib7 + "/" + XHY6okwk + "/" + ZYr4dslt + "/");
										Date mMawgX2W = hevKj882.getTimestamp().getTime();
										if (mMawgX2W.after(ZA09wsW8) || Gi0yvS6v) {
											FTPFile[] vEKxoY2Y = iTyBe4Ra.listFiles();
											if (vEKxoY2Y != null) {
												for (FTPFile Lh5Vorpy : vEKxoY2Y) {
													OZ1RTI2C += processImage(f5NVzib7, XHY6okwk, ZYr4dslt, mMawgX2W,
															Lh5Vorpy, iTyBe4Ra, iqNUfN4r, MBsrda27);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			iTyBe4Ra.logout();
		} catch (IOException fRuN7nQA) {
			log.info("Error communicating with FTP server.");
			log.error("Error communicating with FTP server.", fRuN7nQA);
			fRuN7nQA.printStackTrace();
		} catch (RepositoryException pfe6GUiX) {
			log.info("Error communicating with repository.");
			log.error("Error communicating with repository.", pfe6GUiX);
			pfe6GUiX.printStackTrace();
		} finally {
			IOUtils.closeQuietly(gfXXk14j);
			try {
				iTyBe4Ra.disconnect();
			} catch (IOException R61Vu9aV) {
				log.error("Problem disconnecting from FTP server", R61Vu9aV);
			}
		}
		return OZ1RTI2C;
	}

}