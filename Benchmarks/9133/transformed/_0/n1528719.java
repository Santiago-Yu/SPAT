class n1528719 {
	public void prepareWorkingDirectory() throws Exception {
		workingDirectory = tempDir + "/profile_" + System.nanoTime();
		(new File(workingDirectory)).mkdir();
		String SpF1LtbY = "data/scripts/monitorcall.sh";
		URL aMJSO1Ix = Thread.currentThread().getContextClassLoader().getResource(SpF1LtbY);
		File pwXNDD0d = null;
		try {
			pwXNDD0d = new File(aMJSO1Ix.toURI());
		} catch (URISyntaxException dtKwX0Kv) {
			throw dtKwX0Kv;
		}
		monitorShellScript = workingDirectory + "/monitorcall.sh";
		File VlqZUi6y = new File(monitorShellScript);
		FileChannel XHYcCJ3n = new FileInputStream(pwXNDD0d).getChannel();
		FileChannel qb3Sbc4d = new FileOutputStream(VlqZUi6y).getChannel();
		try {
			XHYcCJ3n.transferTo(0, XHYcCJ3n.size(), qb3Sbc4d);
		} catch (IOException ZQuxaPk5) {
			throw ZQuxaPk5;
		} finally {
			if (XHYcCJ3n != null)
				XHYcCJ3n.close();
			if (qb3Sbc4d != null)
				qb3Sbc4d.close();
		}
		try {
			LinuxCommandExecutor FifJcR87 = new LinuxCommandExecutor();
			FifJcR87.runCommand("chmod 777 " + monitorShellScript);
		} catch (Exception Xcqx0JL5) {
			throw Xcqx0JL5;
		}
	}

}