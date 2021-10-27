class n16931472 {
	public void handler(Map<String, String> WIpYhjgE, TargetPage QsjxaAzs) {
		try {
			URL xgkOJZPA = new URL(QsjxaAzs.getUrl());
			BufferedReader SPF1UEVy = new BufferedReader(new InputStreamReader(xgkOJZPA.openStream()));
			String qPnohJNt = null;
			while ((qPnohJNt = SPF1UEVy.readLine()) != null) {
				for (Map.Entry<String, String> entry : WIpYhjgE.entrySet()) {
					if (qPnohJNt.indexOf(QsjxaAzs.getInclude()) != -1) {
						int MVXxZDQr = qPnohJNt.indexOf(QsjxaAzs.getFromStr());
						String a1ccwyiO = qPnohJNt.substring(MVXxZDQr + QsjxaAzs.getFromStr().length(),
								qPnohJNt.indexOf(QsjxaAzs.getToStr(), MVXxZDQr));
						entry.setValue(a1ccwyiO);
						qPnohJNt = qPnohJNt
								.substring(qPnohJNt.indexOf(QsjxaAzs.getToStr()) + QsjxaAzs.getToStr().length());
					}
				}
			}
			SPF1UEVy.close();
		} catch (MalformedURLException JEvbljw6) {
		} catch (IOException y1G7ZOcx) {
		}
	}

}