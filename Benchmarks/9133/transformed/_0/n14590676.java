class n14590676 {
	public static void download(String YGzqeh7h, String LP07iCe8) {
		OutputStream WV42vB5g = null;
		URLConnection VPXuuDkS = null;
		InputStream Z6tFJwBz = null;
		try {
			URL fnUZdn24 = new URL(YGzqeh7h);
			WV42vB5g = new BufferedOutputStream(new FileOutputStream(LP07iCe8));
			VPXuuDkS = fnUZdn24.openConnection();
			Z6tFJwBz = VPXuuDkS.getInputStream();
			byte[] EtaVzwBt = new byte[1024];
			int Tbj5ZWU3;
			long WQBLGQD7 = 0;
			while ((Tbj5ZWU3 = Z6tFJwBz.read(EtaVzwBt)) != -1) {
				WV42vB5g.write(EtaVzwBt, 0, Tbj5ZWU3);
				WQBLGQD7 += Tbj5ZWU3;
			}
			System.out.println(LP07iCe8 + "\t" + WQBLGQD7);
		} catch (Exception rSSRH2zf) {
			rSSRH2zf.printStackTrace();
		} finally {
			try {
				if (Z6tFJwBz != null)
					Z6tFJwBz.close();
				if (WV42vB5g != null)
					WV42vB5g.close();
			} catch (IOException jkthOUm7) {
				jkthOUm7.printStackTrace();
			}
		}
	}

}