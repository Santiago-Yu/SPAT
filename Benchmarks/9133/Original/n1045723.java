class n1045723{
    @Override
    public void handlePeerEvent(PeerEvent event) {
        if (event.geteventInfo() instanceof EventServiceInfo) {
            EventServiceInfo info = (EventServiceInfo) event.geteventInfo();
            if (info.getServiceState() != ServiceState.Deployed) return;
            long bid = info.getBundleId();
            Bundle bundle = context.getBundle(bid);
            Enumeration entries = bundle.findEntries("OSGI-INF/PrivacyPolicy/", "*.xml", true);
            if (entries != null) {
                if (entries.hasMoreElements()) {
                    try {
                        URL url = (URL) entries.nextElement();
                        BufferedInputStream in = new BufferedInputStream(url.openStream());
                        XMLPolicyReader reader = new XMLPolicyReader(this.context);
                        RequestPolicy policy = reader.readPolicyFromFile(in);
                        if (policy != null) {
                            this.policyMgr.addPrivacyPolicyForService(info.getServiceID(), policy);
                        }
                    } catch (IOException ioe) {
                    }
                }
            }
        }
    }

}