class n1528719 {
	public void prepareWorkingDirectory() throws Exception {
		workingDirectory = tempDir + "/profile_" + System.nanoTime();
		(new File(workingDirectory)).mkdir();
		String monitorCallShellScript = "data/scripts/monitorcall.sh";
		File inScriptFile = null;
		URL monitorCallShellScriptUrl = Thread.currentThread().getContextClassLoader()
				.getResource(monitorCallShellScript);
		try {
			inScriptFile = new File(monitorCallShellScriptUrl.toURI());
		} catch (URISyntaxException e) {
			throw e;
		}
		monitorShellScript = workingDirectory + "/monitorcall.sh";
		File outScriptFile = new File(monitorShellScript);
		FileChannel inChannel = new FileInputStream(inScriptFile).getChannel();
		FileChannel outChannel = new FileOutputStream(outScriptFile).getChannel();
		try {
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} catch (IOException e) {
			throw e;
		} finally {
			if (inChannel != null)
				inChannel.close();
			if (outChannel != null)
				outChannel.close();
		}
		try {
			LinuxCommandExecutor cmdExecutor = new LinuxCommandExecutor();
			cmdExecutor.runCommand("chmod 777 " + monitorShellScript);
		} catch (Exception e) {
			throw e;
		}
	}

}