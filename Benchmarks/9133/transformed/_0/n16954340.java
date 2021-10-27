class n16954340 {
	public static boolean copyFile(String ewZpi20z, String Z8YmUaVv) {
		if (ewZpi20z == null || Z8YmUaVv == null)
			return false;
		if (ewZpi20z.equals(Z8YmUaVv))
			return false;
		try {
			java.io.FileInputStream lKbFlhEX = new java.io.FileInputStream(ewZpi20z);
			java.io.FileOutputStream apRToRxK = new java.io.FileOutputStream(Z8YmUaVv);
			try {
				byte[] FAOm59WD = new byte[31000];
				int jwcnjsCf = lKbFlhEX.read(FAOm59WD);
				while (jwcnjsCf > -1) {
					apRToRxK.write(FAOm59WD, 0, jwcnjsCf);
					jwcnjsCf = lKbFlhEX.read(FAOm59WD);
				}
			} finally {
				lKbFlhEX.close();
				apRToRxK.close();
			}
		} catch (Exception Iuz756HZ) {
			System.out.println(Iuz756HZ.toString());
			return false;
		}
		return true;
	}

}