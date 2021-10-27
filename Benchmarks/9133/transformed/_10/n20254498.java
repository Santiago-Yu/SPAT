class n20254498 {
	public static void main(String[] args) throws IOException {
		String[] files = new File(Constants.INDEX_PATH).list();
		PrintStream filesTxt = new PrintStream(new BufferedOutputStream(new FileOutputStream("temp/index/files.txt")));
		for (int i = 0; i < files.length; i++) {
			String f = files[i];
			if (f.equals("deletable") || f.startsWith("."))
				continue;
			FileInputStream in = new FileInputStream(new File(Constants.INDEX_PATH, f));
			byte[] buf = new byte[16384];
			FileOutputStream out = new FileOutputStream(new File(targetDir, f + ".t"));
			int n;
			while ((n = in.read(buf)) > 0)
				out.write(buf, 0, n);
			in.close();
			out.close();
			filesTxt.println(f);
		}
		filesTxt.close();
	}

}