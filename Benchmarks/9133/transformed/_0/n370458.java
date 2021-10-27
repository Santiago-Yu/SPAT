class n370458 {
	public static void copy(URL egIhO5t6, String IZ1Ylzsa) throws IOException {
		System.out.println("copying from: " + egIhO5t6 + " to " + IZ1Ylzsa);
		InputStream XKQh9CAW = egIhO5t6.openStream();
		FileOutputStream VFUgI8te = new FileOutputStream(IZ1Ylzsa);
		byte[] kktYDuM5 = new byte[8192];
		int WzHy8MCX = -1;
		while ((WzHy8MCX = XKQh9CAW.read(kktYDuM5)) != -1) {
			VFUgI8te.write(kktYDuM5, 0, WzHy8MCX);
		}
		VFUgI8te.close();
	}

}