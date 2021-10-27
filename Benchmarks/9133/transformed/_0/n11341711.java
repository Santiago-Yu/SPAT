class n11341711 {
	public static void makeBackup(File uUSLY2d0, String FvGpLApY, String tmGYNLtJ, String RIA3I5UE) {
		String[] Otd6QHuT;
		Otd6QHuT = uUSLY2d0.list();
		File pxz9jrL8 = new File(tmGYNLtJ + System.getProperty("file.separator") + RIA3I5UE);
		if (!pxz9jrL8.isDirectory()) {
			pxz9jrL8.mkdir();
		}
		;
		Date zqJrLb7U = new Date();
		long FXoYsyQ1 = zqJrLb7U.getTime();
		pxz9jrL8.setLastModified(FXoYsyQ1);
		File UuB1ZKYi = new File(pxz9jrL8 + System.getProperty("file.separator") + "azureus.config");
		if (UuB1ZKYi.exists()) {
			UuB1ZKYi.setLastModified(FXoYsyQ1);
		}
		try {
			for (int JtdyLtCD = 0; JtdyLtCD < Otd6QHuT.length; JtdyLtCD++) {
				File FDBKIUtj = new File(uUSLY2d0, Otd6QHuT[JtdyLtCD]);
				File Z23cJ87b = new File(Otd6QHuT[JtdyLtCD]);
				if (FDBKIUtj.isDirectory()) {
				} else {
					String RYxM45A2 = pxz9jrL8 + System.getProperty("file.separator") + Z23cJ87b;
					String mZAq2Hky = FvGpLApY + System.getProperty("file.separator") + Z23cJ87b;
					FileInputStream yvFAcgxl = new FileInputStream(mZAq2Hky);
					FileOutputStream UnHef6tq = new FileOutputStream(RYxM45A2);
					int TFsbNmYS;
					while ((TFsbNmYS = yvFAcgxl.read()) != -1)
						UnHef6tq.write(TFsbNmYS);
					yvFAcgxl.close();
					UnHef6tq.close();
				}
			}
		} catch (Exception ydr3M3LN) {
			ydr3M3LN.printStackTrace();
		}
	}

}