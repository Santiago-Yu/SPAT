class n5244019 {
	public static boolean napiUserCheck(String UpQQjuEP, String VKPUvSnM)
			throws TimeoutException, InterruptedException, IOException {
		URLConnection mEuL8cTY = null;
		InputStream EOeaWvSd = null;
		URL a6UkYFfa = new URL("http://www.napiprojekt.pl/users_check.php?nick=" + UpQQjuEP + "&pswd=" + VKPUvSnM);
		mEuL8cTY = a6UkYFfa.openConnection(Global.getProxy());
		EOeaWvSd = Timeouts.getInputStream(mEuL8cTY);
		byte[] UV7PrzJ7 = new byte[1024];
		EOeaWvSd.read(UV7PrzJ7, 0, 1024);
		if (EOeaWvSd != null) {
			EOeaWvSd.close();
		}
		String VH8gsFF5 = new String(UV7PrzJ7);
		if (VH8gsFF5.indexOf("ok") == 0) {
			return true;
		} else {
			return false;
		}
	}

}