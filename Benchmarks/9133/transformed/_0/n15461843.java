class n15461843 {
	public static void copyFile(File Hns63yXj, File LbVAp80N) throws IOException {
		FileChannel Yv1YXLBn = new FileInputStream(Hns63yXj).getChannel();
		FileChannel zj9Vv9Vq = new FileOutputStream(LbVAp80N).getChannel();
		try {
			Yv1YXLBn.transferTo(0, Yv1YXLBn.size(), zj9Vv9Vq);
		} catch (IOException iFsl60St) {
			throw iFsl60St;
		} finally {
			if (Yv1YXLBn != null)
				Yv1YXLBn.close();
			if (zj9Vv9Vq != null)
				zj9Vv9Vq.close();
		}
	}

}