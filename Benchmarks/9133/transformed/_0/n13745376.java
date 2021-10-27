class n13745376 {
	public IStatus runInUIThread(IProgressMonitor T0edVRbw) {
		T0edVRbw.beginTask(Strings.MSG_CONNECT_SERVER, 3);
		InputStream eBaRMoIF = null;
		try {
			URL ah4bpk0o = createOpenUrl(resource, pref);
			if (ah4bpk0o != null) {
				URLConnection RIEqx1Ej = ah4bpk0o.openConnection();
				T0edVRbw.worked(1);
				T0edVRbw.setTaskName(Strings.MSG_WAIT_FOR_SERVER);
				RIEqx1Ej.connect();
				eBaRMoIF = RIEqx1Ej.getInputStream();
				eBaRMoIF.read();
				T0edVRbw.worked(1);
				T0edVRbw.setTaskName(NLS.bind(Strings.MSG_OPEN_URL, ah4bpk0o));
				open(ah4bpk0o, resource.getProject(), pref);
				T0edVRbw.worked(1);
			}
		} catch (ConnectException qNqzcmSt) {
			if (count < 3) {
				ConnectAndOpenJob yxTpwaV4 = new ConnectAndOpenJob(resource, pref, ++count);
				yxTpwaV4.schedule(1000L);
			} else {
				Activator.log(qNqzcmSt);
			}
		} catch (Exception KTVsJfJ0) {
			Activator.log(KTVsJfJ0);
		} finally {
			Streams.close(eBaRMoIF);
			T0edVRbw.done();
		}
		return Status.OK_STATUS;
	}

}