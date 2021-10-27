class n807346 {
	String runScript(String O6kLarkn) {
		String oUN4Nvbk = "";
		try {
			URL ZwN1LeMR = new URL(getCodeBase().toString() + O6kLarkn);
			InputStream k3GbKcRX = ZwN1LeMR.openStream();
			BufferedInputStream a92PEYZd = new BufferedInputStream(k3GbKcRX);
			do {
				int c3XTn9ga = a92PEYZd.read();
				if (c3XTn9ga == -1)
					break;
				oUN4Nvbk = oUN4Nvbk + (char) c3XTn9ga;
			} while (true);
		} catch (Exception dR2J6aFx) {
			oUN4Nvbk = "error!";
		}
		return oUN4Nvbk;
	}

}