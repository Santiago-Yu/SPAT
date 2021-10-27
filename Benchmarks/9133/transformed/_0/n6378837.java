class n6378837 {
	public static long download(String Yx42H82O, String fcM2aMGy) throws Exception {
		OutputStream MqirYnbw = null;
		URLConnection KxBgNtEU = null;
		InputStream FrBS0Uv4 = null;
		long B9neluTk = 0;
		try {
			URL BlEonwz6 = new URL(Yx42H82O);
			MqirYnbw = new BufferedOutputStream(new FileOutputStream(fcM2aMGy));
			KxBgNtEU = BlEonwz6.openConnection();
			FrBS0Uv4 = KxBgNtEU.getInputStream();
			byte[] OPvR7CDd = new byte[1024];
			int vhGwfZLR;
			while ((vhGwfZLR = FrBS0Uv4.read(OPvR7CDd)) != -1) {
				MqirYnbw.write(OPvR7CDd, 0, vhGwfZLR);
				B9neluTk += vhGwfZLR;
			}
			System.out.println(fcM2aMGy + "\t" + B9neluTk);
		} catch (Exception AodpKLMN) {
			System.out.println("Error: " + AodpKLMN);
			throw AodpKLMN;
		} finally {
			try {
				if (FrBS0Uv4 != null) {
					FrBS0Uv4.close();
				}
				if (MqirYnbw != null) {
					MqirYnbw.close();
				}
			} catch (IOException TCVwvUsr) {
			}
			return B9neluTk;
		}
	}

}