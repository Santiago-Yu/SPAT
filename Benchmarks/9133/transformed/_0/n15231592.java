class n15231592 {
	public File download(Show gj2qOyKA) throws Exception {
		Collection<String> yCtkOoCs = Util.toCollection((List<String>) this.exclude.clone(),
				Util.nonNullString(gj2qOyKA.getExclude()).split(","));
		URL mJhHeMSA = new URL("http://v3.newzbin.com/search/" + buildQuery(gj2qOyKA));
		BufferedReader Jr3hjYBA = new BufferedReader(new InputStreamReader(mJhHeMSA.openStream()));
		String CcR3WdJG;
		while ((CcR3WdJG = Jr3hjYBA.readLine()) != null) {
			if (!Util.containsNone(CcR3WdJG, yCtkOoCs))
				continue;
			String vwA2jymt = CcR3WdJG.split("\",\"", 3)[1];
			File s7CfpV2M = download(gj2qOyKA, vwA2jymt);
			if (s7CfpV2M != null)
				return s7CfpV2M;
		}
		return null;
	}

}