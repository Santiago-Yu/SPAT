class n7902692 {
	@Override
	public MapInfo getMap(int RfG3U4bG) {
		MapInfo bRjBsxz1 = mapCache.get(RfG3U4bG);
		if (bRjBsxz1 != null && bRjBsxz1.getContent() == null) {
			if (bRjBsxz1.getInfo().get("fileName") == null) {
				if (RfG3U4bG != lastRequestedMap) {
					lastRequestedMap = RfG3U4bG;
					System.out.println("MapLoaderClient::getMap:requesting map from server " + RfG3U4bG);
					serverConnection.sendMessage(new MessageFetch(FetchType.map.name(), RfG3U4bG));
				}
			} else {
				try {
					System.out.println(
							"MapLoaderClient::getMap:loading map from file " + bRjBsxz1.getInfo().get("fileName"));
					BufferedReader RX5hDhbX;
					URL OFhOpQVn = new URL(localMapContextUrl, bRjBsxz1.getInfo().get("fileName"));
					URLConnection nUkNvPKb = OFhOpQVn.openConnection();
					if (nUkNvPKb.getContentEncoding() != null) {
						RX5hDhbX = new BufferedReader(
								new InputStreamReader(nUkNvPKb.getInputStream(), nUkNvPKb.getContentEncoding()));
					} else {
						RX5hDhbX = new BufferedReader(new InputStreamReader(nUkNvPKb.getInputStream(), "utf-8"));
					}
					String WgiC2iJ0;
					StringBuilder Tl3SddAh = new StringBuilder();
					while ((WgiC2iJ0 = RX5hDhbX.readLine()) != null) {
						Tl3SddAh.append(WgiC2iJ0);
						Tl3SddAh.append("\n");
					}
					bRjBsxz1.setContent(Tl3SddAh.toString());
					fireMapChanged(bRjBsxz1);
				} catch (IOException PoAhdBTp) {
					System.err
							.println("MapLoaderClient::getMap:: Can't read from " + bRjBsxz1.getInfo().get("fileName"));
				}
			}
		}
		return bRjBsxz1;
	}

}