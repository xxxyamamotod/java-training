package book;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

public class BookAppTest {
    @Nested
    class シチュエーション1のテスト {
        @Test
        public void 追加する本が空の場合_入力したリストをそのまま返すこと() {
            Books emptybookShelf = new Books();
            Books toBeAppended =
                    new Books(List.of(new Book("タイトル1", "著者1"), new Book("タイトル2", "著者2")));
            Books actual = emptybookShelf.add(toBeAppended);

            assertThat(actual.takeOut(0).title()).isEqualTo("タイトル1");
            assertThat(actual.takeOut(0).author()).isEqualTo("著者1");

            assertThat(actual.takeOut(1).title()).isEqualTo("タイトル2");
            assertThat(actual.takeOut(1).author()).isEqualTo("著者2");

            assertThat(actual.numberOfBooks()).isEqualTo(2);
        }

        @Test
        public void 追加する本と初期状態の本に重複がない場合_入力したリストに追加する本をそのまま追加すること() {
            Books defauktBookShelf =
                    new Books(List.of(new Book("タイトル1", "著者1"), new Book("タイトル2", "著者2")));
            Books toBeAppended = new Books(List.of(new Book("タイトル3", "著者2")));
            Books actual = defauktBookShelf.add(toBeAppended);

            assertThat(actual.takeOut(0).title()).isEqualTo("タイトル1");
            assertThat(actual.takeOut(0).author()).isEqualTo("著者1");

            assertThat(actual.takeOut(1).title()).isEqualTo("タイトル2");
            assertThat(actual.takeOut(1).author()).isEqualTo("著者2");

            assertThat(actual.takeOut(2).title()).isEqualTo("タイトル3");
            assertThat(actual.takeOut(2).author()).isEqualTo("著者2");

            assertThat(actual.numberOfBooks()).isEqualTo(3);
        }

        @Test
        public void 追加する本と初期状態の本に重複がある場合_入力したリストに追加する本を重複を省いて追加すること() {
            Books defauktBookShelf =
                    new Books(List.of(new Book("タイトル1", "著者1"), new Book("タイトル2", "著者2")));
            Books toBeAppended =
                    new Books(List.of(new Book("タイトル2", "著者2"), new Book("タイトル3", "著者3")));
            Books actual = defauktBookShelf.add(toBeAppended);

            assertThat(actual.takeOut(0).title()).isEqualTo("タイトル1");
            assertThat(actual.takeOut(0).author()).isEqualTo("著者1");

            assertThat(actual.takeOut(1).title()).isEqualTo("タイトル2");
            assertThat(actual.takeOut(1).author()).isEqualTo("著者2");

            assertThat(actual.takeOut(2).title()).isEqualTo("タイトル3");
            assertThat(actual.takeOut(2).author()).isEqualTo("著者3");

            assertThat(actual.numberOfBooks()).isEqualTo(3);
        }

        @Test
        public void 重複を省いた結果何も残らなかった場合_入力したリストをそのまま出力すること() {
            Books defauktBookShelf =
                    new Books(List.of(new Book("タイトル1", "著者1"), new Book("タイトル2", "著者2")));
            Books toBeAppended =
                    new Books(List.of(new Book("タイトル1", "著者1"), new Book("タイトル2", "著者2")));
            Books actual = defauktBookShelf.add(toBeAppended);

            assertThat(actual.takeOut(0).title()).isEqualTo("タイトル1");
            assertThat(actual.takeOut(0).author()).isEqualTo("著者1");

            assertThat(actual.takeOut(1).title()).isEqualTo("タイトル2");
            assertThat(actual.takeOut(1).author()).isEqualTo("著者2");

            assertThat(actual.numberOfBooks()).isEqualTo(2);
        }

        @Test
        public void 追加する本の中で重複がある場合_入力したリストに追加する本を重複を省いて追加すること() {
            Books defauktBookShelf =
                    new Books(List.of(new Book("タイトル1", "著者1"), new Book("タイトル2", "著者2")));
            Books toBeAppended =
                    new Books(List.of(new Book("タイトル3", "著者3"), new Book("タイトル3", "著者3")));
            Books actual = defauktBookShelf.add(toBeAppended);

            assertThat(actual.takeOut(0).title()).isEqualTo("タイトル1");
            assertThat(actual.takeOut(0).author()).isEqualTo("著者1");

            assertThat(actual.takeOut(1).title()).isEqualTo("タイトル2");
            assertThat(actual.takeOut(1).author()).isEqualTo("著者2");

            assertThat(actual.takeOut(2).title()).isEqualTo("タイトル3");
            assertThat(actual.takeOut(2).author()).isEqualTo("著者3");

            assertThat(actual.numberOfBooks()).isEqualTo(3);
        }
    }
}
