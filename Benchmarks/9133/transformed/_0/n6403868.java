class n6403868 {
	private File extractUninstallFiles(File Qln9ZFAl, boolean GrzeUZ72, String qq0aC26I) {
		File Ldz2kLDD = null;
		try {
			boolean xGEG73kH = false;
			File AbcOOSg1 = new File(Qln9ZFAl, "vai_" + VAGlobals.APP_NAME + "_" + VAGlobals.APP_VERSION);
			if (GrzeUZ72) {
				File BQ1To8T9 = new File(Qln9ZFAl, "vai_" + VAGlobals.APP_NAME + "_" + qq0aC26I);
				if (AbcOOSg1.equals(BQ1To8T9)) {
					File nxuoylKN = new File(AbcOOSg1.getAbsolutePath() + ".bak");
					if (!AbcOOSg1.renameTo(nxuoylKN)) {
						throw new IOException(VAGlobals.i18n("Setup_NotCreateDirectory") + " " + AbcOOSg1);
					}
					Ldz2kLDD = new File(
							nxuoylKN.getAbsolutePath() + System.getProperty("file.separator") + "uninstall.vai");
					BQ1To8T9 = nxuoylKN;
				} else {
					Ldz2kLDD = new File(
							BQ1To8T9.getAbsolutePath() + System.getProperty("file.separator") + "uninstall.vai");
				}
				if ((!AbcOOSg1.exists()) && (!AbcOOSg1.mkdirs())) {
					throw new IOException(VAGlobals.i18n("Setup_NotCreateDirectory") + " " + AbcOOSg1);
				}
				if (uInfo_.module)
					xGEG73kH = copyOldSetupClass(BQ1To8T9, AbcOOSg1);
			} else {
				if ((!AbcOOSg1.exists()) && (!AbcOOSg1.mkdirs())) {
					throw new IOException(VAGlobals.i18n("Setup_NotCreateDirectory") + " " + AbcOOSg1);
				}
			}
			dirty_ = true;
			File[] FTmuGUxR = AbcOOSg1.listFiles();
			for (int NxLive6D = 0; NxLive6D < FTmuGUxR.length; NxLive6D++) {
				if (!xGEG73kH)
					FTmuGUxR[NxLive6D].delete();
				else if (!FTmuGUxR[NxLive6D].getPath()
						.equals(AbcOOSg1.getAbsolutePath() + File.separator + installClassName_ + ".class"))
					FTmuGUxR[NxLive6D].delete();
			}
			byte[] DmKaarZr = new byte[0];
			int E9K4f0rf = 0;
			if (!xGEG73kH && (installClassSize_ > 0 || jarOffset_ > 0)) {
				final File zC5gc9EL = new File(
						AbcOOSg1.getAbsolutePath() + File.separator + installClassName_ + ".class");
				if (zC5gc9EL.exists() && !zC5gc9EL.delete()) {
					ui_.showError(new Exception(VAGlobals.i18n("Setup_FileNotCreated") + ":\n" + zC5gc9EL.getName()));
				}
				final FileOutputStream u4FduR5q = new FileOutputStream(zC5gc9EL);
				final FileInputStream XIyPcfJW = new FileInputStream(fileWithArchive_);
				if (installClassOffset_ > 0) {
					XIyPcfJW.skip(installClassOffset_);
				}
				DmKaarZr = new byte[0];
				if (installClassSize_ < 0)
					DmKaarZr = new byte[(int) jarOffset_];
				else
					DmKaarZr = new byte[(int) installClassSize_];
				E9K4f0rf = XIyPcfJW.read(DmKaarZr, 0, DmKaarZr.length);
				u4FduR5q.write(DmKaarZr, 0, E9K4f0rf);
				u4FduR5q.close();
				XIyPcfJW.close();
			}
			final FileInputStream HmUvIJN4 = new FileInputStream(fileWithArchive_);
			if (jarOffset_ > 0) {
				HmUvIJN4.skip(jarOffset_);
			}
			JarInputStream V4JTaxn9 = new JarInputStream(HmUvIJN4);
			final File Y3oC2Qk7 = new File(AbcOOSg1.getAbsolutePath() + File.separator + "install.jar");
			if (Y3oC2Qk7.exists() && !Y3oC2Qk7.delete()) {
				ui_.showError(new Exception(VAGlobals.i18n("Setup_FileNotCreated") + ":\n" + Y3oC2Qk7.getName()));
			}
			JarOutputStream kicnVk6q = new JarOutputStream(new FileOutputStream(Y3oC2Qk7));
			ZipEntry tJ1qcM3F = V4JTaxn9.getNextEntry();
			final int hzYGuv9Q = 32768;
			DmKaarZr = new byte[hzYGuv9Q];
			while (tJ1qcM3F != null) {
				String nwFk2ql6 = tJ1qcM3F.getName();
				if (nwFk2ql6.equals("com/memoire/vainstall/resources/vainstall.properties")) {
				} else if (nwFk2ql6.equals(installClassName_ + ".class") && !xGEG73kH) {
					FileOutputStream TPRcdELU = null;
					try {
						TPRcdELU = new FileOutputStream(
								AbcOOSg1.getAbsolutePath() + File.separator + installClassName_ + ".class");
						VAGlobals.copyStream(V4JTaxn9, TPRcdELU, DmKaarZr);
					} catch (IOException ENqyLdoA) {
						throw ENqyLdoA;
					} finally {
						if (TPRcdELU != null)
							TPRcdELU.close();
					}
				} else if (!nwFk2ql6.endsWith(".zip")) {
					if (VAGlobals.DEBUG)
						VAGlobals.printDebug("jar entry name " + nwFk2ql6);
					ZipEntry DvuYqPl0 = new ZipEntry(nwFk2ql6);
					CRC32 aU5lvSCT = new CRC32();
					kicnVk6q.putNextEntry(DvuYqPl0);
					int p8pYS2vu = 0;
					while ((E9K4f0rf = V4JTaxn9.read(DmKaarZr, 0, hzYGuv9Q)) >= 0) {
						p8pYS2vu += E9K4f0rf;
						if (E9K4f0rf == 0) {
							Thread.yield();
						} else {
							kicnVk6q.write(DmKaarZr, 0, E9K4f0rf);
							aU5lvSCT.update(DmKaarZr, 0, E9K4f0rf);
						}
					}
					DvuYqPl0.setSize(p8pYS2vu);
					DvuYqPl0.setCrc(aU5lvSCT.getValue());
					kicnVk6q.flush();
					kicnVk6q.closeEntry();
				}
				V4JTaxn9.closeEntry();
				tJ1qcM3F = V4JTaxn9.getNextEntry();
			}
			InputStream sCvtCFbV = getClass().getResourceAsStream("resources/vainstall.properties");
			Properties xRDYiU24 = new Properties();
			try {
				xRDYiU24.load(sCvtCFbV);
			} catch (IOException RDmFLsAu) {
			}
			if (language == null)
				language = "default";
			xRDYiU24.setProperty("vainstall.destination.language", language);
			ZipEntry RWQK5bw7 = new ZipEntry("com/memoire/vainstall/resources/vainstall.properties");
			CRC32 gEWdkCzs = new CRC32();
			RWQK5bw7.setCrc(gEWdkCzs.getValue());
			RWQK5bw7.setSize(xRDYiU24.size());
			kicnVk6q.putNextEntry(RWQK5bw7);
			xRDYiU24.store(kicnVk6q, VAGlobals.NAME + " " + VAGlobals.VERSION);
			RWQK5bw7.setCrc(gEWdkCzs.getValue());
			kicnVk6q.closeEntry();
			V4JTaxn9.close();
			kicnVk6q.close();
			HmUvIJN4.close();
		} catch (IOException mwIqcjDK) {
			String ASzwmu0M = mwIqcjDK.getLocalizedMessage();
			ASzwmu0M += "\n" + VAGlobals.i18n("Setup_ErrorUninstallScripts");
			mwIqcjDK.printStackTrace();
			exitOnError(new IOException(ASzwmu0M));
		}
		return Ldz2kLDD;
	}

}