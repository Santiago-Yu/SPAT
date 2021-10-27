class n8930242 {
	public HttpRequest createHttpRequest() {
		return new HttpRequest() {

			private byte[] pfH5WOmZ;

			private Vector<ReadyStateChangeListener> a13KH3o1 = new Vector<ReadyStateChangeListener>();

			public void abort() {
			}

			public void addReadyStateChangeListener(ReadyStateChangeListener VRBYvGJH) {
				a13KH3o1.add(VRBYvGJH);
			}

			public String getAllResponseHeaders() {
				return null;
			}

			public int getReadyState() {
				return pfH5WOmZ != null ? STATE_COMPLETE : STATE_UNINITIALIZED;
			}

			public byte[] getResponseBytes() {
				return pfH5WOmZ;
			}

			public String getResponseHeader(String tb4aiCn2) {
				return null;
			}

			public Image getResponseImage() {
				return pfH5WOmZ != null ? Toolkit.getDefaultToolkit().createImage(pfH5WOmZ) : null;
			}

			public String getResponseText() {
				return new String(pfH5WOmZ);
			}

			public Document getResponseXML() {
				return null;
			}

			public int getStatus() {
				return 200;
			}

			public String getStatusText() {
				return "OK";
			}

			public void open(String J3yDqUBM, String fXNRERSH) {
				open(J3yDqUBM, fXNRERSH, false);
			}

			public void open(String pBXu4Aig, URL DLi1snbs) {
				open(pBXu4Aig, DLi1snbs, false);
			}

			public void open(String hDkIoRjO, URL dkIQPCFX, boolean UPqIzyH2) {
				try {
					URLConnection EMqaQM95 = dkIQPCFX.openConnection();
					pfH5WOmZ = new byte[EMqaQM95.getContentLength()];
					InputStream wRmhmiWq = EMqaQM95.getInputStream();
					wRmhmiWq.read(pfH5WOmZ);
					wRmhmiWq.close();
					for (ReadyStateChangeListener gVE9iX6T : a13KH3o1) {
						gVE9iX6T.readyStateChanged();
					}
				} catch (IOException JphA7Zvu) {
				}
			}

			public void open(String jMWXRwlh, String w0aSlobY, boolean lJ2iY76I) {
				open(jMWXRwlh, URLHelper.createURL(w0aSlobY), lJ2iY76I);
			}

			public void open(String rkNc4bKt, String q7ivuyfK, boolean zLx3TG0y, String JEDGhqNT) {
				open(rkNc4bKt, URLHelper.createURL(q7ivuyfK), zLx3TG0y);
			}

			public void open(String GLqU31n9, String HuY8cZF0, boolean hnIF77ez, String FBRnmzOb, String pXcvyZ4m) {
				open(GLqU31n9, URLHelper.createURL(HuY8cZF0), hnIF77ez);
			}
		};
	}

}