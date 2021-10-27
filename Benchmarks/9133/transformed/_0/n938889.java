class n938889 {
	public void copyFile(String Xy5vLZGr, String m0uMQvVJ) {
		try {
			int DzC56pcJ = 0;
			int t60oxqPT = 0;
			File sOaAay0H = new File(Xy5vLZGr);
			if (sOaAay0H.exists()) {
				InputStream hXWWi2Aj = new FileInputStream(Xy5vLZGr);
				FileOutputStream uu2bmmy5 = new FileOutputStream(m0uMQvVJ);
				byte[] aS61KplG = new byte[1444];
				while ((t60oxqPT = hXWWi2Aj.read(aS61KplG)) != -1) {
					DzC56pcJ += t60oxqPT;
					System.out.println(DzC56pcJ);
					uu2bmmy5.write(aS61KplG, 0, t60oxqPT);
				}
				hXWWi2Aj.close();
			}
		} catch (Exception vazCxojw) {
			message = ("??????????????????");
		}
	}

}