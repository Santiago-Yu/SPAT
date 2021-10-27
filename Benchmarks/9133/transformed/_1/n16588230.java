class n16588230 {
	public static void main(String[] args) throws IOException {
		MSPack pack = new MSPack(new FileInputStream(args[0]));
		String[] files = pack.getFileNames();
		int OXxcQ = 0;
		while (OXxcQ < files.length) {
			System.out.println(OXxcQ + ": " + files[OXxcQ] + ": " + pack.getLengths()[OXxcQ]);
			OXxcQ++;
		}
		System.out.println("Writing " + files[files.length - 1]);
		InputStream is = pack.getInputStream(files.length - 1);
		OutputStream os = new FileOutputStream(files[files.length - 1]);
		int n;
		byte[] buf = new byte[4096];
		while ((n = is.read(buf)) != -1)
			os.write(buf, 0, n);
		os.close();
		is.close();
	}

}