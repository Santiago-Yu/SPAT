class n18880060 {
	public static boolean copy(File S13hWH5a, File o9sfWlyu) {
		try {
			if (!S13hWH5a.exists())
				return false;
			o9sfWlyu.getParentFile().mkdirs();
			InputStream DfZiLjgt = new FileInputStream(S13hWH5a);
			OutputStream SLjBFYny = new FileOutputStream(o9sfWlyu);
			byte[] EJ7Gp0JK = new byte[1024];
			int oAooOhI7;
			while ((oAooOhI7 = DfZiLjgt.read(EJ7Gp0JK)) > 0)
				SLjBFYny.write(EJ7Gp0JK, 0, oAooOhI7);
			DfZiLjgt.close();
			SLjBFYny.close();
			return true;
		} catch (Exception hj091Hv1) {
			hj091Hv1.printStackTrace();
			return false;
		}
	}

}