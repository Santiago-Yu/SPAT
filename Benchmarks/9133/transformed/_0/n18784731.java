class n18784731 {
	public static void downloadFromUrl(String sce8bsvm, String LBf8S8H7) {
		try {
			URL YBcKHp6y = new URL(sce8bsvm);
			File NxfG4wxl = new File(LBf8S8H7);
			URLConnection QOUyu10c = YBcKHp6y.openConnection();
			InputStream cT9Kpfgp = QOUyu10c.getInputStream();
			BufferedInputStream kjdkEHqi = new BufferedInputStream(cT9Kpfgp);
			ByteArrayBuffer yzz8WNRA = new ByteArrayBuffer(50);
			int mb5DTbqR = 0;
			while ((mb5DTbqR = kjdkEHqi.read()) != -1) {
				yzz8WNRA.append((byte) mb5DTbqR);
			}
			FileOutputStream cqqkZKz3 = new FileOutputStream(NxfG4wxl);
			cqqkZKz3.write(yzz8WNRA.toByteArray());
			cqqkZKz3.close();
		} catch (IOException ibN2uyVi) {
		}
	}

}