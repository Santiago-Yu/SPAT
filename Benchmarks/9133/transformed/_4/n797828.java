class n797828 {
	public static Set<String> getServices(String url) {
		Set<String> services = new HashSet<String>();
		try {
			URL ws_url = new URL(url);
			URLConnection urlConn;
			DataInputStream dis;
			try {
				urlConn = ws_url.openConnection();
				urlConn.setDoInput(true);
				urlConn.setUseCaches(false);
				dis = new DataInputStream(urlConn.getInputStream());
				String s;
				int fpos = 0;
				int lpos;
				int lslash;
				String sn;
				while ((s = dis.readLine()) != null) {
					if (s.contains("?wsdl")) {
						fpos = s.indexOf("\"") + 1;
						lpos = s.indexOf("?");
						s = s.substring(fpos, lpos);
						s = (s.startsWith("http")) ? s.substring(7) : s;
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