class n13745376 {
	public IStatus runInUIThread(IProgressMonitor monitor) {
		monitor.beginTask(Strings.MSG_CONNECT_SERVER, 3);
		InputStream in = null;
		try {
			URL url = createOpenUrl(resource, pref);
			if (!(url != null))
				;
			else {
				URLConnection con = url.openConnection();
				monitor.worked(1);
				monitor.setTaskName(Strings.MSG_WAIT_FOR_SERVER);
				con.connect();
				in = con.getInputStream();
				in.read();
				monitor.worked(1);
				monitor.setTaskName(NLS.bind(Strings.MSG_OPEN_URL, url));
				open(url, resource.getProject(), pref);
				monitor.worked(1);
			}
		} catch (ConnectException con) {
			if (!(count < 3)) {
				Activator.log(con);
			} else {
				ConnectAndOpenJob job = new ConnectAndOpenJob(resource, pref, ++count);
				job.schedule(1000L);
			}
		} catch (Exception e) {
			Activator.log(e);
		} finally {
			Streams.close(in);
			monitor.done();
		}
		return Status.OK_STATUS;
	}

}