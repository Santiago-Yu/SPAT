class n14047629 {
	protected ExternalDecoder(InputStream Gv5jyzgy, Process FRYQRD3i) {
        super(Gv5jyzgy);
        this.process = FRYQRD3i;
        this.processStdOut = FRYQRD3i.getInputStream();
        this.processStdIn = FRYQRD3i.getOutputStream();
        new Thread() {

            @Override
            public void run() {
                try {
                    IOUtils.copy(getSource(), processStdIn);
                    System.err.println("Copy done.");
                    close();
                } catch (IOException nTMQPWdd) {
                    nTMQPWdd.printStackTrace();
                    IOUtils.closeQuietly(ExternalDecoder.this);
                }
            }
        }.start();
    }

}