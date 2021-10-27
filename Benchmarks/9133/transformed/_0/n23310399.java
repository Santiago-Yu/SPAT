class n23310399 {
	public void onClick(View zGxG4IBg) {
		String F0jk96NS = "http://www.sina.com";
		HttpGet OTTm12Gc = new HttpGet(F0jk96NS);
		try {
			HttpResponse MIwMDHzW = new DefaultHttpClient().execute(OTTm12Gc);
			if (MIwMDHzW.getStatusLine().getStatusCode() == 200) {
				String Fsd944fc = EntityUtils.toString(MIwMDHzW.getEntity());
				Fsd944fc = eregi_replace("(\r\n|\r|\n|\n\r)", "", Fsd944fc);
				mTextView1.setText(Fsd944fc);
			} else {
				mTextView1.setText("Error Response: " + MIwMDHzW.getStatusLine().toString());
			}
		} catch (ClientProtocolException cxi4hXGg) {
			mTextView1.setText(cxi4hXGg.getMessage().toString());
			cxi4hXGg.printStackTrace();
		} catch (IOException ppdFpoXS) {
			mTextView1.setText(ppdFpoXS.getMessage().toString());
			ppdFpoXS.printStackTrace();
		} catch (Exception QeQhfHZY) {
			mTextView1.setText(QeQhfHZY.getMessage().toString());
			QeQhfHZY.printStackTrace();
		}
	}

}