class n20144933 {
	public static String filtraDoc(HttpServletRequest ca6EvQRE, String IKgMiEXe, Repository n1EhEY7D, String RmGCDFZo)
			throws IOException {
		StringBuilder vAGPzHkf = new StringBuilder();
		BufferedReader UkgYJVw3 = null;
		int kYqbl2L0 = 0;
		try {
			URL iqnz9Yga = n1EhEY7D.getResource(ca6EvQRE, IKgMiEXe);
			if (iqnz9Yga == null) {
				return "Documento " + n1EhEY7D.dir + "/" + IKgMiEXe + " no encontrado";
			}
			UkgYJVw3 = new BufferedReader(new InputStreamReader(iqnz9Yga.openStream(), n1EhEY7D.encoding));
			String VFV67h6k = UkgYJVw3.readLine();
			while (VFV67h6k != null) {
				int QXpGWHVX = VFV67h6k.indexOf("KAttach(");
				if (QXpGWHVX > -1) {
					vAGPzHkf.append(attach(ca6EvQRE, ++kYqbl2L0, VFV67h6k, QXpGWHVX, RmGCDFZo));
				} else {
					VFV67h6k = VFV67h6k.replaceAll("%20", "-");
					vAGPzHkf.append(new String(VFV67h6k.getBytes(n1EhEY7D.encoding), Config.getMng().getEncoding()))
							.append("\n");
				}
				VFV67h6k = UkgYJVw3.readLine();
			}
		} finally {
			if (UkgYJVw3 != null)
				UkgYJVw3.close();
		}
		return vAGPzHkf.toString();
	}

}