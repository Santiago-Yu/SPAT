class n13964622{
    public void setImage(java.awt.Image img) {
        if (imageName != null && imageName.length() > 0) {
            try {
                InputStream url = currentProject.getUrl(imageName).openStream();
                image = new org.eclipse.swt.graphics.Image(getDisplay(), url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Display.getDefault().asyncExec(new Runnable() {

                public void run() {
                    redraw();
                }
            });
        }
    }

}