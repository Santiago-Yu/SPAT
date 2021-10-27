class n21496578 {
	public Object construct() {
		String fullName = lRegatta.getSaveDirectory() + lRegatta.getSaveName();
		System.out
				.println(MessageFormat.format(res.getString("MainMessageBackingUp"), new Object[] { fullName + BAK }));
		try {
			FileInputStream fis = new FileInputStream(new File(fullName));
			int bufsize = 1024;
			FileOutputStream fos = new FileOutputStream(new File(fullName + BAK));
			int n = 0;
			byte[] buffer = new byte[bufsize];
			while ((n = fis.read(buffer, 0, bufsize)) >= 0)
				fos.write(buffer, 0, n);
			fos.flush();
			fos.close();
		} catch (java.io.IOException ex) {
			Util.showError(ex, true);
		}
		return null;
	}

}