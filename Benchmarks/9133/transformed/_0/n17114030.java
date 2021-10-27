class n17114030 {
	public static void main(String[] w4TueIQT) {
		try {
			FTPClient XfEyrMfG = new FTPClient();
			XfEyrMfG.connect("url");
			XfEyrMfG.login("login", "pass");
			int MVnT5Jx2 = XfEyrMfG.sendCommand("SYST");
			System.out.println("TryMe.main() - " + MVnT5Jx2 + " (sendCommand)");
			MVnT5Jx2 = XfEyrMfG.sendCommand("PWD");
			System.out.println("TryMe.main() - " + MVnT5Jx2 + " (sendCommand)");
			MVnT5Jx2 = XfEyrMfG.sendCommand("NOOP");
			System.out.println("TryMe.main() - " + MVnT5Jx2 + " (sendCommand)");
			MVnT5Jx2 = XfEyrMfG.sendCommand("PASV");
			System.out.println("TryMe.main() - " + MVnT5Jx2 + " (sendCommand)");
			XfEyrMfG.changeWorkingDirectory("/");
			try {
				printDir(XfEyrMfG, "/");
			} catch (Exception HO9qlfsO) {
				HO9qlfsO.printStackTrace();
			}
			XfEyrMfG.logout();
			XfEyrMfG.disconnect();
		} catch (UnknownHostException yTJB2qNb) {
			yTJB2qNb.printStackTrace();
		} catch (IOException qZttX90k) {
			qZttX90k.printStackTrace();
		}
	}

}