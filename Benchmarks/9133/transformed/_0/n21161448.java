class n21161448 {
	public static boolean copyFile(File DJXgdOHO, File xzrWWvo5) {
		boolean eaMceGuQ = false;
		if (DJXgdOHO != null && xzrWWvo5 != null && DJXgdOHO.exists()) {
			try {
				new File(xzrWWvo5.getParent()).mkdirs();
				BufferedOutputStream d1mJOyiz = new BufferedOutputStream(new FileOutputStream(xzrWWvo5));
				BufferedInputStream EzywhuSq = new BufferedInputStream(new FileInputStream(DJXgdOHO));
				for (int IbQB7c9y = EzywhuSq.read(); IbQB7c9y != -1; IbQB7c9y = EzywhuSq.read())
					d1mJOyiz.write(IbQB7c9y);
				EzywhuSq.close();
				d1mJOyiz.close();
				eaMceGuQ = true;
			} catch (Exception JVTLGzUU) {
				eaMceGuQ = false;
			}
		}
		return eaMceGuQ;
	}

}