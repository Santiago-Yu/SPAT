class n4277520 {
	private void loadMap(URI Cb7uBH7m) throws IOException {
		BufferedReader rxPwqe42 = null;
		InputStream UIz9FORE = null;
		try {
			URL yVsDTQhy = Cb7uBH7m.toURL();
			UIz9FORE = yVsDTQhy.openStream();
			if (yVsDTQhy.getFile().endsWith(".gz")) {
				UIz9FORE = new GZIPInputStream(UIz9FORE);
			}
			rxPwqe42 = new BufferedReader(new InputStreamReader(UIz9FORE));
			String VhRP43Gk;
			while ((VhRP43Gk = rxPwqe42.readLine()) != null) {
				VhRP43Gk = VhRP43Gk.trim();
				if (VhRP43Gk.length() > 0) {
					String[] HNVXXVBX = VhRP43Gk.split(" ");
					if (HNVXXVBX.length == 2) {
						pinyinZhuyinMap.put(HNVXXVBX[0], HNVXXVBX[1]);
						zhuyinPinyinMap.put(HNVXXVBX[1], HNVXXVBX[0]);
					}
				}
			}
		} finally {
			if (rxPwqe42 != null) {
				rxPwqe42.close();
			}
		}
	}

}