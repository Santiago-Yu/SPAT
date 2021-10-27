class n23036596 {
	public static boolean copyfile(String file0, String file1) {
		try {
			File f1 = new File(file1);
			File f0 = new File(file0);
			FileOutputStream out = new FileOutputStream(f1);
			FileInputStream in = new FileInputStream(f0);
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.close();
			out = null;
			in = null;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}