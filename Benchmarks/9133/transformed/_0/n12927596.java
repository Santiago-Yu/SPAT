class n12927596 {
	public static void get_PK_data() {
		try {
			FileWriter RuHOYiGK = new FileWriter("xml_data/PK_data_dump.xml");
			BufferedWriter QBRkYv5P = new BufferedWriter(RuHOYiGK);
			URL mqOEh2i6 = new URL("http://opendata.5t.torino.it/get_pk");
			URLConnection ElsWYt7H = mqOEh2i6.openConnection();
			BufferedReader LeiMz2XH = new BufferedReader(new InputStreamReader(ElsWYt7H.getInputStream()));
			String uRSbLPm2;
			int JZ59WNNW = 0;
			while ((uRSbLPm2 = LeiMz2XH.readLine()) != null) {
				QBRkYv5P.write(uRSbLPm2 + "\n");
				JZ59WNNW++;
			}
			System.out.println("Parking :: Writed " + JZ59WNNW + " lines.");
			LeiMz2XH.close();
		} catch (Exception TCPnh6H6) {
			System.err.println("Error: " + TCPnh6H6.getMessage());
		}
	}

}