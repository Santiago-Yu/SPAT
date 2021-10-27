class n23594635 {
	private void copyFileToPhotoFolder(File H6GM6j5J, String oFUyWw6Z) {
		try {
			FileChannel VVOIMjbN = new FileInputStream(H6GM6j5J).getChannel();
			File y6Xhmnqb = new File(Constants.PHOTO_DIR);
			if (!y6Xhmnqb.exists()) {
				y6Xhmnqb.mkdirs();
			}
			File PA7uP0n8 = new File(Constants.PHOTO_DIR + oFUyWw6Z + ".jpg");
			if (!PA7uP0n8.exists()) {
				PA7uP0n8.createNewFile();
			}
			VVOIMjbN.transferTo(0, VVOIMjbN.size(), new FileOutputStream(PA7uP0n8).getChannel());
		} catch (FileNotFoundException FR4nxtcJ) {
			FR4nxtcJ.printStackTrace();
		} catch (IOException tZwJ4r2D) {
			tZwJ4r2D.printStackTrace();
		}
	}

}