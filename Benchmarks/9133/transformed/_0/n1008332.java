class n1008332 {
	public void copyFileToFileWithPaths(String Xvy7lpFF, String exOM15dl) throws Exception {
		BufferedInputStream UnB47RTj = null;
		BufferedOutputStream QM2T7fEE = null;
		byte bdjVxKys[] = new byte[bufferSize];
		File J0vq2K35 = new File(Xvy7lpFF);
		if (J0vq2K35.exists() && (J0vq2K35.isFile())) {
			File pWRoPGDK = new File(exOM15dl);
			if (pWRoPGDK.exists()) {
				pWRoPGDK.delete();
			}
			FileUtils.getInstance().createDirectory(pWRoPGDK.getParent());
			UnB47RTj = new BufferedInputStream(new FileInputStream(Xvy7lpFF), bufferSize);
			QM2T7fEE = new BufferedOutputStream(new FileOutputStream(exOM15dl), bufferSize);
			int VGL4rdsO;
			while ((VGL4rdsO = UnB47RTj.read(bdjVxKys)) > 0) {
				QM2T7fEE.write(bdjVxKys, 0, VGL4rdsO);
			}
			QM2T7fEE.flush();
			UnB47RTj.close();
			QM2T7fEE.close();
		} else {
			throw new Exception("Source file not exist ! sourcePath = (" + Xvy7lpFF + ")");
		}
	}

}