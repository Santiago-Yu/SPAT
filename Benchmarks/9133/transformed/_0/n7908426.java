class n7908426 {
	private File magiaImagen(String OkQeLdSW) throws MalformedURLException, IOException {
		OkQeLdSW = URLEncoder.encode("\"" + OkQeLdSW + "\"", "UTF-8");
		setMessage("Buscando portada en google...");
		URL r1bcdVGr = new URL("http://images.google.com/images?q=" + OkQeLdSW + "&imgsz=small|medium|large|xlarge");
		setMessage("Buscando portada en google: conectando...");
		URLConnection XSKQtCZL = r1bcdVGr.openConnection();
		XSKQtCZL.setRequestProperty("User-Agent", "MyBNavigator");
		BufferedReader a9qTjjyM = new BufferedReader(
				new InputStreamReader(XSKQtCZL.getInputStream(), Charset.forName("ISO-8859-1")));
		String FZIurVWg;
		StringBuilder AA4So2or = new StringBuilder();
		while ((FZIurVWg = a9qTjjyM.readLine()) != null) {
			AA4So2or.append(FZIurVWg);
		}
		FZIurVWg = AA4So2or.toString();
		String EGnokpFv = "<a href=/imgres?imgurl=";
		setMessage("Buscando portada en google: analizando...");
		while (FZIurVWg.indexOf(EGnokpFv) != -1) {
			int uqmZClCR = FZIurVWg.indexOf(EGnokpFv) + EGnokpFv.length();
			int Rg1a0flS = FZIurVWg.indexOf("&", uqmZClCR);
			String T0RqBb4P = FZIurVWg.substring(uqmZClCR, Rg1a0flS);
			switch (confirmarImagen(T0RqBb4P)) {
			case JOptionPane.YES_OPTION:
				setMessage("Descargando imagen...");
				URL I8ZJ1Qwf = new URL(T0RqBb4P);
				String CVCeQf6q = T0RqBb4P.substring(T0RqBb4P.lastIndexOf(".") + 1);
				File ZFeWHXrP = File.createTempFile("Ignotus", "." + CVCeQf6q);
				BufferedImage AbslT4gs = ImageIO.read(I8ZJ1Qwf);
				FileOutputStream f45XvzWh = new FileOutputStream(ZFeWHXrP);
				ImageIO.write(AbslT4gs, CVCeQf6q, f45XvzWh);
				f45XvzWh.close();
				a9qTjjyM.close();
				return ZFeWHXrP;
			case JOptionPane.CANCEL_OPTION:
				a9qTjjyM.close();
				return null;
			default:
				FZIurVWg = FZIurVWg.substring(uqmZClCR + EGnokpFv.length());
			}
		}
		return null;
	}

}