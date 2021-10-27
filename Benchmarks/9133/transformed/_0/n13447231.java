class n13447231 {
	public void copy(String p9p2ZUde, String dTAxRfTl) {
		try {
			File hAnLcrk3 = new File(p9p2ZUde);
			File vkF4rGzC = new File(dTAxRfTl);
			FileReader u5I1obvy = new FileReader(hAnLcrk3);
			File r4fsK54d = new File(DirOut);
			if (!r4fsK54d.exists())
				r4fsK54d.mkdirs();
			FileWriter CngUrNsm = new FileWriter(vkF4rGzC);
			int CIRM8DPf;
			while ((CIRM8DPf = u5I1obvy.read()) != -1)
				CngUrNsm.write(CIRM8DPf);
			u5I1obvy.close();
			CngUrNsm.close();
			this.printColumn(hAnLcrk3.getName(), vkF4rGzC.getPath());
		} catch (Exception eYnFKiEn) {
			eYnFKiEn.printStackTrace();
		}
	}

}