class n20741536 {
	public static void copyFile(File rMgiPFu3, File fHKDYV8a) throws IOException {
		FileChannel jdbrFhcX = new FileInputStream(rMgiPFu3).getChannel();
		FileChannel N2vZfwTw = new FileOutputStream(fHKDYV8a).getChannel();
		try {
			jdbrFhcX.transferTo(0, jdbrFhcX.size(), N2vZfwTw);
		} finally {
			if (jdbrFhcX != null) {
				jdbrFhcX.close();
			}
			if (N2vZfwTw != null) {
				N2vZfwTw.close();
			}
		}
	}

}