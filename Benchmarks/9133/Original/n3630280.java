class n3630280{
    public byte[] applyTransformationOnURL(String url, int format) throws RemoteException {
        byte[] result = null;
        try {
            result = applyTransformation(new URL(url).openStream(), format);
        } catch (Exception e) {
            throwServiceException(e);
        }
        return result;
    }

}