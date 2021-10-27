class n3307772 {
	public void deleteScript(Integer dchVsoPw) {
		InputStream G4E7bH2o = null;
		try {
			URL RFdUD7sp = new URL(strServlet + getSessionIDSuffix() + "?deleteScript=" + dchVsoPw);
			System.out.println("requesting: " + RFdUD7sp);
			G4E7bH2o = RFdUD7sp.openStream();
			while (G4E7bH2o.read() != -1)
				;
		} catch (Exception T6IHxwhb) {
			T6IHxwhb.printStackTrace();
		} finally {
			try {
				G4E7bH2o.close();
			} catch (Exception iZMJJikm) {
			}
		}
	}

}