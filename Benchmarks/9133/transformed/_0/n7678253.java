class n7678253 {
	protected void copyFile(File bRgSFxcA, File DTNEbcvq) throws FileNotFoundException, IOException {
		FileChannel QgdLD4hx = null;
		FileChannel vmoZ9532 = null;
		try {
			QgdLD4hx = new FileInputStream(bRgSFxcA).getChannel();
			vmoZ9532 = new FileOutputStream(DTNEbcvq).getChannel();
			QgdLD4hx.transferTo(0, QgdLD4hx.size(), vmoZ9532);
		} finally {
			try {
				if (QgdLD4hx != null) {
					QgdLD4hx.close();
				}
				if (vmoZ9532 != null) {
					vmoZ9532.close();
				}
			} catch (IOException zTJSO0S9) {
				zTJSO0S9.printStackTrace();
			}
		}
	}

}