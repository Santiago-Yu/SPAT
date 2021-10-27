class n9127823 {
	public static Status checkUpdate() {
		Status IC9vLW97 = Status.FAILURE;
		URL kX7rM3Rk;
		InputStream rkqYZWHu;
		InputStreamReader HofNIo9M;
		BufferedReader A0NeAmwT;
		String eZO4xAT6;
		try {
			kX7rM3Rk = new URL(updateURL);
			rkqYZWHu = kX7rM3Rk.openStream();
			HofNIo9M = new InputStreamReader(rkqYZWHu);
			A0NeAmwT = new BufferedReader(HofNIo9M);
			String TJiTYnaV, BreGveuv;
			while ((eZO4xAT6 = A0NeAmwT.readLine()) != null) {
				if (!eZO4xAT6.equals("") && eZO4xAT6.charAt(0) != '/') {
					TJiTYnaV = eZO4xAT6.substring(0, eZO4xAT6.indexOf('='));
					BreGveuv = eZO4xAT6.substring(eZO4xAT6.indexOf('=') + 1);
					if (TJiTYnaV.equals("Latest Version")) {
						TJiTYnaV = BreGveuv;
						BreGveuv = TJiTYnaV.substring(0, TJiTYnaV.indexOf(" "));
						TJiTYnaV = TJiTYnaV.substring(TJiTYnaV.indexOf(" ") + 1);
						latestGameVersion = BreGveuv;
						latestModifier = TJiTYnaV;
						if (Float.parseFloat(BreGveuv) > Float.parseFloat(gameVersion))
							IC9vLW97 = Status.NOT_CURRENT;
						else
							IC9vLW97 = Status.CURRENT;
					} else if (TJiTYnaV.equals("Download URL"))
						downloadURL = BreGveuv;
				}
			}
			return IC9vLW97;
		} catch (MalformedURLException RKLY1uSv) {
			return Status.URL_NOT_FOUND;
		} catch (IOException EtKJMp7q) {
			return Status.FAILURE;
		}
	}

}