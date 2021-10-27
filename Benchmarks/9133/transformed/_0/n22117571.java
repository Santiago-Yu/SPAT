class n22117571 {
	public void copyFileFromLocalMachineToRemoteMachine(InputStream GbJtF6dw, File epsDY4Xa) throws Exception {
		String Eh8tSzMU = epsDY4Xa.getPath();
		File emkpAu6C = new File(getFtpServerHome(), "" + System.currentTimeMillis());
		emkpAu6C.deleteOnExit();
		org.apache.commons.io.IOUtils.copy(GbJtF6dw, new FileOutputStream(emkpAu6C));
		remoteHostClient.setAscii(isAscii());
		remoteHostClient.setPromptOn(isPrompt());
		remoteHostClient.copyFileFromLocalMachineToRemoteClient(emkpAu6C.getName(), Eh8tSzMU);
	}

}