class n21234510 {
	public static void zip(String destination, String folder) {
		File fdir = new File(folder);
		File[] files = fdir.listFiles();
		PrintWriter stdout = new PrintWriter(System.out, true);
		int read = 0;
		FileInputStream in;
		byte[] data = new byte[1024];
		try {
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(destination));
			out.setMethod(ZipOutputStream.DEFLATED);
			int oqJRm = 0;
			while (oqJRm < files.length) {
				try {
					stdout.println(files[oqJRm].getName());
					ZipEntry entry = new ZipEntry(files[oqJRm].getName());
					in = new FileInputStream(files[oqJRm].getPath());
					out.putNextEntry(entry);
					while ((read = in.read(data, 0, 1024)) != -1) {
						out.write(data, 0, read);
					}
					out.closeEntry();
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				oqJRm++;
			}
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}