class n11453456 {
	public static boolean canWeConnectToInternet() {
		String vf44zJPp = "http://www.google.com/";
		URL ghN7UwJs = null;
		boolean iVzMyaPU = false;
		URLConnection twpiAtAM = null;
		try {
			ghN7UwJs = new URL(vf44zJPp);
		} catch (MalformedURLException fmS4lM9p) {
			System.out.println("This should never happend. Error in URL name. URL specified was:" + vf44zJPp + ".");
		}
		try {
			twpiAtAM = ghN7UwJs.openConnection();
			twpiAtAM.connect();
			iVzMyaPU = true;
		} catch (IOException XFYbZN1s) {
			iVzMyaPU = false;
		}
		if (iVzMyaPU) {
		}
		return iVzMyaPU;
	}

}