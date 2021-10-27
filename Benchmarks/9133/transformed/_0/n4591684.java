class n4591684 {
	public static void copyDirs(File e5nJXrSj, File jigJ2dM8) throws IOException {
		if (!jigJ2dM8.exists())
			jigJ2dM8.mkdirs();
		for (File J8IUWSUJ : e5nJXrSj.listFiles()) {
			if (J8IUWSUJ.isDirectory()) {
				copyDirs(J8IUWSUJ, new File(jigJ2dM8, J8IUWSUJ.getName()));
			} else {
				FileChannel GzNftCQy = new FileInputStream(J8IUWSUJ).getChannel();
				File YVSPw6q2 = new File(jigJ2dM8, J8IUWSUJ.getName());
				YVSPw6q2.createNewFile();
				FileChannel dsqCUfKd = new FileOutputStream(YVSPw6q2).getChannel();
				dsqCUfKd.transferFrom(GzNftCQy, 0, GzNftCQy.size());
				GzNftCQy.close();
				dsqCUfKd.close();
			}
		}
	}

}