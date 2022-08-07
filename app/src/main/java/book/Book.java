package book;

/**
 * 本のクラス
 */
public class Book {
    private final String title;
    private final String author;

    /**
     * 初期値の代入
     * 
     * @param title タイトル
     * @param author 著者
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    /**
     * タイトルを取得
     * 
     * @return タイトル
     */
    public String title() {
        return this.title;
    }

    /**
     * 著者を取得
     * 
     * @return 著者
     */
    public String author() {
        return this.author;
    }

    /**
     * 同じ本であるかのチェック
     * 
     * @param other チェック対象
     * @return 同じ本であるか
     */
    public boolean isSame(Book other) {
        return this.title == other.title && this.author == other.author;
    }
}
