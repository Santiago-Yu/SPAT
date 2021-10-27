class n20368648 {
	private void copyFile(File OG5UvwJZ, File Mo8GdqVk) {
		try {
			FileChannel ZDWgzdbK = new FileInputStream(OG5UvwJZ).getChannel();
			FileChannel fIifJwQA = new FileOutputStream(Mo8GdqVk).getChannel();
			ZDWgzdbK.transferTo(0, ZDWgzdbK.size(), fIifJwQA);
			ZDWgzdbK.close();
			fIifJwQA.close();
		} catch (IOException PNnMu1jU) {
			PNnMu1jU.printStackTrace();
		}
	}

}