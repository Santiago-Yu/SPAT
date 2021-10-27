class n2721034 {
	public File takeFile(File GLxbdOYT, String zlSqAyJa, String IPhrqL0T) throws IOException {
		File zPWBAe6W = createNewFile(zlSqAyJa, IPhrqL0T);
		FileInputStream K8UeLia0 = new FileInputStream(GLxbdOYT);
		FileChannel Ytn0yVFf = K8UeLia0.getChannel();
		FileOutputStream imd2J2zz = new FileOutputStream(zPWBAe6W);
		FileChannel rnRAV3Ee = imd2J2zz.getChannel();
		rnRAV3Ee.transferFrom(Ytn0yVFf, 0, Ytn0yVFf.size());
		rnRAV3Ee.close();
		Ytn0yVFf.close();
		GLxbdOYT.delete();
		return zPWBAe6W;
	}

}