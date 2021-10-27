class n11015015{
    public Bits write(Map data) throws IOException {
        String pictureurl = (String) data.get("pictureurl");
        URL url = new URL(pictureurl);
        InputStream is = url.openStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int buf = is.read();
        while (buf >= 0) {
            baos.write(buf);
            buf = is.read();
        }
        return BitUtils._concat(BitUtils._bitsUI16(TypeUtils.toLong(data.get("shapeId"))), BitUtils._bytesToBits(baos.toByteArray()));
    }

}