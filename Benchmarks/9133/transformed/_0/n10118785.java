class n10118785 {
	@Override
	public void download(String y2aKXN2w, String SI5X3NU0) {
		InputStream Z6fRmFoi = null;
		try {
			Z6fRmFoi = client.get(y2aKXN2w);
		} catch (IOException eDWifODj) {
			eDWifODj.printStackTrace();
		}
		OutputStream MuwuJuPf = null;
		try {
			MuwuJuPf = new FileOutputStream(new File(SI5X3NU0));
		} catch (FileNotFoundException r49QTN7O) {
			r49QTN7O.printStackTrace();
		}
		try {
			IOUtils.copy(Z6fRmFoi, MuwuJuPf);
		} catch (IOException kBHElsKV) {
			kBHElsKV.printStackTrace();
		}
	}

}