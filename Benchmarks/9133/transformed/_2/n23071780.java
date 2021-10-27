class n23071780 {
	public boolean copyFile(File source, File dest) {
		try {
			FileReader in = new FileReader(source);
			FileWriter out = new FileWriter(dest);
			int c;
			for (; (c = in.read()) != -1;)
				out.write(c);
			in.close();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}