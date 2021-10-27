class n11346465 {
	protected static final void download(String iVLSPytz, File oQeXXznS) {
		OutputStream NazAV43z = null;
		URLConnection gQWvqMi3 = null;
		InputStream xzAKPtca = null;
		try {
			URL YOKAkyxZ = new URL(iVLSPytz);
			NazAV43z = new BufferedOutputStream(new FileOutputStream(oQeXXznS));
			gQWvqMi3 = YOKAkyxZ.openConnection();
			xzAKPtca = gQWvqMi3.getInputStream();
			byte[] abZ7R4Cn = new byte[1024];
			int M60UAYB4;
			long bJvNPAl5 = 0;
			while ((M60UAYB4 = xzAKPtca.read(abZ7R4Cn)) != -1) {
				NazAV43z.write(abZ7R4Cn, 0, M60UAYB4);
				bJvNPAl5 += M60UAYB4;
			}
			System.out.println(oQeXXznS + "\t" + bJvNPAl5);
		} catch (Exception vYKk41uL) {
			vYKk41uL.printStackTrace();
		} finally {
			try {
				if (xzAKPtca != null) {
					xzAKPtca.close();
				}
				if (NazAV43z != null) {
					NazAV43z.close();
				}
			} catch (IOException OSexO9ko) {
			}
		}
	}

}