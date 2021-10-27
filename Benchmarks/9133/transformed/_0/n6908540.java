class n6908540 {
	public void create_list() {
		try {
			String DXKMAQAY = URLEncoder.encode("PHPSESSID", "UTF-8") + "="
					+ URLEncoder.encode(this.get_session(), "UTF-8");
			URL nCxQ9kLc = new URL(URL_LOLA + FILE_CREATE_LIST);
			URLConnection utpN3wAC = nCxQ9kLc.openConnection();
			utpN3wAC.setDoOutput(true);
			OutputStreamWriter XVIDLAW2 = new OutputStreamWriter(utpN3wAC.getOutputStream());
			XVIDLAW2.write(DXKMAQAY);
			XVIDLAW2.flush();
			BufferedReader VzzcfAu1 = new BufferedReader(new InputStreamReader(utpN3wAC.getInputStream()));
			String DioSXKos;
			DioSXKos = VzzcfAu1.readLine();
			XVIDLAW2.close();
			VzzcfAu1.close();
			System.out.println("Gene list saved in LOLA");
		} catch (Exception AXsiLsjC) {
			System.out.println("error in createList()");
			AXsiLsjC.printStackTrace();
		}
	}

}