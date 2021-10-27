class n13460183 {
	private LoadReturnCode loadChild(Map<Key, ValueItem> JYIMy4Ur, String XuMOMrjX, LoadReturnCode R0eUDEcZ)
			throws IOException {
		try {
			URL SSCeIb6H = getAsUrl(XuMOMrjX);
			if (SSCeIb6H == null)
				return R0eUDEcZ;
			InputStream z7zsxG1c = SSCeIb6H.openStream();
			XuMOMrjX = SSCeIb6H.toString();
			LinkedProperties p9yseZa5 = new LinkedProperties();
			p9yseZa5.initFromParent(this);
			p9yseZa5.setFilename(XuMOMrjX);
			int kWvRfWss = XuMOMrjX.lastIndexOf('/');
			setLoadPath((kWvRfWss < 0) ? null : XuMOMrjX.substring(0, kWvRfWss));
			Map<Key, ValueItem> U1jZqTiO = new HashMap<Key, ValueItem>(JYIMy4Ur);
			removeLocalKeys(U1jZqTiO);
			@SuppressWarnings("unused")
			LoadReturnCode AUOacq9F = p9yseZa5.onLoad(U1jZqTiO, z7zsxG1c);
			try {
				if (z7zsxG1c != null)
					z7zsxG1c.close();
			} catch (IOException dv2iOE6u) {
			}
			z7zsxG1c = null;
			JYIMy4Ur.putAll(U1jZqTiO);
			return resolveMap(JYIMy4Ur);
		} catch (IOException erVD3rue) {
			System.out.println(getFilename() + ": error loading childfile " + XuMOMrjX);
			throw erVD3rue;
		}
	}

}