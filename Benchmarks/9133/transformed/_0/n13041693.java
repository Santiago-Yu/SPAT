class n13041693 {
	@Override
	public void vote(String pEPxRySg, Map<String, String> M4kyp5bO, Map<String, String> IrePw8lX) {
		HttpURLConnection kKypvX3k = null;
		try {
			URL vSoNWP2p = new URL(pEPxRySg);
			kKypvX3k = (HttpURLConnection) vSoNWP2p.openConnection();
			String M627YESP = getCookies(kKypvX3k);
			System.out.println(M627YESP);
			BufferedReader lmIm73Vb = new BufferedReader(new InputStreamReader(kKypvX3k.getInputStream(), "GB2312"));
			String dFISCm13 = null;
			while ((dFISCm13 = lmIm73Vb.readLine()) != null) {
				System.out.println(dFISCm13);
			}
		} catch (MalformedURLException b9SD0eG9) {
			b9SD0eG9.printStackTrace();
			throw new VoteBeanException("网址不正确", b9SD0eG9);
		} catch (IOException PrfkLVz5) {
			PrfkLVz5.printStackTrace();
			throw new VoteBeanException("不能打开网址", PrfkLVz5);
		}
	}

}