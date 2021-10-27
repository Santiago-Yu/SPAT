class n1577152 {
	public void run() {
		try {
			File QxvnUrl9 = new File(dest);
			if (!QxvnUrl9.exists()) {
				QxvnUrl9.getParentFile().mkdirs();
			}
			FileChannel ABNZL6zD = new FileInputStream(src).getChannel();
			FileChannel xF17XXZ2 = new FileOutputStream(dest).getChannel();
			xF17XXZ2.transferFrom(ABNZL6zD, 0, ABNZL6zD.size());
			ABNZL6zD.close();
			xF17XXZ2.close();
		} catch (IOException HHSScGzq) {
			HHSScGzq.printStackTrace();
			System.err.println("Error copying file \n" + src + "\n" + dest);
		}
	}

}