class n14249320 {
	@SuppressWarnings("unchecked")
	public void findServiceDescriptionsAsync(FindServiceDescriptionsCallBack callBack) {
		String url;
		boolean url_valid = true;
		URI url_uri = getConfiguration().getUri();
		url = url_uri.toString();
		URLConnection urlConn_test;
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
			url = url_uri.toString();
			List<ServiceDescription> results = new ArrayList<ServiceDescription>();
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
					String hi;
					while ((s = dis.readLine()) != null) {
						if (s.contains("?wsdl")) {
							fpos = s.indexOf("\"") + 1;
							lpos = s.indexOf("?");
							s = s.substring(fpos, lpos);
							s = (s.startsWith("http")) ? s.substring(7) : s;
							lslash = s.lastIndexOf('/');
							sn = s.substring(lslash + 1);
							hi = s.substring(0, lslash);
							hi = hi.replace('/', '_');
							if (!sn.equals("Version") && !sn.equals("AdminService")) {
								ExampleServiceDesc service = new ExampleServiceDesc();
								s = sn + "_from_" + hi;
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