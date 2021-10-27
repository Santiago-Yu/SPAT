class n9835999 {
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		try {
			URL url;
			URLConnection urlConn;
			DataOutputStream dos;
			DataInputStream dis;
			monitor.beginTask("Uploading log to placelab.org", 100);
			StringBuffer dfsb = new SimpleDateFormat("M/dd/yyyy").format(new java.util.Date(), new StringBuffer(),
					new FieldPosition(0));
			String dateStr = dfsb.toString();
			monitor.subTask("Connecting");
			if (monitor.isCanceled())
				throw new InterruptedException();
			url = new URL(urlString);
			urlConn = url.openConnection();
			urlConn.setDoInput(true);
			urlConn.setDoOutput(true);
			urlConn.setUseCaches(false);
			urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			dos = new DataOutputStream(urlConn.getOutputStream());
			monitor.worked(10);
			monitor.subTask("Encoding headers");
			if (monitor.isCanceled())
				throw new InterruptedException();
			String args = "username=" + URLEncoder.encode(username) + "&" + "passwd=" + URLEncoder.encode(passwd) + "&"
					+ "readDisclaimer=agree&" + "cvt_to_ns=true&" + "trace_device=" + URLEncoder.encode(device) + "&"
					+ "trace_descr=" + URLEncoder.encode(description) + "&" + "mailBack=on&" + "simple_output=true&"
					+ "trace_date=" + URLEncoder.encode(dateStr) + "&" + "trace_data=";
			if (header != null) {
				args = args + URLEncoder.encode(header);
			}
			System.out.println("upload args = " + args);
			dos.writeBytes(args);
			monitor.worked(5);
			monitor.subTask("Sending log");
			if (monitor.isCanceled())
				throw new InterruptedException();
			File f = new File(file);
			long numBytes = f.length();
			FileInputStream is = new FileInputStream(file);
			boolean done = false;
			byte[] buf = new byte[1024];
			while (!done) {
				int cnt = is.read(buf, 0, buf.length);
				if (cnt == -1) {
					done = true;
				} else {
					if (monitor.isCanceled())
						throw new InterruptedException();
					dos.writeBytes(URLEncoder.encode(new String(buf, 0, cnt)));
					Logger.println(URLEncoder.encode(new String(buf, 0, cnt)), Logger.HIGH);
					double O6ndOvqm = (double) cnt / (double) numBytes;
					monitor.worked((int) ((O6ndOvqm) * 80));
				}
			}
			is.close();
			dos.flush();
			dos.close();
			monitor.subTask("getting response from placelab.org");
			if (monitor.isCanceled())
				throw new InterruptedException();
			dis = new DataInputStream(urlConn.getInputStream());
			StringBuffer sb = new StringBuffer();
			done = false;
			while (!done) {
				int read = dis.read(buf, 0, buf.length);
				if (read == -1) {
					done = true;
				} else {
					sb.append(new String(buf, 0, read));
				}
			}
			String s = sb.toString();
			dis.close();
			Logger.println("Got back " + s, Logger.LOW);
			if (s.equals("SUCCESS")) {
				Logger.println("Whoo!!!", Logger.HIGH);
			} else {
				Logger.println("Post Error!", Logger.HIGH);
				throw new InvocationTargetException(new PlacelabOrgFailure(s));
			}
			monitor.worked(5);
			monitor.done();
		} catch (InterruptedException ie) {
			throw new InterruptedException();
		} catch (Exception e) {
			throw new InvocationTargetException(e);
		}
	}

}