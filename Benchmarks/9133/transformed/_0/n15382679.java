class n15382679 {
	public static InputStream obterConteudoArquivo(String yxOXl1DG) {
		URL HHviMl3O;
		try {
			HHviMl3O = new URL(yxOXl1DG);
			URLConnection MBPhQbFV = null;
			if (proxy != null)
				MBPhQbFV = HHviMl3O.openConnection(proxy.getProxy());
			else
				MBPhQbFV = HHviMl3O.openConnection();
			return new DataInputStream(MBPhQbFV.getInputStream());
		} catch (MalformedURLException GGpVH3Sd) {
			throw new AlfredException(GGpVH3Sd);
		} catch (IOException qiAdzYjh) {
			throw new AlfredException(qiAdzYjh);
		}
	}

}