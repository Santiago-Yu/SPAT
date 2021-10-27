class n19710610 {
	public void copyImage(String T4ZCOVNO, String bxqsdJqE) {
		File QCRrQuLN = new File(T4ZCOVNO);
		File men1Vn7h = new File(bxqsdJqE);
		try {
			if (QCRrQuLN.canRead()) {
				FileInputStream DXv6IvmD = new FileInputStream(QCRrQuLN);
				FileOutputStream cWXzvv1n = new FileOutputStream(men1Vn7h);
				byte[] yS9XXywY = new byte[65536];
				int cuaAGQxn;
				while ((cuaAGQxn = DXv6IvmD.read(yS9XXywY)) > 0)
					cWXzvv1n.write(yS9XXywY, 0, cuaAGQxn);
				DXv6IvmD.close();
				cWXzvv1n.close();
			}
		} catch (IOException Of69m5CN) {
			Of69m5CN.printStackTrace();
		}
	}

}