class n7245722 {
	private String listaArquivo() {
		String jsHVMqcw = "";
		String xjMphqOz = "";
		try {
			URL gAe8720H = new URL(this.getCodeBase(), "./listador?dir=" + "cenarios" + "/" + user);
			URLConnection ICA3P9qi = gAe8720H.openConnection();
			ICA3P9qi.setUseCaches(false);
			InputStream CQNSn9Y2 = ICA3P9qi.getInputStream();
			DataInputStream VJKHsnUM = new DataInputStream(new BufferedInputStream(CQNSn9Y2));
			while ((xjMphqOz = VJKHsnUM.readLine()) != null) {
				jsHVMqcw += xjMphqOz + "\n";
			}
			return jsHVMqcw;
		} catch (Exception y1tst9Me) {
			return null;
		}
	}

}