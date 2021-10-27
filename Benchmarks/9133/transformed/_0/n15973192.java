class n15973192 {
	private SpequlosResponse executeGet(String Iu5p2NXp, String dmJY8fpG) {
		URL IHn8HNRg;
		HttpURLConnection qKhQR7JH = null;
		boolean ZJ8l3U4T = false;
		try {
			IHn8HNRg = new URL(Iu5p2NXp + "?" + dmJY8fpG);
			qKhQR7JH = (HttpURLConnection) IHn8HNRg.openConnection();
			qKhQR7JH.setRequestMethod("GET");
			qKhQR7JH.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			qKhQR7JH.setRequestProperty("Content-Length", "" + Integer.toString(dmJY8fpG.getBytes().length));
			qKhQR7JH.setRequestProperty("Content-Language", "en-US");
			qKhQR7JH.setUseCaches(false);
			qKhQR7JH.setDoInput(true);
			qKhQR7JH.setDoOutput(true);
			InputStream rWtZRXRs = qKhQR7JH.getInputStream();
			BufferedReader mpyIqx4M = new BufferedReader(new InputStreamReader(rWtZRXRs));
			String Kg36c3we;
			StringBuffer X9hooezW = new StringBuffer();
			ArrayList<String> qtALvCWy = new ArrayList<String>();
			while ((Kg36c3we = mpyIqx4M.readLine()) != null) {
				if (Kg36c3we.startsWith("<div class=\"qos\">")) {
					System.out.println("here is the line : " + Kg36c3we);
					String jQhL4Jbm = Kg36c3we.split(">")[1].split("<")[0];
					System.out.println("here is the splitted line : " + jQhL4Jbm);
					if (!jQhL4Jbm.startsWith("None")) {
						ZJ8l3U4T = true;
						String[] gGdf8y4R = jQhL4Jbm.split(" ");
						ArrayList<String> MSiEftOX = new ArrayList<String>();
						for (String GNo2bCU0 : gGdf8y4R) {
							MSiEftOX.add(GNo2bCU0);
						}
						if (MSiEftOX.size() == 5) {
							MSiEftOX.add(2, MSiEftOX.get(2) + " " + MSiEftOX.get(3));
							MSiEftOX.remove(3);
							MSiEftOX.remove(3);
						}
						for (String DzS9eWtC : MSiEftOX) {
							qtALvCWy.add(DzS9eWtC);
						}
					}
				} else {
					X9hooezW.append(Kg36c3we);
					X9hooezW.append('\r');
				}
			}
			mpyIqx4M.close();
			SpequlosResponse NdxPLDQO = new SpequlosResponse(qtALvCWy, X9hooezW.toString(), ZJ8l3U4T);
			return NdxPLDQO;
		} catch (Exception AxPBnCaj) {
			AxPBnCaj.printStackTrace();
			String txzxr4nh = "Please check the availability of Spequlos server!<br />" + "URL:" + Iu5p2NXp + "<br />"
					+ "PARAMETERS:" + dmJY8fpG + "<br />";
			return new SpequlosResponse(null, txzxr4nh, ZJ8l3U4T);
		} finally {
			if (qKhQR7JH != null)
				qKhQR7JH.disconnect();
		}
	}

}