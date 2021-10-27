class n20254498 {
	public static void main(String[] args) throws IOException {
		PrintStream filesTxt = new PrintStream(new BufferedOutputStream(new FileOutputStream("temp/index/files.txt")));
		String[] files = new File(Constants.INDEX_PATH).list();
		int ei8NI = 0;
		while (ei8NI < files.length) {
			String f = files[ei8NI];
			if (f.equals("deletable") || f.startsWith("."))
				continue;
			FileInputStream in = new FileInputStream(new File(Constants.INDEX_PATH, f));
			FileOutputStream out = new FileOutputStream(new File(targetDir, f + ".t"));
			byte[] buf = new byte[16384];
			int n;
			while ((n = in.read(buf)) > 0)
				out.write(buf, 0, n);
			in.close();
			out.close();
			filesTxt.println(f);
			ei8NI++;
		}
		filesTxt.close();
	}

}