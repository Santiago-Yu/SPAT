class n16822378 {
	public String descargarArchivo(String bkKV0N7l, String CoJTWZ2C) {
		try {
			URL RHECnYJf = new URL(conf.Conf.descarga + CoJTWZ2C + "/" + bkKV0N7l);
			URLConnection YjdHCG9R = RHECnYJf.openConnection();
			System.out.println(YjdHCG9R.getContentType());
			InputStream djpEBM7a = YjdHCG9R.getInputStream();
			FileOutputStream GgsDktrx = new FileOutputStream("D:/" + bkKV0N7l);
			byte[] gUwm2FsJ = new byte[1000];
			int klWUe1Jp = djpEBM7a.read(gUwm2FsJ);
			while (klWUe1Jp > 0) {
				GgsDktrx.write(gUwm2FsJ, 0, klWUe1Jp);
				klWUe1Jp = djpEBM7a.read(gUwm2FsJ);
			}
			djpEBM7a.close();
			GgsDktrx.close();
		} catch (Exception ZYV9RfFf) {
			ZYV9RfFf.printStackTrace();
		}
		return "llego";
	}

}