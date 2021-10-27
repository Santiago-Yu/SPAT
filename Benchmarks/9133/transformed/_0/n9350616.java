class n9350616 {
	@Override
	public void onCreate(Bundle fxX5WD2S) {
		super.onCreate(fxX5WD2S);
		setContentView(R.layout.listview);
		HttpGet Ad5OdI09 = new HttpGet(SERVICE_URI + "/json/getallpersons");
		Ad5OdI09.setHeader("Accept", "application/json");
		Ad5OdI09.setHeader("Content-type", "application/json");
		DefaultHttpClient DjNfBl2K = new DefaultHttpClient();
		String Ng6NK2fY = new String("");
		try {
			HttpResponse i3sBlkfW = DjNfBl2K.execute(Ad5OdI09);
			HttpEntity gCkmhkZW = i3sBlkfW.getEntity();
			InputStream pd8cXdpv = gCkmhkZW.getContent();
			BufferedReader QF5eonvg = new BufferedReader(new InputStreamReader(pd8cXdpv));
			StringBuilder sFHjcXxx = new StringBuilder();
			String LiiFIVKe;
			while ((LiiFIVKe = QF5eonvg.readLine()) != null) {
				sFHjcXxx.append(LiiFIVKe);
			}
			pd8cXdpv.close();
			Ng6NK2fY = sFHjcXxx.toString();
		} catch (Exception Lr99QZSU) {
			Lr99QZSU.printStackTrace();
		}
		Toast.makeText(this, Ng6NK2fY + "\n", Toast.LENGTH_LONG).show();
	}

}