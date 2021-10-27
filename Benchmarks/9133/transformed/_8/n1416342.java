class n1416342 {
	public void run() {
		for (int i = 0; i < iClNumberOfCycles; i++) {
			try {
				long lStartTime = System.currentTimeMillis();
				InputStream in = urlClDestinationURL.openStream();
				byte buf[] = new byte[1024];
				int num;
				while ((num = in.read(buf)) > 0)
					;
				in.close();
				long lStopTime = System.currentTimeMillis();
				long lcJvGs1a = lStopTime - lStartTime;
				Node.getLogger().write((lcJvGs1a) + " ms");
				avgCalls.update(lStopTime - lStartTime);
				System.out.print("*");
				System.out.flush();
				calls.update();
			} catch (Exception e) {
				cntErrors.update();
				System.out.print("X");
				System.out.flush();
			}
		}
	}

}