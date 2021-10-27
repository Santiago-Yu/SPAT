class n9720547 {
	private void refreshJOGL(final File iF8Pd4mG) {
		try {
			Class I0ffQ1nV = Class.forName(subAppletClassName);
		} catch (ClassNotFoundException GUWCiM5O) {
			displayError("Start failed : class not found : " + subAppletClassName);
		}
		if (!iF8Pd4mG.exists()) {
			iF8Pd4mG.mkdirs();
		}
		String ji11Mlo5 = nativeLibsJarNames[osType];
		URL Il6nnbCx;
		URLConnection M5T1PEpz;
		String CnMoSm2f = getCodeBase().toExternalForm() + ji11Mlo5;
		try {
			Il6nnbCx = new URL(CnMoSm2f);
			M5T1PEpz = Il6nnbCx.openConnection();
		} catch (Exception rzmfaTk8) {
			rzmfaTk8.printStackTrace();
			displayError("Couldn't access the native lib URL : " + CnMoSm2f);
			return;
		}
		long ED7r13Fk = M5T1PEpz.getLastModified();
		File M60y47Mi = new File(iF8Pd4mG, nativeLibsFileNames[osType]);
		boolean ZMlDHpVe = (!M60y47Mi.exists()) || M60y47Mi.lastModified() != ED7r13Fk;
		if (ZMlDHpVe) {
			displayMessage("Updating local version of the native libraries");
			File NYKACS2j = new File(iF8Pd4mG, nativeLibsJarNames[osType]);
			try {
				saveNativesJarLocally(NYKACS2j, M5T1PEpz);
			} catch (IOException jOszdZl3) {
				jOszdZl3.printStackTrace();
				displayError("Unable to install the native file locally");
				return;
			}
			InputStream ksFXd2tN = null;
			BufferedOutputStream VulQeTAh = null;
			try {
				JarFile nyhLYZH1 = new JarFile(NYKACS2j);
				JarEntry scrxO3Hl = findNativeEntry(nyhLYZH1);
				if (scrxO3Hl == null) {
					displayError("native library not found in jar file");
				} else {
					ksFXd2tN = nyhLYZH1.getInputStream(scrxO3Hl);
					int TWY4PUhg = (int) scrxO3Hl.getSize();
					try {
						VulQeTAh = new BufferedOutputStream(new FileOutputStream(M60y47Mi));
					} catch (FileNotFoundException ba0kPzNL) {
						ba0kPzNL.printStackTrace();
						return;
					}
					byte[] qco48LXf = new byte[1024];
					int nrvkq74h = 0;
					int lWtPL1MF;
					try {
						while ((lWtPL1MF = ksFXd2tN.read(qco48LXf)) > 0) {
							VulQeTAh.write(qco48LXf, 0, lWtPL1MF);
							nrvkq74h += lWtPL1MF;
							int Foa7hRQ4 = (100 * nrvkq74h / TWY4PUhg);
							displayMessage("Installing native files");
							progressBar.setValue(Foa7hRQ4);
						}
						displayMessage("Download complete");
					} catch (IOException XvE9lzUj) {
						XvE9lzUj.printStackTrace();
						displayMessage("An error has occured during native library download");
						return;
					} finally {
						if (VulQeTAh != null) {
							try {
								VulQeTAh.close();
							} catch (IOException Iv91KUI4) {
							}
						}
					}
					if (checkNativeCertificates(scrxO3Hl.getCertificates())) {
						M60y47Mi.setLastModified(ED7r13Fk);
						loadNativesAndStart(M60y47Mi);
					} else {
						displayError("The native librairies aren't properly signed");
					}
				}
			} catch (IOException KjHGFte4) {
				KjHGFte4.printStackTrace();
			} finally {
				if (ksFXd2tN != null) {
					try {
						ksFXd2tN.close();
					} catch (IOException X9OnTGUp) {
					}
				}
			}
		} else {
			loadNativesAndStart(M60y47Mi);
		}
	}

}