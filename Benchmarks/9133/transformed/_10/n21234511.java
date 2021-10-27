class n21234511 {
	public static void unzip(String destDir, String zipPath) {
		int read = 0;
		PrintWriter stdout = new PrintWriter(System.out, true);
		ZipEntry entry;
		byte[] data = new byte[1024];
		try {
			ZipInputStream in = new ZipInputStream(new FileInputStream(zipPath));
			stdout.println(zipPath);
			while ((entry = in.getNextEntry()) != null) {
				if (entry.getMethod() == ZipEntry.DEFLATED) {
					stdout.println("  Inflating: " + entry.getName());
				} else {
					stdout.println(" Extracting: " + entry.getName());
				}
				FileOutputStream out = new FileOutputStream(destDir + File.separator + entry.getName());
				while ((read = in.read(data, 0, 1024)) != -1) {
					out.write(data, 0, read);
				}
				out.close();
			}
			in.close();
			stdout.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}