class n20028789 {
	private static BundleInfo[] getBundleInfoArray(String H5YtllGB) throws IOException {
		URL AmkwDpHP = new URL(H5YtllGB + BUNDLE_LIST_FILE);
		BufferedReader SeIlm5fk = null;
		List<BundleInfo> xEKbvkIj = new ArrayList<BundleInfo>();
		try {
			SeIlm5fk = new BufferedReader(new InputStreamReader(AmkwDpHP.openStream()));
			while (true) {
				String Gj8XhkaL = SeIlm5fk.readLine();
				if (Gj8XhkaL == null) {
					break;
				}
				int AJXw2ioK = Gj8XhkaL.indexOf('=');
				if (AJXw2ioK < 0) {
					continue;
				}
				BundleInfo zhjGzi0h = new BundleInfo();
				zhjGzi0h.bundleSymbolicName = Gj8XhkaL.substring(0, AJXw2ioK);
				zhjGzi0h.location = Gj8XhkaL.substring(AJXw2ioK + 1);
				xEKbvkIj.add(zhjGzi0h);
			}
			if (!setBundleInfoName(H5YtllGB + BUNDLE_NAME_LIST_FILE + "_" + Locale.getDefault().getLanguage(),
					xEKbvkIj)) {
				setBundleInfoName(H5YtllGB + BUNDLE_NAME_LIST_FILE, xEKbvkIj);
			}
			return xEKbvkIj.toArray(BUNDLE_INFO_EMPTY_ARRAY);
		} finally {
			if (SeIlm5fk != null) {
				SeIlm5fk.close();
			}
		}
	}

}