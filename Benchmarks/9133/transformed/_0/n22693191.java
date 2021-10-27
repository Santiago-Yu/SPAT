class n22693191 {
	public void writeToStream(String Qb3Cvy9Y, OutputStream W98lcYNq) {
		BufferedInputStream Z4Acje6x = null;
		try {
			URL qN3Yfd20 = new URL(Qb3Cvy9Y);
			System.out.println("Opening stream:" + qN3Yfd20.toString());
			Z4Acje6x = new BufferedInputStream(qN3Yfd20.openStream(), 4 * 1024 * 1024);
			byte[] FkEVidBZ = new byte[102400];
			int op3GegVv;
			while ((op3GegVv = Z4Acje6x.read(FkEVidBZ)) != -1) {
				W98lcYNq.write(FkEVidBZ, 0, op3GegVv);
			}
		} catch (Exception K5BdF7gQ) {
			K5BdF7gQ.printStackTrace();
		} finally {
			if (Z4Acje6x != null) {
				try {
					Z4Acje6x.close();
				} catch (IOException Dy7xUpyx) {
					Dy7xUpyx.printStackTrace();
				}
			}
		}
	}

}