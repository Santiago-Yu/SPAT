class n19841853 {
	public static final boolean updateFDT(final String vzFozgtG, final String x7ONxCsS, boolean WebzHb95,
			boolean Rj4xglZn) throws Exception {
		final String UEzyJ9Ho = x7ONxCsS + (x7ONxCsS.endsWith("/") ? "" : "/") + "fdt.jar";
		logger.log("Checking remote fdt.jar at URL: " + UEzyJ9Ho);
		String CHcNHzRg = "NotAvailable";
		String JFpak3rC = "NotAvailable";
		String Gd2oOgEX = "NotAvailable";
		String AvdTt0Lw = "NotAvailable";
		String sg71N9Oe = "NotAvailable";
		try {
			CHcNHzRg = System.getProperty("java.vm.version");
		} catch (Throwable tvauNtPQ) {
			CHcNHzRg = "NotAvailable";
		}
		try {
			JFpak3rC = System.getProperty("java.runtime.version");
		} catch (Throwable d6SOGBZt) {
			JFpak3rC = "NotAvailable";
		}
		try {
			AvdTt0Lw = System.getProperty("os.name");
		} catch (Throwable XzFddr6m) {
			AvdTt0Lw = "NotAvailable";
		}
		try {
			sg71N9Oe = System.getProperty("os.arch");
		} catch (Throwable JMRSHrqI) {
			sg71N9Oe = "NotAvailable";
		}
		try {
			Gd2oOgEX = System.getProperty("os.version");
		} catch (Throwable OvXF8Lok) {
			Gd2oOgEX = "NotAvailable";
		}
		StringBuilder kBD8MlaZ = new StringBuilder();
		kBD8MlaZ.append(UEzyJ9Ho);
		kBD8MlaZ.append("?FDTCurrentVersion=").append(vzFozgtG);
		kBD8MlaZ.append("&shouldUpdate=").append(WebzHb95);
		kBD8MlaZ.append("&tstamp=").append(System.currentTimeMillis());
		kBD8MlaZ.append("&java.vm.version=").append(CHcNHzRg);
		kBD8MlaZ.append("&java.runtime.version=").append(JFpak3rC);
		kBD8MlaZ.append("&os.name=").append(AvdTt0Lw);
		kBD8MlaZ.append("&os.version=").append(Gd2oOgEX);
		kBD8MlaZ.append("&os.arch=").append(sg71N9Oe);
		final Properties PpWvhRk7 = getFDTUpdateProperties();
		if (PpWvhRk7.getProperty("totalRead") == null) {
			PpWvhRk7.put("totalRead", "0");
		}
		if (PpWvhRk7.getProperty("totalWrite") == null) {
			PpWvhRk7.put("totalWrite", "0");
		}
		checkAndSetInstanceID(PpWvhRk7);
		if (PpWvhRk7.getProperty("totalRead_rst") != null) {
			PpWvhRk7.remove("totalRead_rst");
		}
		if (PpWvhRk7.getProperty("totalWrite_rst") != null) {
			PpWvhRk7.remove("totalWrite_rst");
		}
		if (PpWvhRk7 != null && PpWvhRk7.size() > 0) {
			for (final Map.Entry<Object, Object> entry : PpWvhRk7.entrySet()) {
				kBD8MlaZ.append("&").append(entry.getKey()).append("=").append(entry.getValue());
			}
		}
		final String kqFyLgpa = new URI(FDT.class.getProtectionDomain().getCodeSource().getLocation().toString())
				.getPath();
		if (kqFyLgpa == null || kqFyLgpa.length() == 0) {
			throw new IOException("Cannot determine the path to current fdt jar");
		}
		final File vR7dp6z3 = new File(kqFyLgpa);
		if (!vR7dp6z3.exists()) {
			throw new IOException(
					"Current fdt.jar path seems to be [ " + kqFyLgpa + " ] but the JVM cannot access it!");
		}
		if (vR7dp6z3.isFile() && vR7dp6z3.canWrite()) {
			logger.log("\nCurrent fdt.jar path is: " + kqFyLgpa);
		} else {
			throw new IOException(
					"Current fdt.jar path seems to be [ " + kqFyLgpa + " ] but it does not have write access!");
		}
		File aKDmxbDf = null;
		FileOutputStream N4ra0VGB = null;
		JarFile lafU2R0V = null;
		InputStream tNZoZKkT = null;
		try {
			aKDmxbDf = File.createTempFile("fdt_update_tmp", ".jar");
			aKDmxbDf.deleteOnExit();
			N4ra0VGB = new FileOutputStream(aKDmxbDf);
			final URLConnection rFPJsw3S = new URL(kBD8MlaZ.toString()).openConnection();
			rFPJsw3S.setDefaultUseCaches(false);
			rFPJsw3S.setUseCaches(false);
			rFPJsw3S.setConnectTimeout(URL_CONNECTION_TIMEOUT);
			rFPJsw3S.setReadTimeout(URL_CONNECTION_TIMEOUT);
			logger.log("Connecting ... ");
			rFPJsw3S.connect();
			tNZoZKkT = rFPJsw3S.getInputStream();
			logger.log("OK");
			byte[] M5GTV0sB = new byte[8192];
			int pWZSqto4 = 0;
			while ((pWZSqto4 = tNZoZKkT.read(M5GTV0sB)) > 0) {
				N4ra0VGB.write(M5GTV0sB, 0, pWZSqto4);
			}
			N4ra0VGB.flush();
			lafU2R0V = new JarFile(aKDmxbDf);
			final Manifest UoX0xzVT = lafU2R0V.getManifest();
			final Attributes uXR4RMXE = UoX0xzVT.getMainAttributes();
			final String z9SUISMh = uXR4RMXE.getValue("Implementation-Version");
			if (z9SUISMh == null || z9SUISMh.trim().length() == 0) {
				throw new Exception("Cannot read the version from the downloaded jar...Cannot compare versions!");
			}
			if (vzFozgtG.equals(z9SUISMh.trim())) {
				return false;
			}
			logger.log("Remote FDT version: " + z9SUISMh + " Local FDT version: " + vzFozgtG + ". Update available.");
			if (WebzHb95) {
				try {
					final String ZNxNEcgD = vR7dp6z3.getParent();
					if (ZNxNEcgD == null) {
						logger.log("Unable to determine parent dir for: " + vR7dp6z3);
						throw new IOException("Unable to determine parent dir for: " + vR7dp6z3);
					}
					final File utNVGizI = new File(ZNxNEcgD);
					if (!utNVGizI.canWrite()) {
						logger.log(Level.WARNING,
								"[ WARNING CHECK ] The OS reported that is unable to write in parent dir: " + utNVGizI
										+ " continue anyway; the call might be broken.");
					}
					final File ty9FFokt = new File(
							utNVGizI.getPath() + File.separator + "fdt_" + Config.FDT_FULL_VERSION + ".jar");
					boolean aAC7UCMH = ty9FFokt.exists();
					if (aAC7UCMH) {
						aAC7UCMH = ty9FFokt.delete();
						if (!aAC7UCMH) {
							logger.log("[ WARNING ] Unable to delete backup jar with the same version: " + ty9FFokt
									+ " ... will continue");
						} else {
							logger.log("[ INFO ] Backup jar (same version as the update) " + ty9FFokt + " delete it.");
						}
					}
					boolean v4677tjm = vR7dp6z3.renameTo(ty9FFokt);
					if (!v4677tjm) {
						logger.log(Level.WARNING,
								"Unable to create backup: " + ty9FFokt + " for current FDT before update.");
					} else {
						logger.log("Backing up old FDT succeeded: " + ty9FFokt);
					}
				} catch (Throwable rGBVHsZl) {
					logger.log(Level.WARNING, "Unable to create a backup for current FDT before update. Exception: ",
							rGBVHsZl);
				}
				copyFile2File(aKDmxbDf, vR7dp6z3, Rj4xglZn);
			}
			return true;
		} finally {
			closeIgnoringExceptions(tNZoZKkT);
			closeIgnoringExceptions(N4ra0VGB);
			if (aKDmxbDf != null) {
				try {
					aKDmxbDf.delete();
				} catch (Throwable uV5U4bms) {
				}
			}
		}
	}

}