class n19483244 {
	public static void copyFile(String blYEMrjE, String We0erZ80) throws Exception {
		File LJxedYJU = new File(blYEMrjE);
		File Vf3oiWjb = new File(We0erZ80);
		if (!LJxedYJU.exists())
			throw new Exception("File with path " + blYEMrjE + " does not exist.");
		if (Vf3oiWjb.exists())
			throw new Exception("File with path " + We0erZ80 + " already exists.");
		FileReader KCi2Wca8 = new FileReader(LJxedYJU);
		FileWriter Fg1sO7VK = new FileWriter(Vf3oiWjb);
		int UHOuTBQw;
		while ((UHOuTBQw = KCi2Wca8.read()) != -1)
			Fg1sO7VK.write(UHOuTBQw);
		KCi2Wca8.close();
		Fg1sO7VK.close();
	}

}