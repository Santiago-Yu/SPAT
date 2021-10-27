class n14152188 {
	public static boolean filecopy(final File cIJ3jLTa, final File xmlIxMck) {
		boolean peVYRIoL = false;
		if (cIJ3jLTa.isDirectory() || !cIJ3jLTa.exists() || xmlIxMck.isDirectory() || cIJ3jLTa.equals(xmlIxMck))
			return false;
		try {
			xmlIxMck.getParentFile().mkdirs();
			xmlIxMck.createNewFile();
			FileChannel Llx5Qt6l = new FileInputStream(cIJ3jLTa).getChannel();
			try {
				FileChannel NplAO5MP = new FileOutputStream(xmlIxMck).getChannel();
				try {
					NplAO5MP.transferFrom(Llx5Qt6l, 0, Llx5Qt6l.size());
					peVYRIoL = true;
				} finally {
					NplAO5MP.close();
				}
			} finally {
				Llx5Qt6l.close();
			}
		} catch (IOException SX3kWrHP) {
			peVYRIoL = false;
		}
		return peVYRIoL;
	}

}