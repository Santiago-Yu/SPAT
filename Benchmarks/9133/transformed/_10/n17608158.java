class n17608158 {
	public static void main(String[] args) {
		DeflaterOutputStream out;
		FileInputStream in;
		FileDialog fd;
		FileOutputStream fos;
		fd = new FileDialog(new Frame(), "Find a file to deflate", FileDialog.LOAD);
		fd.show();
		if (fd.getFile() != null) {
			try {
				fos = new FileOutputStream(new File("Deflated.out"));
				in = new FileInputStream(new File(fd.getDirectory(), fd.getFile()));
				int bytes_read = 0;
				out = new DeflaterOutputStream(fos, new Deflater(Deflater.DEFLATED, true));
				byte[] buffer = new byte[1024];
				while ((bytes_read = in.read(buffer)) != -1) {
					out.write(buffer, 0, bytes_read);
				}
				fos.flush();
				fos.close();
				out.flush();
				out.close();
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Done");
		}
	}

}