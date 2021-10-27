class n6185786 {
	protected void copyFile(File UUz5neD5, File G1Bo1aKx) throws IOException {
		G1Bo1aKx.getParentFile().mkdirs();
		InputStream Z6QAvkB3 = new FileInputStream(UUz5neD5);
		try {
			OutputStream WSVPN9lm = new FileOutputStream(G1Bo1aKx);
			try {
				byte[] hKcz2zMQ = new byte[1024];
				int hqvKGa3w;
				while ((hqvKGa3w = Z6QAvkB3.read(hKcz2zMQ)) > 0) {
					WSVPN9lm.write(hKcz2zMQ, 0, hqvKGa3w);
				}
			} finally {
				WSVPN9lm.close();
			}
		} finally {
			Z6QAvkB3.close();
		}
	}

}