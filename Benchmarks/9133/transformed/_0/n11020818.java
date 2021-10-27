class n11020818 {
	public static byte[] excutePostRaw(String JpxMQvng, byte[] YjYErFjJ) {
		URL hFqepQKJ;
		HttpURLConnection ywjju4nN = null;
		try {
			hFqepQKJ = new URL(JpxMQvng);
			ywjju4nN = (HttpURLConnection) hFqepQKJ.openConnection();
			ywjju4nN.setRequestMethod("POST");
			ywjju4nN.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			ywjju4nN.setRequestProperty("Content-Length", "" + Integer.toString(YjYErFjJ.length));
			ywjju4nN.setRequestProperty("Content-Language", "en-US");
			ywjju4nN.setUseCaches(false);
			ywjju4nN.setDoInput(true);
			ywjju4nN.setDoOutput(true);
			DataOutputStream RAtUhBbz = new DataOutputStream(ywjju4nN.getOutputStream());
			RAtUhBbz.write(YjYErFjJ);
			RAtUhBbz.flush();
			RAtUhBbz.close();
			int Fg4agV6a = ywjju4nN.getContentLength();
			InputStream quTgiNvO = ywjju4nN.getInputStream();
			MojasiWriter kQoYPyGx = new MojasiWriter();
			byte[] t0vNuba8 = new byte[256];
			while (kQoYPyGx.size() < Fg4agV6a) {
				int zSKSk8ZC = quTgiNvO.read(t0vNuba8);
				if (zSKSk8ZC < 0)
					break;
				kQoYPyGx.pushBytes(t0vNuba8, zSKSk8ZC);
				if (kQoYPyGx.size() > 1)
					System.out.println();
			}
			quTgiNvO.close();
			ywjju4nN.disconnect();
			return kQoYPyGx.getBytes();
		} catch (Exception G6BawaxW) {
			G6BawaxW.printStackTrace();
			return null;
		} finally {
			if (ywjju4nN != null) {
				ywjju4nN.disconnect();
			}
		}
	}

}