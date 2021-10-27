class n11036037 {
	public static void copy(String EKzdLeFl, String E1F0eXtZ) throws IOException {
		int uI1hNVan = 0;
		byte[] Se0wybQ2 = new byte[512];
		FileInputStream Pabl6QNy = null;
		FileOutputStream Pvh3WgaB = null;
		try {
			Pabl6QNy = new FileInputStream(EKzdLeFl);
			try {
				Pvh3WgaB = new FileOutputStream(E1F0eXtZ);
				while ((uI1hNVan = Pabl6QNy.read(Se0wybQ2)) != -1) {
					Pvh3WgaB.write(Se0wybQ2, 0, uI1hNVan);
				}
			} finally {
				try {
					if (Pvh3WgaB != null) {
						Pvh3WgaB.close();
						Pvh3WgaB = null;
					}
				} catch (IOException EcS9aMEb) {
				}
			}
		} finally {
			try {
				if (Pabl6QNy != null) {
					Pabl6QNy.close();
					Pabl6QNy = null;
				}
			} catch (IOException cpLHNFqF) {
			}
		}
	}

}