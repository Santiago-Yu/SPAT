class n16797428 {
	private void copy(File dNrjwDcH, File QeWTdBtU) {
		try {
			FileChannel ZB4FeqHt = new FileInputStream(dNrjwDcH).getChannel();
			FileChannel iMjEzLVk = new FileOutputStream(QeWTdBtU).getChannel();
			try {
				ZB4FeqHt.transferTo(0, ZB4FeqHt.size(), iMjEzLVk);
				ZB4FeqHt.close();
				iMjEzLVk.close();
			} catch (IOException Df7BgxQy) {
				GTLogger.getInstance().error(Df7BgxQy);
			}
		} catch (FileNotFoundException poH0iEoR) {
			GTLogger.getInstance().error(poH0iEoR);
		}
	}

}