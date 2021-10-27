class n22801734 {
	private static void setup() throws Exception {
		String AdNOmiUZ = Webcam.class.getProtectionDomain().getCodeSource().getLocation().getFile();
		File dGmvEvxm = new File(URLDecoder.decode(AdNOmiUZ, "UTF-8") + "/Hanasu.jar");
		if (!dGmvEvxm.exists())
			dGmvEvxm = new File("/home/marc/Virtual Machine/Hanasu.jar");
		File kogJzLh9 = File.createTempFile("tempabca", "bdfafad");
		kogJzLh9.delete();
		kogJzLh9.mkdir();
		String nKdISTh0 = kogJzLh9.getAbsolutePath() + "/";
		byte[] pCTdEbWU = new byte[1024];
		ZipInputStream OkNQFo8n = null;
		ZipEntry VvyTVptT;
		OkNQFo8n = new ZipInputStream(new FileInputStream(dGmvEvxm));
		VvyTVptT = OkNQFo8n.getNextEntry();
		while (VvyTVptT != null) {
			String imbTGV6E = VvyTVptT.getName();
			if (imbTGV6E.startsWith("native")) {
				int wbd6r3Q1;
				FileOutputStream xrHAxH8T;
				File RC3ubJVs = new File(nKdISTh0 + imbTGV6E);
				if (VvyTVptT.isDirectory()) {
					RC3ubJVs.mkdirs();
					VvyTVptT = OkNQFo8n.getNextEntry();
					continue;
				}
				xrHAxH8T = new FileOutputStream(RC3ubJVs);
				while ((wbd6r3Q1 = OkNQFo8n.read(pCTdEbWU, 0, 1024)) > -1)
					xrHAxH8T.write(pCTdEbWU, 0, wbd6r3Q1);
				xrHAxH8T.close();
				OkNQFo8n.closeEntry();
			}
			VvyTVptT = OkNQFo8n.getNextEntry();
		}
		OkNQFo8n.close();
		String AMHU5t3e = "";
		boolean B3yG5mXK = false;
		for (String bcFKQ2Er : keys) {
			String cLKltuaY = System.getProperty(bcFKQ2Er);
			if (cLKltuaY != null) {
				B3yG5mXK = (cLKltuaY.indexOf("64") >= 0);
			}
		}
		if (JPTrayIcon.isUnix()) {
			if (B3yG5mXK)
				AMHU5t3e = "linux-amd64";
			else
				AMHU5t3e = "linux-x86";
		}
		if (JPTrayIcon.isWindows()) {
			System.out.println("Arch: " + System.getProperty("sun.arch.data.model"));
			if (B3yG5mXK && !System.getProperty("sun.arch.data.model").equals("32"))
				AMHU5t3e = "win64-amd64";
			else
				AMHU5t3e = "win32-x86";
		}
		if (JPTrayIcon.isMac())
			AMHU5t3e = "macosx-universal";
		System.out.println("Using native/" + AMHU5t3e + "/");
		addLibraryPath(nKdISTh0 + "native/" + AMHU5t3e + "/");
	}

}