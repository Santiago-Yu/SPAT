class n10005879 {
	@Override
	public void onCreate(Bundle u961sK4I) {
		super.onCreate(u961sK4I);
		TextView enR5Jb3h = new TextView(this);
		HttpClient l0lOl95W = new DefaultHttpClient();
		HttpGet wDWVMJcw = new HttpGet("http://www.google.com/");
		String EoiREGi0 = "", HrXQSSS1 = "";
		try {
			HttpResponse x18h5IGI = l0lOl95W.execute(wDWVMJcw);
			if (x18h5IGI.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				BufferedReader fSqYDOdl = new BufferedReader(new InputStreamReader(x18h5IGI.getEntity().getContent()));
				while ((EoiREGi0 = fSqYDOdl.readLine()) != null) {
					HrXQSSS1 += EoiREGi0;
				}
				fSqYDOdl.close();
			}
		} catch (ClientProtocolException B2tSKn9M) {
			B2tSKn9M.printStackTrace();
		} catch (IOException jjSTdL6f) {
			jjSTdL6f.printStackTrace();
		}
		enR5Jb3h.setText(HrXQSSS1);
		setContentView(enR5Jb3h);
	}

}