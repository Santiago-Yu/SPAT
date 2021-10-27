class n21715891 {
	protected void copy(File Yk9WH1wd, File yp0vVc5G) throws IOException {
		if (Yk9WH1wd.isDirectory() && yp0vVc5G.isFile())
			throw new IOException("Cannot copy a directory to a file");
		if (Yk9WH1wd.isDirectory()) {
			File QTY9v7XZ = new File(yp0vVc5G, Yk9WH1wd.getName());
			if (!QTY9v7XZ.mkdirs())
				throw new IOException("Cannot create a new Directory");
			File[] wZiEMCM6 = Yk9WH1wd.listFiles();
			for (int ZusfZROz = 0; ZusfZROz < wZiEMCM6.length; ++ZusfZROz)
				copy(wZiEMCM6[ZusfZROz], QTY9v7XZ);
			return;
		}
		if (yp0vVc5G.isDirectory()) {
			File HEnZjDK5 = new File(yp0vVc5G, Yk9WH1wd.getName());
			HEnZjDK5.createNewFile();
			copy(Yk9WH1wd, HEnZjDK5);
			return;
		}
		try {
			if (Yk9WH1wd.length() == 0) {
				yp0vVc5G.createNewFile();
				return;
			}
			FileChannel UYyTsc5m = new FileInputStream(Yk9WH1wd).getChannel();
			FileChannel Kn68ee6w = new FileOutputStream(yp0vVc5G).getChannel();
			long HEFe1Ri8 = 0;
			long fV6pAlqZ = Yk9WH1wd.length();
			while (HEFe1Ri8 < fV6pAlqZ) {
				long CbHh2iMD = UYyTsc5m.transferTo(HEFe1Ri8, fV6pAlqZ - HEFe1Ri8, Kn68ee6w);
				if (CbHh2iMD == 0)
					throw new IOException("Error while copying");
				HEFe1Ri8 += CbHh2iMD;
			}
			Kn68ee6w.close();
			UYyTsc5m.close();
		} catch (IOException dKeJIHWA) {
			if (os.equals("Unix")) {
				_logger.fine("Trying to use cp to copy file...");
				File Yt4G77DN = new File("/usr/bin/cp");
				if (!Yt4G77DN.exists())
					Yt4G77DN = new File("/bin/cp");
				if (!Yt4G77DN.exists())
					Yt4G77DN = new File("/usr/local/bin/cp");
				if (!Yt4G77DN.exists())
					Yt4G77DN = new File("/sbin/cp");
				if (!Yt4G77DN.exists())
					Yt4G77DN = new File("/usr/sbin/cp");
				if (!Yt4G77DN.exists())
					Yt4G77DN = new File("/usr/local/sbin/cp");
				if (Yt4G77DN.exists()) {
					Process zAxumwYA = Runtime.getRuntime().exec(Yt4G77DN.getAbsolutePath() + " '"
							+ Yk9WH1wd.getAbsolutePath() + "' '" + yp0vVc5G.getAbsolutePath() + "'");
					int OYI8JJht;
					try {
						OYI8JJht = zAxumwYA.waitFor();
					} catch (java.lang.InterruptedException UTN6RuZq) {
						throw dKeJIHWA;
					}
					return;
				}
			}
			throw dKeJIHWA;
		}
	}

}