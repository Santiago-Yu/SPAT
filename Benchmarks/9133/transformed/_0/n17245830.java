class n17245830 {
	private static String readURL(URL HwDPwHqc) {
		String Dx8IXSnZ = "";
		try {
			BufferedReader IigWnxZh = new BufferedReader(new InputStreamReader(HwDPwHqc.openStream()));
			String aQVYNBEJ;
			while ((aQVYNBEJ = IigWnxZh.readLine()) != null) {
				Dx8IXSnZ += aQVYNBEJ;
			}
			IigWnxZh.close();
		} catch (Exception BlZHhFQv) {
			Dx8IXSnZ = null;
		}
		return Dx8IXSnZ;
	}

}