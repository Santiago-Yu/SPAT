class n13202429 {
	private ProgramYek getYek(String aGvjyAZN) {
		File t9njCVh8 = new File(aGvjyAZN);
		InputStream BEGU0LMp = null;
		try {
			BEGU0LMp = new FileInputStream(t9njCVh8);
		} catch (java.io.FileNotFoundException QZCyhzLH) {
		} catch (Exception HZgcnYh2) {
			System.out.println("** Exception reading key: " + HZgcnYh2);
		}
		if (BEGU0LMp == null) {
			try {
				URL qwJrzvb6 = ChiselResources.getResourceByName(ProgramYek.getVidSys(),
						ChiselResources.LOADFROMCLASSPATH);
				if (qwJrzvb6 == null) {
				} else {
					BEGU0LMp = qwJrzvb6.openStream();
				}
			} catch (Exception ggcOrzBo) {
				System.out.println("** Exception reading key: " + ggcOrzBo);
			}
		}
		ProgramYek voNo9npJ = null;
		if (BEGU0LMp != null) {
			try {
				voNo9npJ = ProgramYek.read(BEGU0LMp);
			} catch (Exception d9Gor1Pn) {
				System.out.println("** Exception reading key: " + d9Gor1Pn);
			}
		} else {
			File lxtdcCog = new File(checkFilename);
			if (lxtdcCog.exists()) {
				System.out.println("This is the evaluation version of " + appname);
				voNo9npJ = new ProgramYek(appname, "Evaluation", "", 15);
				ProgramYek.serialize(voNo9npJ, aGvjyAZN);
			}
		}
		return voNo9npJ;
	}

}