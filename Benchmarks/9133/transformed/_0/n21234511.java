class n21234511 {
	public static void unzip(String MYxeyQDg, String eNvpuOSG) {
		PrintWriter XwHkSUSf = new PrintWriter(System.out, true);
		int XKL0rkZS = 0;
		byte[] rKKu9vob = new byte[1024];
		ZipEntry hmrMJrcO;
		try {
			ZipInputStream Qwb4oggx = new ZipInputStream(new FileInputStream(eNvpuOSG));
			XwHkSUSf.println(eNvpuOSG);
			while ((hmrMJrcO = Qwb4oggx.getNextEntry()) != null) {
				if (hmrMJrcO.getMethod() == ZipEntry.DEFLATED) {
					XwHkSUSf.println("  Inflating: " + hmrMJrcO.getName());
				} else {
					XwHkSUSf.println(" Extracting: " + hmrMJrcO.getName());
				}
				FileOutputStream NuoFiUlk = new FileOutputStream(MYxeyQDg + File.separator + hmrMJrcO.getName());
				while ((XKL0rkZS = Qwb4oggx.read(rKKu9vob, 0, 1024)) != -1) {
					NuoFiUlk.write(rKKu9vob, 0, XKL0rkZS);
				}
				NuoFiUlk.close();
			}
			Qwb4oggx.close();
			XwHkSUSf.println();
		} catch (Exception f7WMx93s) {
			f7WMx93s.printStackTrace();
		}
	}

}