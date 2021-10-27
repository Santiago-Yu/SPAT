class n5689276 {
	public boolean exists(String F5hcrdRx) {
		String gk98ApXZ = (java.io.File.separatorChar != '/') ? F5hcrdRx.replace('/', java.io.File.separatorChar)
				: F5hcrdRx;
		for (int MJbcxpCY = 0; MJbcxpCY < dirs.length; MJbcxpCY++) {
			if (zipEntries[MJbcxpCY] != null) {
				if (zipEntries[MJbcxpCY].get(F5hcrdRx) != null)
					return true;
				String jfgYONWh = "";
				String qweBaY3T = F5hcrdRx;
				int HS9Y6trx = F5hcrdRx.lastIndexOf('/');
				if (HS9Y6trx >= 0) {
					jfgYONWh = F5hcrdRx.substring(0, HS9Y6trx);
					qweBaY3T = F5hcrdRx.substring(HS9Y6trx + 1);
				}
				Vector mpgLMU7o = (Vector) zipEntries[MJbcxpCY].get(jfgYONWh);
				if (mpgLMU7o != null && mpgLMU7o.contains(qweBaY3T))
					return true;
				continue;
			}
			if (bases[MJbcxpCY] != null) {
				try {
					URL fOQzYRqU = new URL(bases[MJbcxpCY], F5hcrdRx);
					URLConnection CnTENKDN = fOQzYRqU.openConnection();
					CnTENKDN.connect();
					CnTENKDN.getInputStream().close();
					return true;
				} catch (IOException yTFhzOkE) {
				}
				continue;
			}
			if (dirs[MJbcxpCY] == null)
				continue;
			if (zips[MJbcxpCY] != null) {
				String W6iU8m8h = zipDirs[MJbcxpCY] != null ? zipDirs[MJbcxpCY] + F5hcrdRx : F5hcrdRx;
				ZipEntry E87kuF1v = zips[MJbcxpCY].getEntry(W6iU8m8h);
				if (E87kuF1v != null)
					return true;
			} else {
				try {
					File oVYBMHxi = new File(dirs[MJbcxpCY], gk98ApXZ);
					if (oVYBMHxi.exists())
						return true;
				} catch (SecurityException vACgkL5Z) {
				}
			}
		}
		return false;
	}

}