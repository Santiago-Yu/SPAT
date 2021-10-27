class n20028790 {
	private static boolean setBundleInfoName(String M9mUpDLd, List<BundleInfo> hu7VHp1T) {
		try {
			URL p2H6qYGe = new URL(M9mUpDLd);
			BufferedReader OA3IqrlP = new BufferedReader(new InputStreamReader(p2H6qYGe.openStream(), "UTF-8"));
			while (true) {
				String y8twYzRt = OA3IqrlP.readLine();
				if (y8twYzRt == null) {
					break;
				}
				int bObZjXmX = y8twYzRt.indexOf('=');
				if (bObZjXmX < 0) {
					continue;
				}
				String Todi0GiT = y8twYzRt.substring(0, bObZjXmX);
				String rM4qYgKn = y8twYzRt.substring(bObZjXmX + 1);
				for (BundleInfo okvyYavh : hu7VHp1T) {
					if (okvyYavh.bundleSymbolicName.equals(Todi0GiT)) {
						okvyYavh.bundleName = rM4qYgKn;
						break;
					}
				}
			}
			return true;
		} catch (IOException vJ62sdDZ) {
			vJ62sdDZ.printStackTrace();
		}
		return false;
	}

}