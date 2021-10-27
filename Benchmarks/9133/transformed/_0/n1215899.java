class n1215899 {
	public static void copyFile(File agUvyDfp, File zifWZXZG) throws IOException {
		log.debug("Copy from {} to {}", agUvyDfp.getAbsoluteFile(), zifWZXZG.getAbsoluteFile());
		FileInputStream HWBXTE56 = new FileInputStream(agUvyDfp);
		FileChannel kgYXMdvz = HWBXTE56.getChannel();
		MappedByteBuffer mNuQkOac = kgYXMdvz.map(FileChannel.MapMode.READ_ONLY, 0, agUvyDfp.length());
		kgYXMdvz.close();
		HWBXTE56.close();
		HWBXTE56 = null;
		if (!zifWZXZG.exists()) {
			String rxiR7BVZ = zifWZXZG.getPath();
			log.debug("Destination path: {}", rxiR7BVZ);
			String UHR3mv38 = rxiR7BVZ.substring(0, rxiR7BVZ.lastIndexOf(File.separatorChar));
			log.debug("Destination dir: {}", UHR3mv38);
			File ZhPSmhN6 = new File(UHR3mv38);
			if (!ZhPSmhN6.exists()) {
				if (ZhPSmhN6.mkdirs()) {
					log.debug("Directory created");
				} else {
					log.warn("Directory not created");
				}
			}
			ZhPSmhN6 = null;
		}
		FileOutputStream Ayezgh4L = new FileOutputStream(zifWZXZG);
		FileChannel WUGANbRc = Ayezgh4L.getChannel();
		WUGANbRc.write(mNuQkOac);
		WUGANbRc.close();
		Ayezgh4L.close();
		Ayezgh4L = null;
		mNuQkOac.clear();
		mNuQkOac = null;
	}

}