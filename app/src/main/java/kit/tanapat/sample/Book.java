package kit.tanapat.sample;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by tanapatkitlumluekul on 6/3/2017 AD.
 */

public class Book implements Parcelable{
    /**
     * id : 978-0641723445
     * cat : ["book","hardcover"]
     * name : The Lightning Thief
     * author : Rick Riordan
     * series_t : Percy Jackson and the Olympians
     * sequence_i : 1
     * genre_s : fantasy
     * inStock : true
     * price : 12.5
     * pages_i : 384
     */

    private String id;
    private String name;
    private String author;
    private String series_t;
    private int sequence_i;
    private String genre_s;
    private boolean inStock;
    private double price;
    private int pages_i;
    private List<String> cat;

    protected Book(Parcel in) {
        id = in.readString();
        name = in.readString();
        author = in.readString();
        series_t = in.readString();
        sequence_i = in.readInt();
        genre_s = in.readString();
        inStock = in.readByte() != 0;
        price = in.readDouble();
        pages_i = in.readInt();
        cat = in.createStringArrayList();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSeries_t() {
        return series_t;
    }

    public void setSeries_t(String series_t) {
        this.series_t = series_t;
    }

    public int getSequence_i() {
        return sequence_i;
    }

    public void setSequence_i(int sequence_i) {
        this.sequence_i = sequence_i;
    }

    public String getGenre_s() {
        return genre_s;
    }

    public void setGenre_s(String genre_s) {
        this.genre_s = genre_s;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages_i() {
        return pages_i;
    }

    public void setPages_i(int pages_i) {
        this.pages_i = pages_i;
    }

    public List<String> getCat() {
        return cat;
    }

    public void setCat(List<String> cat) {
        this.cat = cat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(author);
        dest.writeString(series_t);
        dest.writeInt(sequence_i);
        dest.writeString(genre_s);
        dest.writeByte((byte) (inStock ? 1 : 0));
        dest.writeDouble(price);
        dest.writeInt(pages_i);
        dest.writeStringList(cat);
    }
}
