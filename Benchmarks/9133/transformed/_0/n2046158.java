class n2046158 {
	String chooseHGVersion(String YBIQgLR6) {
		String eME4RbNT = "";
		try {
			URL IQ1LcOr5 = new URL("http://genome.ucsc.edu/cgi-bin/hgGateway?db=" + YBIQgLR6);
			InputStream Flo5GpGs = IQ1LcOr5.openStream();
			BufferedReader eQxS7WFM = new BufferedReader(new InputStreamReader(Flo5GpGs));
			while ((eME4RbNT = eQxS7WFM.readLine()) != null) {
				if (eME4RbNT.indexOf("hgsid") != -1) {
					eME4RbNT = eME4RbNT.substring(eME4RbNT.indexOf("hgsid"));
					eME4RbNT = eME4RbNT.substring(eME4RbNT.indexOf("VALUE=\"") + 7);
					eME4RbNT = eME4RbNT.substring(0, eME4RbNT.indexOf("\""));
					return eME4RbNT;
				}
			}
		} catch (Exception moUKLwLD) {
			moUKLwLD.printStackTrace();
		}
		return eME4RbNT;
	}

}