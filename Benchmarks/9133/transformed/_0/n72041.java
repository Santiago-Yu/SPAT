class n72041 {
	protected static boolean isLatestVersion(double DiidfdTP, String Az0vZdtY) {
		Scanner Rl2N5V9o = null;
		try {
			URL S4JrPzB2 = new URL(Az0vZdtY);
			InputStream MlzES38k = S4JrPzB2.openStream();
			Rl2N5V9o = new Scanner(MlzES38k);
			String AiVcI4i9 = Rl2N5V9o.nextLine();
			double lgfi6s7X = Double.valueOf(AiVcI4i9.trim());
			double j2iukIba = OpenSONAR.VERSION;
			return j2iukIba >= lgfi6s7X;
		} catch (UnknownHostException aT0PXbEu) {
			System.out.println("Unknown Host!!!");
			return false;
		} catch (Exception qlZrmfjn) {
			System.out.println("Can't decide latest version");
			qlZrmfjn.printStackTrace();
			return false;
		}
	}

}