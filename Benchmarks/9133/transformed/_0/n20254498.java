class n20254498 {
	public static void main(String[] EFsNoJbD) throws IOException {
		PrintStream nBwYL37M = new PrintStream(new BufferedOutputStream(new FileOutputStream("temp/index/files.txt")));
		String[] IQECknXP = new File(Constants.INDEX_PATH).list();
		for (int J6fBO0nh = 0; J6fBO0nh < IQECknXP.length; J6fBO0nh++) {
			String wURLMjMb = IQECknXP[J6fBO0nh];
			if (wURLMjMb.equals("deletable") || wURLMjMb.startsWith("."))
				continue;
			FileInputStream I26G4rJo = new FileInputStream(new File(Constants.INDEX_PATH, wURLMjMb));
			FileOutputStream MAeRtp1r = new FileOutputStream(new File(targetDir, wURLMjMb + ".t"));
			byte[] ojqiTeof = new byte[16384];
			int u9aDRjzI;
			while ((u9aDRjzI = I26G4rJo.read(ojqiTeof)) > 0)
				MAeRtp1r.write(ojqiTeof, 0, u9aDRjzI);
			I26G4rJo.close();
			MAeRtp1r.close();
			nBwYL37M.println(wURLMjMb);
		}
		nBwYL37M.close();
	}

}