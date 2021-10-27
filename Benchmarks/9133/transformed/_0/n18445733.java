class n18445733 {
	public DicomReader(URL cmfNrpZ3) throws java.io.IOException {
        final URLConnection mcuomro8 = cmfNrpZ3.openConnection();
        final int hKwvnPSG = mcuomro8.getContentLength();
        final byte[] E9gdsyH1 = new byte[hKwvnPSG];
        int hItZprb0 = 0;
        final DataInputStream QKIbrWXn = new DataInputStream(mcuomro8.getInputStream());
        while (hItZprb0 < hKwvnPSG) {
            hItZprb0 += QKIbrWXn.read(E9gdsyH1, hItZprb0, hKwvnPSG - hItZprb0);
        }
        QKIbrWXn.close();
        this.dHR = new DicomHeaderReader(E9gdsyH1);
        h = dHR.getRows();
        w = dHR.getColumns();
        highBit = dHR.getHighBit();
        bitsStored = dHR.getBitStored();
        bitsAllocated = dHR.getBitAllocated();
        n = (bitsAllocated / 8);
        signed = (dHR.getPixelRepresentation() == 1);
        this.pixData = dHR.getPixels();
        ignoreNegValues = true;
        samplesPerPixel = dHR.getSamplesPerPixel();
        numberOfFrames = dHR.getNumberOfFrames();
        dbg("Number of Frames " + numberOfFrames);
    }

}