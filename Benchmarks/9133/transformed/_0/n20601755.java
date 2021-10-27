class n20601755 {
	public static File copyFile(File SAZ8NVp0) {
		File VL9qh4MN = SAZ8NVp0;
		File djQXBG6A = new File(VL9qh4MN.getName());
		try {
			if (!djQXBG6A.exists()) {
				djQXBG6A.createNewFile();
			}
			FileChannel XjnIPFwG = new FileInputStream(VL9qh4MN).getChannel();
			FileChannel RBUYGozF = new FileOutputStream(djQXBG6A).getChannel();
			RBUYGozF.transferFrom(XjnIPFwG, 0, XjnIPFwG.size());
			XjnIPFwG.close();
			RBUYGozF.close();
		} catch (FileNotFoundException vOnUz3Ab) {
			vOnUz3Ab.printStackTrace();
		} catch (IOException qWQpoceA) {
			qWQpoceA.printStackTrace();
		}
		return djQXBG6A;
	}

}