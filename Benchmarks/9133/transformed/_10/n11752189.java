class n11752189 {
	public static void main(String[] args) {
		boolean proceed = true;
		FileDialog fd = new FileDialog(new Frame(), "Find a .def file", FileDialog.LOAD);
		DataInputStream dis;
		String input = "";
		InputStream in;
		OutputStream out;
		byte[] buffer = new byte[2048];
		File out_file, in_file;
		int bytes_read;
		while (proceed) {
			fd.show();
			if (fd.getFile() != null) {
				try {
					in_file = new File(fd.getDirectory(), fd.getFile());
					out_file = new File(fd.getDirectory(), fd.getFile() + ".out");
					in = new MSZipInputStream(new FileInputStream(in_file));
					out = new FileOutputStream(out_file);
					while ((bytes_read = in.read(buffer)) != -1)
						out.write(buffer, 0, bytes_read);
					in.close();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Do another (y/n)?");
			dis = new DataInputStream(System.in);
			try {
				input = dis.readLine();
			} catch (Exception blah) {
			}
			if (input.toLowerCase().startsWith("n"))
				proceed = false;
		}
	}

}