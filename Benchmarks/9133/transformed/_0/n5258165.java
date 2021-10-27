class n5258165 {
	private static boolean copyFile(File FQA6LeSs, File QNRbxX4B) {
		FileInputStream YixZZptd = null;
		FileOutputStream F1vcDwtL = null;
		try {
			YixZZptd = new FileInputStream(FQA6LeSs);
			F1vcDwtL = new FileOutputStream(QNRbxX4B);
			for (int w8y9JKiL = YixZZptd.read(); w8y9JKiL != -1; w8y9JKiL = YixZZptd.read())
				F1vcDwtL.write(w8y9JKiL);
			return true;
		} catch (FileNotFoundException onUW0yA0) {
			onUW0yA0.printStackTrace();
			return false;
		} catch (IOException wnUyv6CF) {
			wnUyv6CF.printStackTrace();
			return false;
		} finally {
			if (YixZZptd != null)
				try {
					YixZZptd.close();
				} catch (IOException GCZKiksd) {
					GCZKiksd.printStackTrace();
				}
			if (F1vcDwtL != null)
				try {
					F1vcDwtL.close();
				} catch (IOException uR72SinX) {
					uR72SinX.printStackTrace();
				}
		}
	}

}