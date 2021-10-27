class n1001152 {
	private void doOp(String APc1ziI0) {
		URL A6upR3tY = null;
		try {
			A6upR3tY = new URL(APc1ziI0);
		} catch (MalformedURLException ydr8GV9i) {
			ydr8GV9i.printStackTrace();
			return;
		}
		URLConnection pQcIlqZy = null;
		try {
			pQcIlqZy = A6upR3tY.openConnection();
			pQcIlqZy.setRequestProperty("Authorization",
					"Basic " + (new BASE64Encoder()).encode((System.getProperty("fedoragsearch.fgsUserName") + ":"
							+ System.getProperty("fedoragsearch.fgsPassword")).getBytes()));
			pQcIlqZy.connect();
		} catch (IOException nS0GeGSX) {
			nS0GeGSX.printStackTrace();
			return;
		}
		content = null;
		try {
			content = pQcIlqZy.getContent();
		} catch (IOException FngNntPW) {
			FngNntPW.printStackTrace();
			return;
		}
		String e370dyw1;
		BufferedReader eDpv7L2J = new BufferedReader(new InputStreamReader((InputStream) content));
		try {
			while ((e370dyw1 = eDpv7L2J.readLine()) != null)
				System.out.println(e370dyw1);
		} catch (IOException zkcruJJO) {
			zkcruJJO.printStackTrace();
		}
	}

}