class n19321031 {
	public static ArrayList<String> remoteCall(Map<String, String> Sq2ONEHc) {
		ArrayList<String> DXAH994k = new ArrayList<String>();
		String dW3Th61k = "";
		for (String HrtwAfGi : Sq2ONEHc.keySet()) {
			String eFXJ9BG5 = "";
			String nRk2Jch7 = Sq2ONEHc.get(HrtwAfGi);
			if (nRk2Jch7 == null)
				continue;
			try {
				eFXJ9BG5 = HrtwAfGi + "=" + URLEncoder.encode(nRk2Jch7, "UTF-8");
			} catch (UnsupportedEncodingException sdWiHXX5) {
				sdWiHXX5.printStackTrace();
			}
			if (dW3Th61k.length() > 0) {
				dW3Th61k += "&";
			}
			dW3Th61k += eFXJ9BG5;
		}
		try {
			URL YSNgJJn5 = new URL(baseURL + dW3Th61k);
			BufferedReader FSfD3xzr = new BufferedReader(new InputStreamReader(YSNgJJn5.openStream()));
			String AUETyP64;
			while ((AUETyP64 = FSfD3xzr.readLine()) != null) {
				DXAH994k.add(AUETyP64);
				System.out.println("GOT: " + AUETyP64);
			}
			FSfD3xzr.close();
			DXAH994k.remove(0);
			if (DXAH994k.size() != 0) {
				if (!DXAH994k.get(DXAH994k.size() - 1).equals("DONE")) {
					DXAH994k.clear();
				} else {
					DXAH994k.remove(DXAH994k.size() - 1);
				}
			}
		} catch (MalformedURLException gRsuehsT) {
		} catch (IOException vkbGKXdt) {
		}
		return DXAH994k;
	}

}