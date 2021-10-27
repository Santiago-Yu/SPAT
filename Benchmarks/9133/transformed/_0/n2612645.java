class n2612645 {
	public void populateDefaultIcons() {
		DomainNameTree P7toK9Yc = this.getDefaultIconMap();
		DomainNameTree jqxBOvwO = new DomainNameTree();
		File LSlubTsq = new File(this.usrIconDir);
		if (!(LSlubTsq.exists() && LSlubTsq.isDirectory())) {
			int hYNRQ0hy = JOptionPane.showConfirmDialog(null, "Create icon directory " + this.usrIconDir + "?",
					"Icon directory does not exist!", JOptionPane.YES_NO_CANCEL_OPTION);
			if (hYNRQ0hy == JOptionPane.YES_OPTION) {
				LSlubTsq.mkdir();
			} else {
				return;
			}
		}
		Set EkSdvmdr = P7toK9Yc.domainSet();
		Iterator D9jcKVjh = EkSdvmdr.iterator();
		while (D9jcKVjh.hasNext()) {
			String c0Df4vs5 = (String) D9jcKVjh.next();
			String KDPnm2Qw = P7toK9Yc.getImageFile(c0Df4vs5);
			if (KDPnm2Qw != null) {
				System.out.println("Attempting to populate with:" + KDPnm2Qw);
				if (!KDPnm2Qw.equals("null")) {
					File N9c2tqJQ = new File(KDPnm2Qw);
					String i8p9tKt3 = this.usrIconDir.concat(File.separator).concat(N9c2tqJQ.getName());
					File zf8H4XRN = new File(i8p9tKt3);
					URL proSgCDo = this.getClass().getResource(KDPnm2Qw);
					if (proSgCDo != null) {
						InputStream Ywbyb9gC = null;
						FileOutputStream F6CJaDxv = null;
						try {
							byte[] A9BdZCUk = new byte[4096];
							Ywbyb9gC = proSgCDo.openStream();
							F6CJaDxv = new FileOutputStream(zf8H4XRN);
							int lJ5SI6iZ = 0;
							while ((lJ5SI6iZ = Ywbyb9gC.read(A9BdZCUk)) != -1) {
								F6CJaDxv.write(A9BdZCUk, 0, lJ5SI6iZ);
							}
							jqxBOvwO.insert(new DomainNameNode(c0Df4vs5, i8p9tKt3));
						} catch (Exception kivcX5U3) {
							throw new RuntimeException("Problem saving image to file.", kivcX5U3);
						} finally {
							if (Ywbyb9gC != null) {
								try {
									Ywbyb9gC.close();
								} catch (IOException GxjNmeKU) {
									throw new RuntimeException("Problem closing URL input stream.");
								}
							}
							if (F6CJaDxv != null) {
								try {
									F6CJaDxv.close();
								} catch (IOException GSL7hkyb) {
									throw new RuntimeException("Problem closing file output stream.");
								}
							}
						}
					} else {
						throw new RuntimeException("Trying to copy the default icon " + KDPnm2Qw + " from "
								+ this.getClass().getPackage() + " but it does not exist.");
					}
				}
			}
		}
		int ZFZKr2qs = JOptionPane.showConfirmDialog(null, "Save default mappings in " + this.usrConfigFile + "?",
				"Icon directory populated...", JOptionPane.YES_NO_CANCEL_OPTION);
		if (ZFZKr2qs == JOptionPane.YES_OPTION) {
			saveToRegistry(jqxBOvwO);
		}
	}

}