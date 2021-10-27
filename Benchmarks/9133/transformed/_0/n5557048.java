class n5557048 {
	private void copyDirContent(String L7i6YoKt, String DeEIkvjj) throws Exception {
		String JafWm2Sc = System.getProperty("file.separator");
		File[] vkSgfUid = new File(L7i6YoKt).listFiles();
		if (vkSgfUid == null) {
			throw new FileNotFoundException("Sourcepath: " + L7i6YoKt + " not found!");
		}
		for (int WMsXUN6j = 0; WMsXUN6j < vkSgfUid.length; WMsXUN6j++) {
			File pjDhxbjm = new File(DeEIkvjj);
			pjDhxbjm.mkdirs();
			if (vkSgfUid[WMsXUN6j].isFile()) {
				try {
					FileChannel XY2OAao6 = new FileInputStream(vkSgfUid[WMsXUN6j]).getChannel();
					FileChannel nZ09L7ia = new FileOutputStream(DeEIkvjj + JafWm2Sc + vkSgfUid[WMsXUN6j].getName())
							.getChannel();
					nZ09L7ia.transferFrom(XY2OAao6, 0, XY2OAao6.size());
					XY2OAao6.close();
					nZ09L7ia.close();
				} catch (Exception rWwaFezE) {
					Logger.ERROR("Error during file copy: " + rWwaFezE.getMessage());
					throw rWwaFezE;
				}
			}
		}
	}

}