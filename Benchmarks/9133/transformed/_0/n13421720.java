class n13421720 {
	public static String download(String EiOj3qr3, String etJK6qMz) {
		URL qZynGjx6 = null;
		String o1MqzVRv = "";
		try {
			qZynGjx6 = new URL(EiOj3qr3);
			System.err.println("Indirizzo valido!");
		} catch (MalformedURLException AeB9HUbh) {
			System.err.println("Indirizzo non valido!");
		}
		try {
			HttpURLConnection owRr0vVB = (HttpURLConnection) qZynGjx6.openConnection();
			owRr0vVB.setRequestProperty("Range", "bytes=0-");
			owRr0vVB.connect();
			int fpyhecWt = owRr0vVB.getContentLength();
			if (fpyhecWt < 1) {
				System.err.println("Errore, c'e' qualcosa che non va!");
				return "";
			}
			o1MqzVRv = qZynGjx6.getFile();
			o1MqzVRv = o1MqzVRv.substring(qZynGjx6.getFile().lastIndexOf('/') + 1);
			RandomAccessFile cOjScjoo = new RandomAccessFile(etJK6qMz + o1MqzVRv, "rw");
			cOjScjoo.seek(0);
			InputStream JvJ6sstb = owRr0vVB.getInputStream();
			byte[] kR2SqUK1 = new byte[1024];
			while (true) {
				int LzwGaOFV = JvJ6sstb.read(kR2SqUK1);
				if (LzwGaOFV == -1) {
					break;
				}
				cOjScjoo.write(kR2SqUK1, 0, LzwGaOFV);
			}
			cOjScjoo.close();
		} catch (IOException H3x3DhNs) {
			System.err.println("I/O error!");
		}
		return etJK6qMz + o1MqzVRv;
	}

}