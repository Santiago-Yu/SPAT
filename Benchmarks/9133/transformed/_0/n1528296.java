class n1528296 {
	public static Hashtable DefaultLoginValues(String jItq8hCy, String bUVxnAZT, String kpqSfjpZ, String bZfiTWDz,
			String vTyyFXCU, int MLSK7kjQ, int OzJlMB3r, int SwMckxb6, int eup6MpEN, String YesXkspf, String KBYJqHuU,
			String Ywic1ilS, String oA4OCUSw) throws Exception {
		Hashtable qzHJMuWW = new Hashtable();
		MessageDigest RQ3JGg5q = MessageDigest.getInstance("MD5");
		RQ3JGg5q.update(kpqSfjpZ.getBytes("ASCII"), 0, kpqSfjpZ.length());
		byte[] iPkCwfxn = RQ3JGg5q.digest();
		String P8ogKIsD = Helpers.toHexText(iPkCwfxn);
		qzHJMuWW.put("first", jItq8hCy);
		qzHJMuWW.put("last", bUVxnAZT);
		qzHJMuWW.put("passwd", "" + kpqSfjpZ);
		qzHJMuWW.put("start", vTyyFXCU);
		qzHJMuWW.put("major", MLSK7kjQ);
		qzHJMuWW.put("minor", OzJlMB3r);
		qzHJMuWW.put("patch", SwMckxb6);
		qzHJMuWW.put("build", eup6MpEN);
		qzHJMuWW.put("platform", YesXkspf);
		qzHJMuWW.put("mac", bZfiTWDz);
		qzHJMuWW.put("agree_to_tos", "true");
		qzHJMuWW.put("viewer_digest", KBYJqHuU);
		qzHJMuWW.put("user-agent", Ywic1ilS + " (" + Helpers.VERSION + ")");
		qzHJMuWW.put("author", oA4OCUSw);
		Vector LBHWMvxO = new Vector();
		LBHWMvxO.addElement("inventory-root");
		LBHWMvxO.addElement("inventory-skeleton");
		LBHWMvxO.addElement("inventory-lib-root");
		LBHWMvxO.addElement("inventory-lib-owner");
		LBHWMvxO.addElement("inventory-skel-lib");
		LBHWMvxO.addElement("initial-outfit");
		LBHWMvxO.addElement("gestures");
		LBHWMvxO.addElement("event_categories");
		LBHWMvxO.addElement("event_notifications");
		LBHWMvxO.addElement("classified_categories");
		LBHWMvxO.addElement("buddy-list");
		LBHWMvxO.addElement("ui-config");
		LBHWMvxO.addElement("login-flags");
		LBHWMvxO.addElement("global-textures");
		qzHJMuWW.put("options", LBHWMvxO);
		return qzHJMuWW;
	}

}