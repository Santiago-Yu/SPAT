class n2191115 {
	protected List<Datastream> getDatastreams(final DepositCollection thgfS3nh) throws IOException, SWORDException {
		List<Datastream> Ae5mWVDS = super.getDatastreams(thgfS3nh);
		FileInputStream NwXKUfkH = null;
		String Tdq385Av = ((LocalDatastream) Ae5mWVDS.get(0)).getPath();
		String mQ330f7h = this.getTempDir() + "uploaded-file.tmp";
		IOUtils.copy(NwXKUfkH = new FileInputStream(Tdq385Av), new FileOutputStream(mQ330f7h + ".thum"));
		NwXKUfkH.close();
		Datastream WEou1KnD = new LocalDatastream("THUMBRES_IMG", this.getContentType(), mQ330f7h + ".thum");
		Ae5mWVDS.add(WEou1KnD);
		IOUtils.copy(NwXKUfkH = new FileInputStream(Tdq385Av), new FileOutputStream(mQ330f7h + ".mid"));
		NwXKUfkH.close();
		Datastream WlfaZjCV = new LocalDatastream("MEDRES_IMG", this.getContentType(), mQ330f7h + ".mid");
		Ae5mWVDS.add(WlfaZjCV);
		IOUtils.copy(NwXKUfkH = new FileInputStream(Tdq385Av), new FileOutputStream(mQ330f7h + ".high"));
		NwXKUfkH.close();
		Datastream b4AMXhDT = new LocalDatastream("HIGHRES_IMG", this.getContentType(), mQ330f7h + ".high");
		Ae5mWVDS.add(b4AMXhDT);
		IOUtils.copy(NwXKUfkH = new FileInputStream(Tdq385Av), new FileOutputStream(mQ330f7h + ".vhigh"));
		NwXKUfkH.close();
		Datastream hRGsjmGC = new LocalDatastream("VERYHIGHRES_IMG", this.getContentType(), mQ330f7h + ".vhigh");
		Ae5mWVDS.add(hRGsjmGC);
		return Ae5mWVDS;
	}

}