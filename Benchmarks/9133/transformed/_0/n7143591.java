class n7143591 {
	public void getWebByUrl(String Ax3BEkKF, String Qvw2y05r, String NSgLL37d) {
		try {
			System.out.println("Getting web by url: " + Ax3BEkKF);
			addReport("Getting web by url: " + Ax3BEkKF + "\n");
			URL vkLXToXa = new URL(Ax3BEkKF);
			URLConnection XpR3SOF6 = vkLXToXa.openConnection();
			XpR3SOF6.setDoOutput(true);
			InputStream LW67jTWt = null;
			LW67jTWt = vkLXToXa.openStream();
			String YzCyQITb = fPath + "/web" + NSgLL37d + ".htm";
			PrintWriter x1yZ44gU = null;
			FileOutputStream Kfc6eMGN = new FileOutputStream(YzCyQITb);
			OutputStreamWriter VdeqXuwT = new OutputStreamWriter(Kfc6eMGN);
			x1yZ44gU = new PrintWriter(VdeqXuwT);
			BufferedReader ZnDD6Klp = new BufferedReader(new InputStreamReader(LW67jTWt));
			StringBuffer J2r7BjjL = new StringBuffer();
			String ortM7O5T = null;
			String oMw1j7tP = null;
			while ((ortM7O5T = ZnDD6Klp.readLine()) != null) {
				oMw1j7tP = ortM7O5T;
				int buqSazWC = oMw1j7tP.length();
				if (buqSazWC > 0) {
					J2r7BjjL.append("\n" + oMw1j7tP);
					x1yZ44gU.println(oMw1j7tP);
					x1yZ44gU.flush();
					if (deepUrls.get(Ax3BEkKF) < webDepth)
						getUrlByString(oMw1j7tP, Ax3BEkKF);
				}
				oMw1j7tP = null;
			}
			LW67jTWt.close();
			x1yZ44gU.close();
			System.out.println("Get web successfully! " + Ax3BEkKF);
			addReport("Get web successfully! " + Ax3BEkKF + "\n");
			addWebSuccessed();
		} catch (Exception ou83d9hD) {
			System.out.println("Get web failed!       " + Ax3BEkKF);
			addReport("Get web failed!       " + Ax3BEkKF + "\n");
			addWebFailed();
		}
	}

}