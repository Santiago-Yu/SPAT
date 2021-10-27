class n9835999 {
	public void run(IProgressMonitor ehbnNTHZ) throws InvocationTargetException, InterruptedException {
		try {
			URL HAPDg6tA;
			URLConnection XOMxEm3x;
			DataOutputStream rgtHkzwi;
			DataInputStream FwK6IbSH;
			ehbnNTHZ.beginTask("Uploading log to placelab.org", 100);
			StringBuffer DX69qayO = new SimpleDateFormat("M/dd/yyyy").format(new java.util.Date(), new StringBuffer(),
					new FieldPosition(0));
			String qb8AeN1H = DX69qayO.toString();
			ehbnNTHZ.subTask("Connecting");
			if (ehbnNTHZ.isCanceled())
				throw new InterruptedException();
			HAPDg6tA = new URL(urlString);
			XOMxEm3x = HAPDg6tA.openConnection();
			XOMxEm3x.setDoInput(true);
			XOMxEm3x.setDoOutput(true);
			XOMxEm3x.setUseCaches(false);
			XOMxEm3x.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			rgtHkzwi = new DataOutputStream(XOMxEm3x.getOutputStream());
			ehbnNTHZ.worked(10);
			ehbnNTHZ.subTask("Encoding headers");
			if (ehbnNTHZ.isCanceled())
				throw new InterruptedException();
			String g2AmtvSP = "username=" + URLEncoder.encode(username) + "&" + "passwd=" + URLEncoder.encode(passwd)
					+ "&" + "readDisclaimer=agree&" + "cvt_to_ns=true&" + "trace_device=" + URLEncoder.encode(device)
					+ "&" + "trace_descr=" + URLEncoder.encode(description) + "&" + "mailBack=on&"
					+ "simple_output=true&" + "trace_date=" + URLEncoder.encode(qb8AeN1H) + "&" + "trace_data=";
			if (header != null) {
				g2AmtvSP = g2AmtvSP + URLEncoder.encode(header);
			}
			System.out.println("upload args = " + g2AmtvSP);
			rgtHkzwi.writeBytes(g2AmtvSP);
			ehbnNTHZ.worked(5);
			ehbnNTHZ.subTask("Sending log");
			if (ehbnNTHZ.isCanceled())
				throw new InterruptedException();
			File N1mlfhUY = new File(file);
			long Ov1gwNek = N1mlfhUY.length();
			FileInputStream JiYH7zHP = new FileInputStream(file);
			boolean YUE25gnc = false;
			byte[] bPGXsjJn = new byte[1024];
			while (!YUE25gnc) {
				int NVI446ig = JiYH7zHP.read(bPGXsjJn, 0, bPGXsjJn.length);
				if (NVI446ig == -1) {
					YUE25gnc = true;
				} else {
					if (ehbnNTHZ.isCanceled())
						throw new InterruptedException();
					rgtHkzwi.writeBytes(URLEncoder.encode(new String(bPGXsjJn, 0, NVI446ig)));
					Logger.println(URLEncoder.encode(new String(bPGXsjJn, 0, NVI446ig)), Logger.HIGH);
					ehbnNTHZ.worked((int) (((double) NVI446ig / (double) Ov1gwNek) * 80));
				}
			}
			JiYH7zHP.close();
			rgtHkzwi.flush();
			rgtHkzwi.close();
			ehbnNTHZ.subTask("getting response from placelab.org");
			if (ehbnNTHZ.isCanceled())
				throw new InterruptedException();
			FwK6IbSH = new DataInputStream(XOMxEm3x.getInputStream());
			StringBuffer WzHU8vAl = new StringBuffer();
			YUE25gnc = false;
			while (!YUE25gnc) {
				int Wfj9ToCE = FwK6IbSH.read(bPGXsjJn, 0, bPGXsjJn.length);
				if (Wfj9ToCE == -1) {
					YUE25gnc = true;
				} else {
					WzHU8vAl.append(new String(bPGXsjJn, 0, Wfj9ToCE));
				}
			}
			String yX5MYoQa = WzHU8vAl.toString();
			FwK6IbSH.close();
			Logger.println("Got back " + yX5MYoQa, Logger.LOW);
			if (yX5MYoQa.equals("SUCCESS")) {
				Logger.println("Whoo!!!", Logger.HIGH);
			} else {
				Logger.println("Post Error!", Logger.HIGH);
				throw new InvocationTargetException(new PlacelabOrgFailure(yX5MYoQa));
			}
			ehbnNTHZ.worked(5);
			ehbnNTHZ.done();
		} catch (InterruptedException Vdw1F8lC) {
			throw new InterruptedException();
		} catch (Exception hUT0VU7a) {
			throw new InvocationTargetException(hUT0VU7a);
		}
	}

}