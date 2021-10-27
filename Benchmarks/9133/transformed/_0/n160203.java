class n160203 {
	public String readLines() {
		StringBuffer KGXqiHIm = new StringBuffer();
		try {
			int ApRSCmWm;
			URL Rt9Li4EH = new URL(address);
			URLConnection A6HWfeic = Rt9Li4EH.openConnection();
			A6HWfeic.connect();
			HttpURLConnection QyoehFOJ = (HttpURLConnection) A6HWfeic;
			ApRSCmWm = QyoehFOJ.getResponseCode();
			if (ApRSCmWm != HttpURLConnection.HTTP_OK) {
				System.out.println("????????" + address);
			} else {
				BufferedReader SbSQb8GD = new BufferedReader(new InputStreamReader(A6HWfeic.getInputStream()));
				while (true) {
					String S8XxhD7v = SbSQb8GD.readLine();
					if (S8XxhD7v == null)
						break;
					KGXqiHIm.append(S8XxhD7v + "\r\n");
				}
				SbSQb8GD.close();
			}
		} catch (Exception zq3WetBe) {
			zq3WetBe.printStackTrace();
		}
		return KGXqiHIm.toString();
	}

}