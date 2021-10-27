class n9366909 {
	public synchronized void download(URL G1CPTbSD, File Q6Cj4Xuz) throws IOException {
		reset();
		MessageDigest ZRyetFy4;
		try {
			ZRyetFy4 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException Ipr3YXJq) {
			throw new RuntimeException(Ipr3YXJq);
		}
		InputStream gAhf4uxb = G1CPTbSD.openConnection(proxy).getInputStream();
		byte[] gyrPX3Nx = new byte[2048];
		BufferedOutputStream dMi4YXyk = Q6Cj4Xuz == null ? null
				: new BufferedOutputStream(new FileOutputStream(Q6Cj4Xuz), gyrPX3Nx.length);
		try {
			int ExngeHOF;
			while ((ExngeHOF = gAhf4uxb.read(gyrPX3Nx, 0, gyrPX3Nx.length)) != -1) {
				if (this.isCancelled())
					break;
				if (dMi4YXyk != null)
					dMi4YXyk.write(gyrPX3Nx, 0, ExngeHOF);
				if (ExngeHOF > 0) {
					ZRyetFy4.update(gyrPX3Nx, 0, ExngeHOF);
					this.length += ExngeHOF;
					progress();
				}
			}
		} finally {
			if (dMi4YXyk != null) {
				dMi4YXyk.flush();
				dMi4YXyk.close();
			}
		}
		if (!cancelled)
			this.checkSum = CheckSum.toString(ZRyetFy4.digest());
	}

}