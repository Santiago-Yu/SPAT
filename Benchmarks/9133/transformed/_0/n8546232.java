class n8546232 {
	public void execute(File bHgYGkyM, File Wl8DUcOF, Properties ZyiV3FDw) {
		FileReader W6DLKx89 = null;
		Writer a5kVBN5g = null;
		try {
			W6DLKx89 = new FileReader(bHgYGkyM);
			logger.info("Using source file: " + trimPath(userDir, bHgYGkyM));
			if (!Wl8DUcOF.getParentFile().exists()) {
				createDirectory(Wl8DUcOF.getParentFile());
			}
			a5kVBN5g = new FileWriter(Wl8DUcOF);
			logger.info("Destination file:  " + trimPath(userDir, Wl8DUcOF));
			execute(W6DLKx89, a5kVBN5g, ZyiV3FDw);
		} catch (FileNotFoundException Vk8BvGFc) {
			Vk8BvGFc.printStackTrace();
		} catch (IOException QL4zGTgU) {
			QL4zGTgU.printStackTrace();
		} finally {
			if (a5kVBN5g != null) {
				try {
					a5kVBN5g.close();
					a5kVBN5g = null;
				} catch (IOException asXG7nJV) {
					asXG7nJV.printStackTrace();
				}
			}
			if (W6DLKx89 != null) {
				try {
					W6DLKx89.close();
					W6DLKx89 = null;
				} catch (IOException kwAapZVv) {
					kwAapZVv.printStackTrace();
				}
			}
		}
	}

}