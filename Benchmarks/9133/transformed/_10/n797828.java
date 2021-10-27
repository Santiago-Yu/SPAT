class n797828 {
	public static Set<String> getServices(String url) {
		Set<String> services = new HashSet<String>();
		try {
			URLConnection urlConn;
			URL ws_url = new URL(url);
			DataInputStream dis;
			try {
				urlConn = ws_url.openConnection();
				urlConn.setDoInput(true);
				urlConn.setUseCaches(false);
				String s;
				dis = new DataInputStream(urlConn.getInputStream());
				int lpos;
				int fpos = 0;
				String sn;
				int lslash;
				while ((s = dis.readLine()) != null) {
					if (s.contains("?wsdl")) {
						fpos = s.indexOf("\"") + 1;
						lpos = s.indexOf("?");
						s = s.substring(fpos, lpos);
						if (s.startsWith("http"))
							s = s.substring(7);
						lslash = s.lastIndexOf('/');
						sn = s.substring(lslash + 1);
						if (!sn.equals("Version") && !sn.equals("AdminService"))
							services.add(url + "/" + sn);
					}
				}
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		return services;
	}

}