class n14328796 {
	public ServiceInfo[] findServices(String name) {
		String service_file = ServiceDiscovery.SERVICE_HOME + name;
		Vector results = new Vector();
		for (int loader_count = 0; loader_count < class_loaders_.size(); loader_count++) {
			Enumeration enumeration = null;
			ClassLoader loader = (ClassLoader) class_loaders_.elementAt(loader_count);
			try {
				enumeration = loader.getResources(service_file);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			if (enumeration == null)
				continue;
			while (enumeration.hasMoreElements()) {
				try {
					URL url = (URL) enumeration.nextElement();
					InputStream is = url.openStream();
					if (is != null) {
						try {
							BufferedReader rd;
							try {
								rd = new BufferedReader(new InputStreamReader(is, "UTF-8"));
							} catch (java.io.UnsupportedEncodingException e) {
								rd = new BufferedReader(new InputStreamReader(is));
							}
							try {
								String service_class_name;
								while ((service_class_name = rd.readLine()) != null) {
									service_class_name.trim();
									if ("".equals(service_class_name))
										continue;
									ServiceInfo sinfo = new ServiceInfo();
									if (service_class_name.startsWith("#"))
										continue;
									sinfo.setClassName(service_class_name);
									sinfo.setLoader(loader);
									sinfo.setURL(url);
									results.add(sinfo);
								}
							} finally {
								rd.close();
							}
						} finally {
							is.close();
						}
					}
				} catch (MalformedURLException ex) {
					ex.printStackTrace();
				} catch (IOException ioe) {
					;
				}
			}
		}
		ServiceInfo result_array[] = new ServiceInfo[results.size()];
		results.copyInto(result_array);
		return (result_array);
	}

}