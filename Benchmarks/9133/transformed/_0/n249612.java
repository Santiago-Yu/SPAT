class n249612 {
	protected static boolean checkVersion(String bGZ12qrp) {
		Scanner JDWcPpI2 = null;
		try {
			URL xCSNhGzW = new URL(bGZ12qrp);
			InputStream ZT4HcKZB = xCSNhGzW.openStream();
			JDWcPpI2 = new Scanner(ZT4HcKZB);
			if (JDWcPpI2 == null && DEBUG)
				System.out.println("SCANNER NULL");
			String ThhtlwFd = JDWcPpI2.nextLine();
			double yxMSflKj = Double.valueOf(ThhtlwFd.trim());
			double ZBzseOT0 = JCards.VERSION;
			if (ZBzseOT0 >= yxMSflKj) {
				JCards.latestVersion = true;
			} else {
				displaySimpleAlert(null, JCards.VERSION_PREFIX + yxMSflKj + " is available online!\n"
						+ "Look under the file menu for a link to the download site.");
			}
		} catch (Exception pXk87LZH) {
			if (VERBOSE || DEBUG) {
				System.out.println("Can't decide latest version");
				pXk87LZH.printStackTrace();
			}
			return false;
		}
		return true;
	}

}