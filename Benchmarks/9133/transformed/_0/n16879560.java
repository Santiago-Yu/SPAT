class n16879560 {
	public void onClick(View HF1IjoaO) {
		try {
			HttpClient U2lf7wAo = new DefaultHttpClient();
			HttpPost IqqVjakI = new HttpPost("https://mt0-app.cloud.cm/rpc/json");
			List<NameValuePair> ctXyN6SB = new ArrayList<NameValuePair>(2);
			ctXyN6SB.add(new BasicNameValuePair("m", "login"));
			ctXyN6SB.add(new BasicNameValuePair("c", "User"));
			ctXyN6SB.add(new BasicNameValuePair("password", "cloudisgreat"));
			ctXyN6SB.add(new BasicNameValuePair("alias", "cs588"));
			IqqVjakI.setEntity(new UrlEncodedFormEntity(ctXyN6SB));
			String zHpOyThl = "";
			try {
				HttpResponse omgMI5Tq = U2lf7wAo.execute(IqqVjakI);
				zHpOyThl = EntityUtils.toString(omgMI5Tq.getEntity());
			} catch (Exception pG1BJiRH) {
				zHpOyThl = pG1BJiRH.getMessage();
			}
			LayoutInflater INFsqaat = (LayoutInflater) WebTest.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			final View JmK2zn6I = INFsqaat.inflate(R.layout.window1, null);
			final PopupWindow UVY2xTna = new PopupWindowTest(JmK2zn6I, 100, 100);
			Button pk29IR4S = (Button) JmK2zn6I.findViewById(R.id.test_button);
			pk29IR4S.setOnTouchListener(new OnTouchListener() {

				@Override
				public boolean onTouch(View wyEb4swd, MotionEvent sRaeC2VV) {
					Log.d("Debug", "Button activate");
					UVY2xTna.dismiss();
					return false;
				}
			});
			UVY2xTna.showAtLocation(JmK2zn6I, Gravity.CENTER, 0, 0);
			View HPh3jU3L = INFsqaat.inflate(R.layout.window1, null);
			final PopupWindow niydfHJ7 = new PopupWindowTest(HPh3jU3L, 100, 100);
			TextView CSsmtnc7 = (TextView) HPh3jU3L.findViewById(R.id.pagetext);
			CSsmtnc7.setText(zHpOyThl);
			niydfHJ7.showAtLocation(JmK2zn6I, Gravity.CENTER, 50, -90);
		} catch (Exception oqwoDuUU) {
			Log.d("Debug", oqwoDuUU.toString());
		}
	}

}