class n14249320 {
	@SuppressWarnings("unchecked")
	public void findServiceDescriptionsAsync(FindServiceDescriptionsCallBack callBack) {
		boolean url_valid = true;
		String url;
		URI url_uri = getConfiguration().getUri();
		URLConnection urlConn_test;
		url = url_uri.toString();
		try {
			urlConn_test = (new URL(url)).openConnection();
		} catch (MalformedURLException e2) {
			url_valid = false;
			e2.printStackTrace();
			System.out.println("ERROR: Bad Opal service URL entered:" + url);
		} catch (IOException e2) {
			url_valid = false;
			e2.printStackTrace();
			System.out.println("ERROR: Bad Opal service URL entered:" + url);
		}
		if (url_uri != null && url_valid == true) {
			System.out.println("URL entered: " + url_uri);
			List<ServiceDescription> results = new ArrayList<ServiceDescription>();
			url = url_uri.toString();
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
					String hi;
					while ((s = dis.readLine()) != null) {
						if (s.contains("?wsdl")) {
							fpos = s.indexOf("\"") + 1;
							lpos = s.indexOf("?");
							s = s.substring(fpos, lpos);
							if (s.startsWith("http"))
								s = s.substring(7);
							lslash = s.lastIndexOf('/');
							sn = s.substring(lslash + 1);
							hi = s.substring(0, lslash);
							hi = hi.replace('/', '_');
							if (!sn.equals("Version") && !sn.equals("AdminService")) {
								s = sn + "_from_" + hi;
								ExampleServiceDesc service = new ExampleServiceDesc();
								service.setExampleString(s);
								service.setExampleUri(URI.create(url));
								results.add(service);
							}
						}
					}
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			callBack.partialResults(results);
			callBack.finished();
		}
	}

}