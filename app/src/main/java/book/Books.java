package book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Bookクラスのファーストコレクションクラス
 */
public class Books {
    private final List<Book> value;

    /**
     * 引数が空であった場合はどの本も用意しないようにする
     */
    public Books() {
        this(new ArrayList<>());
    }

    /**
     * 引数で指定された本の重複を削除し、プロパティに入れ込む
     * 
     * @param books 入れ込みたい本の一覧
     */
    public Books(final List<Book> books) {
        List<Book> notDuplicatedBookList = new ArrayList<>();
        books.stream().forEach(newBook -> {
            if (notDuplicatedBookList.stream()
                    .anyMatch(notDuplicatedBook -> notDuplicatedBook.isSame(newBook))) {
                return;
            }
            notDuplicatedBookList.add(newBook);
        });

        this.value = notDuplicatedBookList;
    }

    /**
     * 新しい本が追加されたBooksクラスを返す
     * 
     * @param newBooks 追加したい本がまとめられたBooksインスタンス
     * @return 本が追加されたBooksクラス
     */
    public Books add(final Books newBooks) {
        List<Book> notExistingNewBookList = newBooks.value.stream()
                .filter(newBook -> !this.alreadyInList(newBook)).collect(Collectors.toList());

        return new Books(Stream.concat(this.value.stream(), notExistingNewBookList.stream())
                .collect(Collectors.toList()));
    }

    /**
     * @param newBook 重複があるか確認したい本
     * @return 重複が発生しているかどうか
     */
    private boolean alreadyInList(final Book newBook) {
        return this.value.stream().anyMatch(book -> book.isSame(newBook));
    }

    /**
     * 本の冊数を返す
     * 
     * @return 本の冊数
     */
    public int numberOfBooks() {
        return this.value.size();
    }

    /**
     * index番目の本を取得する
     * 
     * @param index 取得したい本のインデクス
     * @return インデクスに合った本
     * @throws IllegalArgumentException 本が存在しなかったら例外
     */
    public Book takeOut(int index) {
        if (index >= this.value.size()) {
            throw new IllegalArgumentException(String.format("%d番目の本は存在しません。", index));
        }
        return this.value.get(index);
    }
}
