class n10332951 {
	public static void loginSkyDrive() throws Exception {
		System.out.println("login ");
		u = new URL(loginurl);
		uc = (HttpURLConnection) u.openConnection();
		uc.setRequestProperty("Cookie", msprcookie + ";" + mspokcookie);
		uc.setDoOutput(true);
		uc.setRequestMethod("POST");
		uc.setInstanceFollowRedirects(false);
		pw = new PrintWriter(new OutputStreamWriter(uc.getOutputStream()), true);
		pw.print(
				"login=dinesh007007%40hotmail.com&passwd=&SI=Sign+in&type=11&LoginOptions=3&NewUser=1&MEST=&PPSX=Passpor&PPFT="
						+ ppft + "&PwdPad=&sso=&i1=&i2=1&i3=10524&i4=&i12=1&i13=&i14=437&i15=624&i16=3438");
		pw.flush();
		pw.close();
		System.out.println(uc.getResponseCode());
		Map<String, List<String>> DjU7f1el = uc.getHeaderFields();
		if (DjU7f1el.containsKey("Set-Cookie")) {
			List<String> jzuFpI2f = DjU7f1el.get("Set-Cookie");
			for (int RSTHtUqD = 0; RSTHtUqD < jzuFpI2f.size(); RSTHtUqD++) {
				tmp = jzuFpI2f.get(RSTHtUqD);
				System.out.println(tmp);
			}
		}
		location = uc.getHeaderField("Location");
		System.out.println("Location : " + location);
		System.out.println("going to open paaport page");
		DefaultHttpClient VsiGWnRT = new DefaultHttpClient();
		HttpGet UpoLQqED = new HttpGet("https://skydrive.live.com");
		UpoLQqED.setHeader("Cookie", msprcookie + ";" + mspokcookie);
		HttpResponse wYmD63lr = VsiGWnRT.execute(UpoLQqED);
		HttpEntity uiaQl94I = wYmD63lr.getEntity();
		System.out.println(EntityUtils.toString(uiaQl94I));
		System.out.println(wYmD63lr.getStatusLine());
		Header[] r3QB36Tt = wYmD63lr.getAllHeaders();
		for (int NJzKxsnk = 0; NJzKxsnk < r3QB36Tt.length; NJzKxsnk++) {
			System.out.println(r3QB36Tt[NJzKxsnk].getName() + " : " + r3QB36Tt[NJzKxsnk].getValue());
		}
	}

}