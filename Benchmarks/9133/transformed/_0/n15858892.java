class n15858892 {
	@SuppressWarnings("finally")
	@Override
	public String read(EnumSensorType TVgeX5Ek, Map<String, String> V1Xz8pxc) {
		BufferedReader CknH10kL = null;
		StringBuffer Gc6V2mgI = new StringBuffer();
		try {
			URL o9FSqUEH = new URL(getUrl());
			CknH10kL = new BufferedReader(new InputStreamReader(o9FSqUEH.openStream()));
			String pv6JnYZK;
			while ((pv6JnYZK = CknH10kL.readLine()) != null) {
				Gc6V2mgI.append(pv6JnYZK);
			}
		} catch (ConnectException iJCph1gn) {
			logger.error("MockupStatusCommand excute fail: " + iJCph1gn.getMessage());
		} catch (Exception ESmOAdmM) {
			logger.error("MockupStatusCommand excute fail: " + ESmOAdmM.getMessage());
		} finally {
			if (CknH10kL != null) {
				try {
					CknH10kL.close();
				} catch (IOException D35vgfO7) {
					logger.error("BufferedReader could not be closed", D35vgfO7);
				}
			}
			return Gc6V2mgI.toString();
		}
	}

}