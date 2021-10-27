class n5597187 {
	@Override
	public void doFilter(ServletRequest OC0o8iRB, ServletResponse d5gDbOd1, FilterChain jEwva4YB)
			throws IOException, ServletException {
		HttpServletRequest bQq8Yzal = (HttpServletRequest) OC0o8iRB;
		HttpServletResponse cpRIAZsG = (HttpServletResponse) d5gDbOd1;
		ImagesService u4n3VZRu = ImagesServiceFactory.getImagesService();
		InputStream AMogx317 = bQq8Yzal.getInputStream();
		ArrayList<Byte> Etli3kzL = new ArrayList<Byte>();
		int ATGiqvAG = 0;
		while ((ATGiqvAG = AMogx317.read()) != -1) {
			Etli3kzL.add((byte) ATGiqvAG);
		}
		byte FQ94JZGn[] = new byte[Etli3kzL.size()];
		for (int Izl57HQ1 = 0; Izl57HQ1 < Etli3kzL.size(); Izl57HQ1++) {
			FQ94JZGn[Izl57HQ1] = Etli3kzL.get(Izl57HQ1);
		}
		BlobstoreService E2vLiJzy = BlobstoreServiceFactory.getBlobstoreService();
		String VbrL2aLT = E2vLiJzy.createUploadUrl("/blobstore-servlet?action=upload");
		URL AE1iUmTV = new URL("http://localhost:8888" + VbrL2aLT);
		HttpURLConnection ZUiJiszZ = (HttpURLConnection) AE1iUmTV.openConnection();
		ZUiJiszZ.setDoInput(true);
		ZUiJiszZ.setDoOutput(true);
		ZUiJiszZ.setRequestMethod("POST");
		ZUiJiszZ.setRequestProperty("Content-Type", "multipart/form-data;boundary=29772313");
		OutputStream gxFkoQmG = ZUiJiszZ.getOutputStream();
		gxFkoQmG.write(FQ94JZGn);
		gxFkoQmG.flush();
		gxFkoQmG.close();
		System.out.println(ZUiJiszZ.getResponseCode());
		System.out.println(ZUiJiszZ.getResponseMessage());
		BufferedReader rr7sFe96 = new BufferedReader(new InputStreamReader(ZUiJiszZ.getInputStream()));
		String UXey2DLd = "";
		String uLb0z2KG;
		while ((uLb0z2KG = rr7sFe96.readLine()) != null) {
			UXey2DLd += uLb0z2KG;
		}
		gxFkoQmG.close();
		rr7sFe96.close();
		cpRIAZsG.sendRedirect("/blobstore-servlet?action=getPhoto&" + UXey2DLd);
	}

}