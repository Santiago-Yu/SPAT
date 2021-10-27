class n19753981 {
	private void download(String C63W4Xsz, String Rl1uYZJr, String Z7ehmQ1d, int Hy0MIe6e) {
		InputStream oLIu89B8 = null;
		URLConnection FQUcxPmv = null;
		OutputStream eucFJfal = null;
		System.out.println("Update.download() BAIXANDO " + C63W4Xsz);
		try {
			URL XmJoT5lZ = new URL(C63W4Xsz);
			eucFJfal = new BufferedOutputStream(new FileOutputStream(Rl1uYZJr));
			if (Z7ehmQ1d != "" && Z7ehmQ1d != null) {
				Proxy RcXIUBwP = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(Z7ehmQ1d, Hy0MIe6e));
				FQUcxPmv = XmJoT5lZ.openConnection(RcXIUBwP);
			} else {
				FQUcxPmv = XmJoT5lZ.openConnection();
			}
			oLIu89B8 = FQUcxPmv.getInputStream();
			byte[] Lm98PY6P = new byte[1024];
			int yZZy84bg;
			long locSDw67 = 0;
			while ((yZZy84bg = oLIu89B8.read(Lm98PY6P)) != -1) {
				eucFJfal.write(Lm98PY6P, 0, yZZy84bg);
				locSDw67 += yZZy84bg;
			}
			System.out.println(Rl1uYZJr + "\t" + locSDw67);
		} catch (Exception jV0Ul1Z3) {
			jV0Ul1Z3.printStackTrace();
		} finally {
			try {
				if (oLIu89B8 != null) {
					oLIu89B8.close();
				}
				if (eucFJfal != null) {
					eucFJfal.close();
				}
			} catch (IOException U7bfMzyy) {
			}
		}
	}

}