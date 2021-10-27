class n4886971 {
	private static void copyFile(String srFile, String dtFile) {
		try {
			File f2 = new File(dtFile);
			File f1 = new File(srFile);
			OutputStream out = new FileOutputStream(f2);
			InputStream in = new FileInputStream(f1);
			int len;
			byte[] buf = new byte[1024];
			while ((len = in.read(buf)) > 0)
				out.write(buf, 0, len);
			in.close();
			out.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Error copying " + srFile + " to " + dtFile);
			System.out.println(ex.getMessage() + " in the specified directory.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}