class n16227459 {
	public CmsSetupTestResult execute(CmsSetupBean nfR901hM) {
		CmsSetupTestResult UhHyMbec = new CmsSetupTestResult(this);
		String lk6J0Uby = nfR901hM.getWebAppRfsPath();
		if (!lk6J0Uby.endsWith(File.separator)) {
			lk6J0Uby += File.separator;
		}
		File QOJyTuTE;
		Random rNcPAxPh = new Random();
		do {
			QOJyTuTE = new File(lk6J0Uby + "test" + rNcPAxPh.nextInt(1000));
		} while (QOJyTuTE.exists());
		boolean cAX3G3eq = false;
		try {
			QOJyTuTE.createNewFile();
			FileWriter P9UXiMti = new FileWriter(QOJyTuTE);
			P9UXiMti.write("aA1");
			P9UXiMti.close();
			cAX3G3eq = true;
			FileReader fdXsOYUD = new FileReader(QOJyTuTE);
			cAX3G3eq = cAX3G3eq && (fdXsOYUD.read() == 'a');
			cAX3G3eq = cAX3G3eq && (fdXsOYUD.read() == 'A');
			cAX3G3eq = cAX3G3eq && (fdXsOYUD.read() == '1');
			cAX3G3eq = cAX3G3eq && (fdXsOYUD.read() == -1);
			fdXsOYUD.close();
			cAX3G3eq = QOJyTuTE.delete();
			cAX3G3eq = !QOJyTuTE.exists();
		} catch (Exception IR2tYoKb) {
			cAX3G3eq = false;
		}
		if (!cAX3G3eq) {
			UhHyMbec.setRed();
			UhHyMbec.setInfo("OpenCms cannot be installed without read and write privileges for path " + lk6J0Uby
					+ "! Please check you are running your servlet container with the right user and privileges.");
			UhHyMbec.setHelp("Not enough permissions to create/read/write a file");
			UhHyMbec.setResult(RESULT_FAILED);
		} else {
			UhHyMbec.setGreen();
			UhHyMbec.setResult(RESULT_PASSED);
		}
		return UhHyMbec;
	}

}