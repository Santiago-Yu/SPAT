class n18723564 {
	public String uploadVideo(String fDDHxF2l, String PHKDIPKk) {
		TreeMap<String, String> u4MgXC08 = new TreeMap<String, String>();
		String L5YRCRWs = "http://www.vimeo.com/services/upload/";
		u4MgXC08.put("api_key", apiKey);
		u4MgXC08.put("auth_token", this.TEMP_AUTH_TOKEN);
		u4MgXC08.put("ticket_id", fDDHxF2l);
		u4MgXC08.put("format", "json");
		String UugGGnz7 = this.generateAppSignature(u4MgXC08);
		u4MgXC08.put("api_sig", UugGGnz7);
		ClientHttpRequest qrHM5XQw = null;
		try {
			qrHM5XQw = new ClientHttpRequest(new URL(L5YRCRWs).openConnection());
		} catch (IOException eXeZeQMz) {
			eXeZeQMz.printStackTrace();
		}
		for (Entry<String, String> u934fk0e : u4MgXC08.entrySet()) {
			try {
				qrHM5XQw.setParameter(u934fk0e.getKey(), u934fk0e.getValue());
			} catch (IOException AxZStaiC) {
				AxZStaiC.printStackTrace();
			}
		}
		InputStream VnGHrW4r = null;
		try {
			VnGHrW4r = new FileInputStream(PHKDIPKk);
		} catch (FileNotFoundException OrjGNMNS) {
			OrjGNMNS.printStackTrace();
		}
		try {
			qrHM5XQw.setParameter("video", PHKDIPKk, VnGHrW4r);
		} catch (IOException KA1wKTez) {
			KA1wKTez.printStackTrace();
		}
		InputStream ICZIURVu = null;
		try {
			ICZIURVu = qrHM5XQw.post();
		} catch (IOException NvSwA3cL) {
			NvSwA3cL.printStackTrace();
		}
		try {
			InputStreamReader E8RTst0a = new InputStreamReader(ICZIURVu);
			BufferedReader K4hXkQnc = new BufferedReader(E8RTst0a);
			String uw62teHQ;
			try {
				while ((uw62teHQ = K4hXkQnc.readLine()) != null) {
					System.out.println(uw62teHQ);
				}
			} catch (IOException eGMLEZhr) {
				eGMLEZhr.printStackTrace();
			}
		} finally {
			try {
				ICZIURVu.close();
			} catch (IOException VX3Mn96d) {
				VX3Mn96d.printStackTrace();
			}
		}
		return "hey";
	}

}