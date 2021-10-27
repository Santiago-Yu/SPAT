class n19591847{
        @Override
        public void run() {
            try {
                for (int r = 0; r < this.requestCount; r++) {
                    HttpGet httpget = new HttpGet("/");
                    HttpResponse response = this.httpclient.execute(this.target, httpget, this.context);
                    this.count++;
                    ManagedClientConnection conn = (ManagedClientConnection) this.context.getAttribute(ExecutionContext.HTTP_CONNECTION);
                    this.context.setAttribute("r" + r, conn.getState());
                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        entity.consumeContent();
                    }
                }
            } catch (Exception ex) {
                this.exception = ex;
            }
        }

}