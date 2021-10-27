class n5391696 {
	public static StringBuffer getCachedFile(String gjKXBi3f) throws Exception {
		File cUuNWRsS = new File("tmp-cache/" + gjKXBi3f.replace('/', '-'));
		new File("tmp-cache/").mkdir();
		if (cUuNWRsS.exists()) {
			BufferedReader s7Q2RVqD = new BufferedReader(new FileReader(cUuNWRsS));
			StringBuffer QRWr6UUo = new StringBuffer();
			String Hu6yFGT5;
			while ((Hu6yFGT5 = s7Q2RVqD.readLine()) != null) {
				QRWr6UUo.append(Hu6yFGT5 + "\n");
			}
			s7Q2RVqD.close();
			return QRWr6UUo;
		} else {
			URL JPOidTKq = new URL(gjKXBi3f.replace(" ", "%20"));
			BufferedReader RgA5rh0u = new BufferedReader(new InputStreamReader(JPOidTKq.openStream()));
			BufferedWriter Y2xXteKa = new BufferedWriter(new FileWriter(cUuNWRsS));
			StringBuffer jaBtwH9S = new StringBuffer();
			String VBu4W12B;
			while ((VBu4W12B = RgA5rh0u.readLine()) != null) {
				jaBtwH9S.append(VBu4W12B + "\n");
				Y2xXteKa.write(VBu4W12B + "\n");
			}
			Y2xXteKa.close();
			RgA5rh0u.close();
			return jaBtwH9S;
		}
	}

}