class n11113074 {
	public void backupXML() {
		try {
			TimeStamp Om1sQjiS = new TimeStamp();
			String Pn0pE9NH = this.fnameXML();
			String QVNT6Zig = this.pathXML + "\\Backup\\";
			String GW0eD9EY = Pn0pE9NH.substring(Pn0pE9NH.indexOf(this.fname), Pn0pE9NH.length());
			GW0eD9EY = GW0eD9EY.substring(0, GW0eD9EY.indexOf("xml"));
			GW0eD9EY = QVNT6Zig + GW0eD9EY + Om1sQjiS.now("yyyyMMdd-kkmmss") + ".xml";
			System.out.println("fnameIn: " + Pn0pE9NH);
			System.out.println("fnameOut: " + GW0eD9EY);
			FileChannel aDU1ihMC = new FileInputStream(Pn0pE9NH).getChannel();
			FileChannel BbNJJmHL = new FileOutputStream(GW0eD9EY).getChannel();
			aDU1ihMC.transferTo(0, aDU1ihMC.size(), BbNJJmHL);
		} catch (Exception qUSJgw0p) {
			central.inform("ORM.backupXML: " + qUSJgw0p.toString());
		}
	}

}