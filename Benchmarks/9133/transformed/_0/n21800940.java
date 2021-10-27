class n21800940 {
	private void makeRequest(String yokpZK3c) {
		try {
			URL YmRkIDd2 = new java.net.URL(curLocation, this.url);
			if ("file".equals(YmRkIDd2.getProtocol())) {
				if (PUT_METHOD.equals(method)) {
					String VFWgfH36 = "";
					if (yokpZK3c != null)
						VFWgfH36 = yokpZK3c.toString();
					FileWriter t2kvMzDg = new FileWriter(new java.io.File(new java.net.URI(YmRkIDd2.toString())));
					t2kvMzDg.write(VFWgfH36, 0, VFWgfH36.length());
					t2kvMzDg.flush();
					t2kvMzDg.close();
				} else if (DELETE_METHOD.equals(method)) {
					File sVPWdOih = new java.io.File(new java.net.URI(YmRkIDd2.toString()));
					sVPWdOih.delete();
				} else {
					URLConnection JPZgWPqf = YmRkIDd2.openConnection();
					JPZgWPqf.connect();
					handleResponse(JPZgWPqf);
				}
			} else {
				HttpURLConnection SGBqFHpD = (HttpURLConnection) YmRkIDd2.openConnection();
				SGBqFHpD.setRequestMethod(method);
				for (Iterator teJhgDpz = headers.entrySet().iterator(); teJhgDpz.hasNext();) {
					Map.Entry zHNv91F3 = (Map.Entry) teJhgDpz.next();
					String yYsyp3YC = (String) zHNv91F3.getKey();
					String u8wUlskq = (String) zHNv91F3.getValue();
					SGBqFHpD.addRequestProperty(yYsyp3YC, u8wUlskq);
				}
				SGBqFHpD.connect();
				handleResponse(SGBqFHpD);
			}
		} catch (Exception lYUF2xNB) {
			lYUF2xNB.printStackTrace();
		}
	}

}