class n7034888{
    public void put(IMetaCollection aCollection) throws TransducerException {
        if (null != ioTransducer) {
            try {
                URL urlObj = new URL(url);
                URLConnection urlConn = urlObj.openConnection();
                OutputStreamWriter sw = new OutputStreamWriter(urlConn.getOutputStream());
                ioTransducer.setWriter(new BufferedWriter(sw));
                ioTransducer.put(aCollection);
            } catch (Exception e) {
                throw new TransducerException(e);
            }
        } else {
            throw new TransducerException("An IIOTransducer instance must first be set on the URLTransducerAdapter.");
        }
    }

}