class n11404629 {
	public static File downloadFromUrl(String ZBsCDNIl, String ajDlrWrl) throws Exception {
		URL rswB2nUX = new URL(ZBsCDNIl);
		InputStream kR4CbJxx = rswB2nUX.openStream();
		byte pLpYpV9s[] = new byte[20480];
		File UkD6g57d = File.createTempFile("temp_", ajDlrWrl);
		FileOutputStream gJi34wHr = new FileOutputStream(UkD6g57d);
		BufferedOutputStream WLYme58R = new BufferedOutputStream(gJi34wHr);
		int pNRuMyfs = 0;
		int MPw9Rp1P = 0;
		while ((pNRuMyfs = kR4CbJxx.read(pLpYpV9s)) > -1) {
			WLYme58R.write(pLpYpV9s, 0, pNRuMyfs);
			MPw9Rp1P++;
			System.out.println(MPw9Rp1P);
		}
		WLYme58R.close();
		return UkD6g57d;
	}

}