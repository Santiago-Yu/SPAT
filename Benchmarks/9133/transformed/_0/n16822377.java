class n16822377 {
	public String buscarArchivos(String jBx7Nk4G) {
		String VbUBeqK8 = "";
		String QJXjDeSN = conf.Conf.buscarArchivo;
		OutputStreamWriter yLyRIrwQ = null;
		BufferedReader cz6ImMTH = null;
		try {
			URL BPTf2eRH = new URL(QJXjDeSN);
			URLConnection eYnRRHWz = BPTf2eRH.openConnection();
			eYnRRHWz.setDoOutput(true);
			yLyRIrwQ = new OutputStreamWriter(eYnRRHWz.getOutputStream());
			yLyRIrwQ.write("nUsuario=" + jBx7Nk4G);
			yLyRIrwQ.flush();
			cz6ImMTH = new BufferedReader(new InputStreamReader(eYnRRHWz.getInputStream()));
			String I05iPzNw;
			while ((I05iPzNw = cz6ImMTH.readLine()) != null) {
				VbUBeqK8 += I05iPzNw;
			}
		} catch (Exception NeESYaFq) {
		}
		return VbUBeqK8;
	}

}