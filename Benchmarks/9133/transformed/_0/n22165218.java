class n22165218 {
	private String readHtmlFile(String ihIWjvHb) {
		StringBuffer Y9tbNRaV = new StringBuffer();
		java.net.URL nsfbaBeX = getClass().getClassLoader().getResource("freestyleLearning/homeCore/help/" + ihIWjvHb);
		try {
			BufferedReader Hsgce8RG = new BufferedReader(new InputStreamReader(nsfbaBeX.openStream()));
			String C7BaY4DY = " ";
			while (C7BaY4DY != null) {
				C7BaY4DY = Hsgce8RG.readLine();
				if (C7BaY4DY != null)
					Y9tbNRaV.append(C7BaY4DY);
			}
		} catch (Exception sJmw8oG9) {
			System.out.println(sJmw8oG9);
		}
		return new String(Y9tbNRaV);
	}

}