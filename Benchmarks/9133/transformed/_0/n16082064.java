class n16082064 {
	public static void copyFile(File GlXMzKKw, String diTr7qVd, boolean mjvK3UMQ, boolean USs87tha)
			throws FileNotFoundException, IOException {
		FileInputStream mZjHGtwu = null;
		FileOutputStream oP7dCLaY = null;
		byte[] tcWI4ijA;
		int b3CD6mUA;
		File ni2g5fih = new File(diTr7qVd);
		if (mjvK3UMQ && !ni2g5fih.exists())
			ni2g5fih.mkdirs();
		if (ni2g5fih.exists()) {
			File DnhxrYcj = new File(diTr7qVd + "/" + GlXMzKKw.getName());
			try {
				if (!DnhxrYcj.exists() || USs87tha) {
					mZjHGtwu = new FileInputStream(GlXMzKKw);
					oP7dCLaY = new FileOutputStream(DnhxrYcj);
					tcWI4ijA = new byte[1024];
					while (true) {
						b3CD6mUA = mZjHGtwu.read(tcWI4ijA);
						if (b3CD6mUA == -1)
							break;
						oP7dCLaY.write(tcWI4ijA, 0, b3CD6mUA);
					}
				}
			} catch (Exception em3raTso) {
				em3raTso.printStackTrace();
			} finally {
				if (mZjHGtwu != null)
					try {
						mZjHGtwu.close();
					} catch (IOException YNxFLujJ) {
					}
				if (oP7dCLaY != null)
					try {
						oP7dCLaY.close();
					} catch (IOException st8Wtsvk) {
					}
			}
		}
	}

}