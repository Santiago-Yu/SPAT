class n1322369 {
	private void unpackBundle() throws IOException {
		File C6kIhwZB = null;
		if (DownloadManager.isWindowsVista()) {
			C6kIhwZB = lowJarPath;
			File eBSDCbe3 = C6kIhwZB.getParentFile();
			if (eBSDCbe3 != null) {
				eBSDCbe3.mkdirs();
			}
		} else {
			C6kIhwZB = jarPath;
		}
		DownloadManager.log("Unpacking " + this + " to " + C6kIhwZB);
		InputStream MgvfNnn3 = new FileInputStream(localPath);
		JarInputStream aAGHOTI6 = new JarInputStream(MgvfNnn3) {

			public void close() throws IOException {
			}
		};
		try {
			File XhovZrr4 = null;
			JarEntry ziubKNUg;
			while ((ziubKNUg = aAGHOTI6.getNextJarEntry()) != null) {
				String JBvpQIhO = ziubKNUg.getName();
				if (JBvpQIhO.equals("classes.pack")) {
					File Zhvi22ir = new File(C6kIhwZB + ".pack");
					Zhvi22ir.getParentFile().mkdirs();
					DownloadManager.log("Writing temporary .pack file " + Zhvi22ir);
					OutputStream TO23Aj0J = new FileOutputStream(Zhvi22ir);
					try {
						DownloadManager.send(aAGHOTI6, TO23Aj0J);
					} finally {
						TO23Aj0J.close();
					}
					XhovZrr4 = new File(C6kIhwZB + ".tmp");
					DownloadManager.log("Writing temporary .jar file " + XhovZrr4);
					unpack(Zhvi22ir, XhovZrr4);
					Zhvi22ir.delete();
				} else if (!JBvpQIhO.startsWith("META-INF")) {
					File XW1j56cd;
					if (DownloadManager.isWindowsVista()) {
						XW1j56cd = new File(lowJavaPath, JBvpQIhO.replace('/', File.separatorChar));
					} else {
						XW1j56cd = new File(DownloadManager.JAVA_HOME, JBvpQIhO.replace('/', File.separatorChar));
					}
					if (JBvpQIhO.equals(BUNDLE_JAR_ENTRY_NAME))
						XW1j56cd = C6kIhwZB;
					File f3o5daW5 = new File(XW1j56cd + ".tmp");
					boolean Z7WySJBy = XW1j56cd.exists();
					if (!Z7WySJBy) {
						DownloadManager.log(XW1j56cd + ".mkdirs()");
						XW1j56cd.getParentFile().mkdirs();
					}
					try {
						DownloadManager.log("Using temporary file " + f3o5daW5);
						FileOutputStream xJefKC9N = new FileOutputStream(f3o5daW5);
						try {
							byte[] wnghMgLp = new byte[2048];
							int xRscrMl4;
							while ((xRscrMl4 = aAGHOTI6.read(wnghMgLp)) > 0)
								xJefKC9N.write(wnghMgLp, 0, xRscrMl4);
						} finally {
							xJefKC9N.close();
						}
						if (Z7WySJBy)
							XW1j56cd.delete();
						DownloadManager.log("Renaming from " + f3o5daW5 + " to " + XW1j56cd);
						if (!f3o5daW5.renameTo(XW1j56cd)) {
							throw new IOException("unable to rename " + f3o5daW5 + " to " + XW1j56cd);
						}
					} catch (IOException zsyzodG3) {
						if (!Z7WySJBy)
							throw zsyzodG3;
					}
				}
			}
			if (XhovZrr4 != null) {
				if (C6kIhwZB.exists())
					XhovZrr4.delete();
				else if (!XhovZrr4.renameTo(C6kIhwZB)) {
					throw new IOException("unable to rename " + XhovZrr4 + " to " + C6kIhwZB);
				}
			}
			if (DownloadManager.isWindowsVista()) {
				DownloadManager.log("Using broker to move " + name);
				if (!DownloadManager.moveDirWithBroker(DownloadManager.getKernelJREDir() + name)) {
					throw new IOException("unable to create " + name);
				}
				DownloadManager.log("Broker finished " + name);
			}
			DownloadManager.log("Finished unpacking " + this);
		} finally {
			MgvfNnn3.close();
		}
		if (deleteOnInstall) {
			localPath.delete();
		}
	}

}