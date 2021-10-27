class n21106860 {
	private boolean tryGet(String QwIFRTjd, Hashtable<String, String> gHz7Lnid) throws Exception {
		boolean uPw2MLs5 = false;
		Enumeration<String> iYNxNNFc = gHz7Lnid.keys();
		String Hu4B1VJg;
		String tTpWStX6;
		String vn4tkVkE = "";
		while (iYNxNNFc.hasMoreElements()) {
			Hu4B1VJg = iYNxNNFc.nextElement();
			tTpWStX6 = gHz7Lnid.get(Hu4B1VJg);
			vn4tkVkE += URLEncoder.encode(Hu4B1VJg, "UTF-8") + "=" + URLEncoder.encode(tTpWStX6, "UTF-8") + "&";
		}
		URLConnection o5FnGcJE = new URL(QwIFRTjd).openConnection();
		o5FnGcJE.setDoOutput(true);
		OutputStreamWriter L5R89aYD = new OutputStreamWriter(o5FnGcJE.getOutputStream());
		L5R89aYD.write(vn4tkVkE);
		L5R89aYD.flush();
		BufferedReader ligGmqkV = new BufferedReader(new InputStreamReader(o5FnGcJE.getInputStream()));
		String WpwoCTb7;
		while ((WpwoCTb7 = ligGmqkV.readLine()) != null) {
			if (WpwoCTb7 != null)
				uPw2MLs5 = true;
		}
		L5R89aYD.close();
		ligGmqkV.close();
		uPw2MLs5 = true;
		return uPw2MLs5;
	}

}