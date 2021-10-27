class n23071780 {
	public boolean copyFile(File source, File dest) {
		try {
			FileWriter out = new FileWriter(dest);
			FileReader in = new FileReader(source);
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}