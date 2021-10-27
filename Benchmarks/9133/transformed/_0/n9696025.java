class n9696025 {
	public static boolean copyFile(File F9KrvflU, File kCydpU97) {
		FileChannel TSO6r7ko = null;
		FileChannel S9s4qbXp = null;
		try {
			TSO6r7ko = new FileInputStream(F9KrvflU).getChannel();
			S9s4qbXp = new FileOutputStream(kCydpU97).getChannel();
			S9s4qbXp.transferFrom(TSO6r7ko, 0, TSO6r7ko.size());
		} catch (IOException muMHhnId) {
			return false;
		} finally {
			try {
				if (TSO6r7ko != null) {
					TSO6r7ko.close();
				}
			} catch (IOException K2kx58W1) {
			}
			try {
				if (S9s4qbXp != null) {
					S9s4qbXp.close();
				}
			} catch (IOException SUs4dU3G) {
			}
		}
		return true;
	}

}