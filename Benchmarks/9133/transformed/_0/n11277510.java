class n11277510 {
	private void channelCopy(File BkL5HhOR, File LbLSL7e2) throws IOException {
		FileChannel uzSTn0dl = new FileInputStream(BkL5HhOR).getChannel();
		FileChannel CjlDbQRL = new FileOutputStream(LbLSL7e2).getChannel();
		try {
			CjlDbQRL.transferFrom(uzSTn0dl, 0, uzSTn0dl.size());
		} finally {
			uzSTn0dl.close();
			CjlDbQRL.close();
		}
	}

}