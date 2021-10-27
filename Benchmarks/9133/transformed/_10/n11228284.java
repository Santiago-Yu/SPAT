class n11228284 {
	public static boolean copy(File src, File dest) {
		String files[] = null;
		boolean result = true;
		if (src.isDirectory()) {
			files = src.list();
			result = dest.mkdir();
		} else {
			files = new String[1];
			files[0] = "";
		}
		if (files == null) {
			files = new String[0];
		}
		for (int i = 0; (i < files.length) && result; i++) {
			File fileSrc = new File(src, files[i]);
			File fileDest = new File(dest, files[i]);
			if (fileSrc.isDirectory()) {
				result = copy(fileSrc, fileDest);
			} else {
				FileChannel oc = null;
				FileChannel ic = null;
				try {
					ic = (new FileInputStream(fileSrc)).getChannel();
					oc = (new FileOutputStream(fileDest)).getChannel();
					ic.transferTo(0, ic.size(), oc);
				} catch (IOException e) {
					log.error(sm.getString("expandWar.copy", fileSrc, fileDest), e);
					result = false;
				} finally {
					if (ic != null) {
						try {
							ic.close();
						} catch (IOException e) {
						}
					}
					if (oc != null) {
						try {
							oc.close();
						} catch (IOException e) {
						}
					}
				}
			}
		}
		return result;
	}

}