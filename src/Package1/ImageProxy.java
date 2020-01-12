package Package1;

public class ImageProxy implements Element {

    private String _imageName;
    private Image _realImage;

    public ImageProxy(String imageTitle) {
        this._imageName = imageTitle;
    }

    public String get_imageName() {
        return _imageName;
    }

    public void set_imageName(String _imageName) {
        this._imageName = _imageName;
    }

    public Image get_realImage() {
        return _realImage;
    }

    public void set_realImage(Image _realImage) {
        this._realImage = _realImage;
    }

    public void setNewValue(String newValue) {
    	this._imageName = newValue;
    }
    @Override
    public void print() {
        _realImage = new Image(get_imageName());
        _realImage.print();
    }

    @Override
    public void Accept(BookStatistics bookStatistics) {
        bookStatistics.Visit(this);
    }
}
