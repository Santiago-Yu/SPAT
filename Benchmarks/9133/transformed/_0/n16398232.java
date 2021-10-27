class n16398232 {
	int responseTomcat(InetAddress o1EJMVkr, int f3zMsF6A, String mrFRuBEp, boolean u7pbPgTx, StringBuffer frYDxflx,
			int EEp9Y47K) {
		int ycAX6sOJ = 250;
		int AhnnhFc0 = 32000;
		if (mrFRuBEp == null || frYDxflx == null)
			return -1;
		String mWqDUemb;
		if (u7pbPgTx) {
			String a7rIuMIV;
			String fVFAgUh3;
			int Nt1fX4WU = mrFRuBEp.indexOf('?');
			if (Nt1fX4WU == -1) {
				a7rIuMIV = mrFRuBEp;
				fVFAgUh3 = "";
			} else {
				a7rIuMIV = mrFRuBEp.substring(0, Nt1fX4WU);
				fVFAgUh3 = mrFRuBEp.substring(Nt1fX4WU + 1);
			}
			mWqDUemb = "POST " + a7rIuMIV + " HTTP/1.1\nHost: " + o1EJMVkr.getHostName() + ":"
					+ (new Integer(f3zMsF6A)).toString() + "\n\n" + fVFAgUh3;
		} else {
			mWqDUemb = "GET " + mrFRuBEp + " HTTP/1.1\nHost: " + o1EJMVkr.getHostName() + ":"
					+ (new Integer(f3zMsF6A)).toString() + "\n\n";
		}
		if (u7pbPgTx && mWqDUemb.length() > AhnnhFc0) {
			frYDxflx.setLength(0);
			frYDxflx.append("Complete POST request longer than maximum of " + AhnnhFc0);
			return -5;
		} else if ((!u7pbPgTx) && mWqDUemb.length() > ycAX6sOJ) {
			frYDxflx.setLength(0);
			frYDxflx.append("Complete GET request longer than maximum of " + ycAX6sOJ);
			return -6;
		}
		String wWeGcj4W = "";
		mrFRuBEp = "http://" + o1EJMVkr.getHostName() + ":" + (new Integer(f3zMsF6A).toString()) + mrFRuBEp;
		try {
			URL vIYYOyIU = new URL(mrFRuBEp);
			URLConnection MSZHVGW4 = vIYYOyIU.openConnection();
			BufferedReader QXiUxDgv = new BufferedReader(new InputStreamReader(MSZHVGW4.getInputStream()));
			while ((wWeGcj4W = QXiUxDgv.readLine()) != null) {
				frYDxflx = frYDxflx.append(wWeGcj4W).append("\n");
			}
		} catch (MalformedURLException XLRtmex5) {
			return -4;
		} catch (IOException heUKk2N9) {
			return -3;
		}
		return 200;
	}

}