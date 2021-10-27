class n5147985 {
	private void writeJar() {
		try {
			File PzQ4Rz2y = new File(currentProjectDir + DEPLOYDIR + fileSeparator + currentProjectName + ".jar");
			jarSize = (int) PzQ4Rz2y.length();
			File xoQ5610O = File.createTempFile("hipergps" + currentProjectName, ".jar");
			xoQ5610O.deleteOnExit();
			File u3aP2g7I = new File(currentProjectDir + "/res/wtj2me.jar");
			JarInputStream kEZvCVSg = new JarInputStream(new FileInputStream(u3aP2g7I));
			Manifest REUKNrun = kEZvCVSg.getManifest();
			java.util.jar.Attributes OF1P9R1S = REUKNrun.getMainAttributes();
			if (hiperGeoId != null) {
				OF1P9R1S.putValue("hiperGeoId", hiperGeoId);
			}
			jad.updateAttributes(OF1P9R1S);
			JarOutputStream PSdS1y1d = new JarOutputStream(new FileOutputStream(xoQ5610O), REUKNrun);
			byte[] cu9oppk7 = new byte[WalkingtoolsInformation.BUFFERSIZE];
			JarEntry kWDkq8JS = null;
			while ((kWDkq8JS = kEZvCVSg.getNextJarEntry()) != null) {
				if (kWDkq8JS.getName().contains("net/") || kWDkq8JS.getName().contains("org/")) {
					try {
						PSdS1y1d.putNextEntry(kWDkq8JS);
					} catch (ZipException XSVjiP2V) {
						continue;
					}
					int p3y2DZ2Z;
					while ((p3y2DZ2Z = kEZvCVSg.read(cu9oppk7)) != -1) {
						PSdS1y1d.write(cu9oppk7, 0, p3y2DZ2Z);
					}
					PSdS1y1d.closeEntry();
				}
			}
			File[] DV5x8R5T = {
					new File(currentProjectDir + WalkingtoolsInformation.IMAGEDIR + fileSeparator + "icon_"
							+ WalkingtoolsInformation.MEDIAUUID + ".png"),
					new File(currentProjectDir + WalkingtoolsInformation.IMAGEDIR + fileSeparator + "loaderIcon_"
							+ WalkingtoolsInformation.MEDIAUUID + ".png"),
					new File(currentProjectDir + WalkingtoolsInformation.IMAGEDIR + fileSeparator + "mygps_"
							+ WalkingtoolsInformation.MEDIAUUID + ".png") };
			for (int yd6YRh81 = 0; yd6YRh81 < DV5x8R5T.length; yd6YRh81++) {
				kWDkq8JS = new JarEntry("img/" + DV5x8R5T[yd6YRh81].getName());
				try {
					PSdS1y1d.putNextEntry(kWDkq8JS);
				} catch (ZipException AZeJ1VFx) {
					continue;
				}
				FileInputStream qinB0ac0 = new FileInputStream(DV5x8R5T[yd6YRh81]);
				while (true) {
					int xZy5SqQ8 = qinB0ac0.read(cu9oppk7, 0, cu9oppk7.length);
					if (xZy5SqQ8 <= 0) {
						break;
					}
					PSdS1y1d.write(cu9oppk7, 0, xZy5SqQ8);
				}
				qinB0ac0.close();
			}
			for (int Kp8lRhrc = 0; Kp8lRhrc < imageFiles.size(); Kp8lRhrc++) {
				kWDkq8JS = new JarEntry("img/" + imageFiles.get(Kp8lRhrc).getName());
				try {
					PSdS1y1d.putNextEntry(kWDkq8JS);
				} catch (ZipException jwpOwqFn) {
					continue;
				}
				FileInputStream sWTrdjMn = new FileInputStream(imageFiles.get(Kp8lRhrc));
				while (true) {
					int PaJvxaDS = sWTrdjMn.read(cu9oppk7, 0, cu9oppk7.length);
					if (PaJvxaDS <= 0) {
						break;
					}
					PSdS1y1d.write(cu9oppk7, 0, PaJvxaDS);
				}
				sWTrdjMn.close();
			}
			for (int u5VqDu3i = 0; u5VqDu3i < audioFiles.size(); u5VqDu3i++) {
				kWDkq8JS = new JarEntry("audio/" + audioFiles.get(u5VqDu3i).getName());
				try {
					PSdS1y1d.putNextEntry(kWDkq8JS);
				} catch (ZipException A1YcVVSR) {
					continue;
				}
				FileInputStream ENwhMAJ5 = new FileInputStream(audioFiles.get(u5VqDu3i));
				while (true) {
					int KDi7FYWA = ENwhMAJ5.read(cu9oppk7, 0, cu9oppk7.length);
					if (KDi7FYWA <= 0) {
						break;
					}
					PSdS1y1d.write(cu9oppk7, 0, KDi7FYWA);
				}
				ENwhMAJ5.close();
			}
			File IPRygJ9p = new File(currentProjectDir + WalkingtoolsInformation.GPXDIR + "/hipergps.gpx");
			kWDkq8JS = new JarEntry("gpx/" + IPRygJ9p.getName());
			PSdS1y1d.putNextEntry(kWDkq8JS);
			FileInputStream CeA2YnnW = new FileInputStream(IPRygJ9p);
			while (true) {
				int wgQPnH8x = CeA2YnnW.read(cu9oppk7, 0, cu9oppk7.length);
				if (wgQPnH8x <= 0) {
					break;
				}
				PSdS1y1d.write(cu9oppk7, 0, wgQPnH8x);
			}
			CeA2YnnW.close();
			PSdS1y1d.flush();
			PSdS1y1d.close();
			jarSize = (int) xoQ5610O.length();
			kEZvCVSg = new JarInputStream(new FileInputStream(xoQ5610O));
			REUKNrun = kEZvCVSg.getManifest();
			OF1P9R1S = REUKNrun.getMainAttributes();
			OF1P9R1S.putValue("MIDlet-Jar-Size", "" + jarSize + 1);
			PSdS1y1d = new JarOutputStream(new FileOutputStream(PzQ4Rz2y), REUKNrun);
			while ((kWDkq8JS = kEZvCVSg.getNextJarEntry()) != null) {
				try {
					PSdS1y1d.putNextEntry(kWDkq8JS);
				} catch (ZipException GbLzHjA6) {
					continue;
				}
				int mOqt3vr2;
				while ((mOqt3vr2 = kEZvCVSg.read(cu9oppk7)) != -1) {
					PSdS1y1d.write(cu9oppk7, 0, mOqt3vr2);
				}
				PSdS1y1d.closeEntry();
			}
			PSdS1y1d.flush();
			kEZvCVSg.close();
			PSdS1y1d.close();
		} catch (FileNotFoundException Bq0NeHK5) {
			Bq0NeHK5.printStackTrace();
		} catch (IOException kklPHUfh) {
			kklPHUfh.printStackTrace();
		}
	}

}