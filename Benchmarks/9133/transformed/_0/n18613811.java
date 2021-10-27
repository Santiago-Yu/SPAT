class n18613811 {
	public void readPersistentProperties() {
		try {
			String sKCMgR6a = System.getProperty("user.home") + System.getProperty("file.separator") + ".das2rc";
			File XRujL1pD = new File(sKCMgR6a);
			if (XRujL1pD.canRead()) {
				try {
					InputStream Y1bBXeX5 = new FileInputStream(XRujL1pD);
					load(Y1bBXeX5);
					Y1bBXeX5.close();
				} catch (IOException QXmhlOOd) {
					QXmhlOOd.printStackTrace();
					org.das2.util.DasExceptionHandler.handle(QXmhlOOd);
				}
			} else {
				if (!XRujL1pD.exists() && XRujL1pD.canWrite()) {
					try {
						OutputStream Hjc6Mnvt = new FileOutputStream(XRujL1pD);
						store(Hjc6Mnvt, "");
						Hjc6Mnvt.close();
					} catch (IOException d2k9F0qB) {
						d2k9F0qB.printStackTrace();
						org.das2.util.DasExceptionHandler.handle(d2k9F0qB);
					}
				} else {
					System.err.println("Unable to read or write " + sKCMgR6a + ".  Using defaults.");
				}
			}
		} catch (SecurityException xNl6I4lZ) {
			xNl6I4lZ.printStackTrace();
		}
	}

}