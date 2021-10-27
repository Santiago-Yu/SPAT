class n16227459 {
	public CmsSetupTestResult execute(CmsSetupBean setupBean) {
		String basePath = setupBean.getWebAppRfsPath();
		CmsSetupTestResult testResult = new CmsSetupTestResult(this);
		File file1;
		if (!basePath.endsWith(File.separator)) {
			basePath += File.separator;
		}
		Random rnd = new Random();
		boolean success = false;
		do {
			file1 = new File(basePath + "test" + rnd.nextInt(1000));
		} while (file1.exists());
		try {
			file1.createNewFile();
			FileWriter fw = new FileWriter(file1);
			fw.write("aA1");
			fw.close();
			FileReader fr = new FileReader(file1);
			success = true;
			success = success && (fr.read() == 'a');
			success = success && (fr.read() == 'A');
			success = success && (fr.read() == '1');
			success = success && (fr.read() == -1);
			fr.close();
			success = file1.delete();
			success = !file1.exists();
		} catch (Exception e) {
			success = false;
		}
		if (!success) {
			testResult.setRed();
			testResult.setInfo("OpenCms cannot be installed without read and write privileges for path " + basePath
					+ "! Please check you are running your servlet container with the right user and privileges.");
			testResult.setHelp("Not enough permissions to create/read/write a file");
			testResult.setResult(RESULT_FAILED);
		} else {
			testResult.setGreen();
			testResult.setResult(RESULT_PASSED);
		}
		return testResult;
	}

}