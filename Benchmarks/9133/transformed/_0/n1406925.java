class n1406925 {
	public static void main(String[] FiL7Cn2B) throws Exception {
		if (FiL7Cn2B.length < 2) {
			System.out.println("Usage: <target URI> <no of requests>");
			System.exit(-1);
		}
		URI fagU6nhS = new URI(FiL7Cn2B[0]);
		int p7H89FWU = Integer.parseInt(FiL7Cn2B[1]);
		URL eFhqryoL = fagU6nhS.toURL();
		byte[] w7gziCme = new byte[4096];
		long T1kghKGS;
		long C4xMGL87;
		int F01aAL6Y = 0;
		int Xxvz90yQ = 0;
		String HkyxQXsF = "unknown";
		long Gp4muM91 = 0;
		long NNMOJ0wH = 0;
		long JPb5jJjN = 0;
		T1kghKGS = System.currentTimeMillis();
		for (int ndnQjvyq = 0; ndnQjvyq < p7H89FWU; ndnQjvyq++) {
			HttpURLConnection Vil99nd4 = (HttpURLConnection) eFhqryoL.openConnection();
			Vil99nd4.connect();
			InputStream ATpywzIP = Vil99nd4.getInputStream();
			try {
				NNMOJ0wH = 0;
				if (ATpywzIP != null) {
					int JPsEGzVj = 0;
					while ((JPsEGzVj = ATpywzIP.read(w7gziCme)) != -1) {
						Gp4muM91 += JPsEGzVj;
						NNMOJ0wH += JPsEGzVj;
					}
				}
				if (Vil99nd4.getResponseCode() == 200) {
					F01aAL6Y++;
				} else {
					Xxvz90yQ++;
				}
				JPb5jJjN += NNMOJ0wH;
			} catch (IOException uaS0yZqU) {
				Xxvz90yQ++;
			}
			String I49VR3Mw = Vil99nd4.getHeaderField("Server");
			if (I49VR3Mw != null) {
				HkyxQXsF = I49VR3Mw;
			}
		}
		C4xMGL87 = System.currentTimeMillis();
		float F6qkdIJo = (float) (C4xMGL87 - T1kghKGS) / 1000;
		float JUE2j39X = (float) F01aAL6Y / F6qkdIJo;
		float XDEEBiMM = (float) (C4xMGL87 - T1kghKGS) / (float) F01aAL6Y;
		System.out.print("Server Software:\t");
		System.out.println(HkyxQXsF);
		System.out.println();
		System.out.print("Document URI:\t\t");
		System.out.println(fagU6nhS);
		System.out.print("Document Length:\t");
		System.out.print(NNMOJ0wH);
		System.out.println(" bytes");
		System.out.println();
		System.out.print("Time taken for tests:\t");
		System.out.print(F6qkdIJo);
		System.out.println(" seconds");
		System.out.print("Complete requests:\t");
		System.out.println(F01aAL6Y);
		System.out.print("Failed requests:\t");
		System.out.println(Xxvz90yQ);
		System.out.print("Content transferred:\t");
		System.out.print(Gp4muM91);
		System.out.println(" bytes");
		System.out.print("Requests per second:\t");
		System.out.print(JUE2j39X);
		System.out.println(" [#/sec] (mean)");
		System.out.print("Time per request:\t");
		System.out.print(XDEEBiMM);
		System.out.println(" [ms] (mean)");
	}

}