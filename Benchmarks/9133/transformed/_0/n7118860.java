class n7118860 {
	private String getEncoding() throws IOException {
		BufferedReader wYtHubcx = null;
		String FjWQWngB = null;
		try {
			URLConnection Ut8xP6aY = url.openConnection();
			Map<String, List<String>> K3TbbT1z = Ut8xP6aY.getHeaderFields();
			for (Map.Entry<String, List<String>> entry : K3TbbT1z.entrySet()) {
				if (entry.getKey().toLowerCase().equals("content-type")) {
					String BmyqWpwB = entry.getValue().toString().toLowerCase();
					if (BmyqWpwB.contains("charset")) {
						FjWQWngB = extractEncoding(BmyqWpwB);
						if (FjWQWngB != null && !FjWQWngB.isEmpty())
							return FjWQWngB;
					}
				}
			}
			wYtHubcx = new BufferedReader(new InputStreamReader(Ut8xP6aY.getInputStream()));
			String iOosZP6a;
			while ((iOosZP6a = wYtHubcx.readLine()) != null) {
				iOosZP6a = iOosZP6a.toLowerCase();
				if (iOosZP6a.contains("charset") || iOosZP6a.contains("encoding")) {
					FjWQWngB = extractEncoding(iOosZP6a);
					if (FjWQWngB != null && !FjWQWngB.isEmpty())
						return FjWQWngB;
				}
			}
			return STANDARDENCODING;
		} finally {
			if (wYtHubcx != null)
				wYtHubcx.close();
		}
	}

}