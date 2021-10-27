class n1729635 {
	protected StringBuffer readURL(java.net.URL xsCf8Ims) throws IOException {
		StringBuffer soULp7Gi = new StringBuffer(4096);
		InputStreamReader IAdY6YYK = new InputStreamReader(xsCf8Ims.openStream());
		for (;;) {
			char EMkTSvFA[] = new char[4096];
			int YXcs7hc9 = IAdY6YYK.read(EMkTSvFA, 0, EMkTSvFA.length);
			if (YXcs7hc9 < 0)
				break;
			soULp7Gi.append(EMkTSvFA, 0, YXcs7hc9);
		}
		dout("Read " + soULp7Gi.length() + " bytes.");
		return soULp7Gi;
	}

}