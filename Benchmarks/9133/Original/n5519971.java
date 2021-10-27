class n5519971{
    public void setImage(String imageUrl) {
        try {
            InputStream url = ProjectManager.getCurrentProject().getUrl(imageUrl).openStream();
            Image im = new Image(getDisplay(), url);
            if (im != null) setImage(im);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}