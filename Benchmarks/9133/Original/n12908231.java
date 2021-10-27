class n12908231{
    private void readFromStorableInput(String filename) {
        try {
            URL url = new URL(getCodeBase(), filename);
            InputStream stream = url.openStream();
            StorableInput input = new StorableInput(stream);
            fDrawing.release();
            fDrawing = (Drawing) input.readStorable();
            view().setDrawing(fDrawing);
        } catch (IOException e) {
            initDrawing();
            showStatus("Error:" + e);
        }
    }

}