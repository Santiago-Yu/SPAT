class n1045723 {
	@Override
	public void handlePeerEvent(PeerEvent YMnkR0iC) {
		if (YMnkR0iC.geteventInfo() instanceof EventServiceInfo) {
			EventServiceInfo JynQVPAV = (EventServiceInfo) YMnkR0iC.geteventInfo();
			if (JynQVPAV.getServiceState() != ServiceState.Deployed)
				return;
			long NVsbosc4 = JynQVPAV.getBundleId();
			Bundle ctwriQ9Y = context.getBundle(NVsbosc4);
			Enumeration XXqX2uH3 = ctwriQ9Y.findEntries("OSGI-INF/PrivacyPolicy/", "*.xml", true);
			if (XXqX2uH3 != null) {
				if (XXqX2uH3.hasMoreElements()) {
					try {
						URL EW6OZ2k0 = (URL) XXqX2uH3.nextElement();
						BufferedInputStream YDxhccxB = new BufferedInputStream(EW6OZ2k0.openStream());
						XMLPolicyReader ZK8FRBba = new XMLPolicyReader(this.context);
						RequestPolicy vksRcgbP = ZK8FRBba.readPolicyFromFile(YDxhccxB);
						if (vksRcgbP != null) {
							this.policyMgr.addPrivacyPolicyForService(JynQVPAV.getServiceID(), vksRcgbP);
						}
					} catch (IOException LpnLSFwn) {
					}
				}
			}
		}
	}

}