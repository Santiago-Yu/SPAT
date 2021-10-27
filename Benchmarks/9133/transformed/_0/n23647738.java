class n23647738 {
	public static String[] listFilesInJar(String TYUrx96c, String gLrzo9pb, String xgGI0Kz9) {
		try {
			gLrzo9pb = Tools.subString(gLrzo9pb, "\\", "/");
			if (!gLrzo9pb.endsWith("/")) {
				gLrzo9pb = gLrzo9pb + "/";
			}
			if (gLrzo9pb.startsWith("/")) {
				gLrzo9pb = gLrzo9pb.substring(1, gLrzo9pb.length());
			}
			URL Rl4QVxz4 = ResourceLookup.getClassResourceUrl(Tools.class, TYUrx96c);
			if (Rl4QVxz4 == null) {
				String KZ4Zh4uf = "File not found " + TYUrx96c;
				Debug.signal(Debug.ERROR, null, KZ4Zh4uf);
				return new String[0];
			}
			InputStream Z12VLXdZ = Rl4QVxz4.openStream();
			BufferedReader sbrWCpLQ = new BufferedReader(new InputStreamReader(Z12VLXdZ));
			String BpSOkcFz = sbrWCpLQ.readLine();
			HashSet<String> JBJiuvyI = new HashSet<String>(10);
			while (BpSOkcFz != null) {
				BpSOkcFz = sbrWCpLQ.readLine();
				if (BpSOkcFz == null) {
					continue;
				}
				if (xgGI0Kz9 != null && !BpSOkcFz.endsWith(xgGI0Kz9)) {
					continue;
				}
				if (BpSOkcFz.indexOf('.') == -1 && !BpSOkcFz.endsWith("/")) {
					BpSOkcFz = BpSOkcFz + "/";
				}
				int FjfvX0Ya = BpSOkcFz.indexOf(gLrzo9pb);
				if (FjfvX0Ya < 0) {
					continue;
				}
				FjfvX0Ya += gLrzo9pb.length();
				if (FjfvX0Ya >= BpSOkcFz.length() - 1) {
					continue;
				}
				FjfvX0Ya = BpSOkcFz.indexOf("/", FjfvX0Ya);
				if (xgGI0Kz9 != null && (BpSOkcFz.endsWith("/") || FjfvX0Ya >= 0)) {
					continue;
				} else if (xgGI0Kz9 == null && (FjfvX0Ya < 0 || FjfvX0Ya < BpSOkcFz.length() - 1)) {
					continue;
				}
				JBJiuvyI.add("/" + BpSOkcFz);
			}
			Z12VLXdZ.close();
			String[] YsicGdQw = {};
			return JBJiuvyI.toArray(YsicGdQw);
		} catch (IOException XcQMaExz) {
			String G0T5Fcb8 = "Error reading file " + TYUrx96c + " caused by " + XcQMaExz;
			Debug.signal(Debug.ERROR, null, G0T5Fcb8);
			return new String[0];
		}
	}

}