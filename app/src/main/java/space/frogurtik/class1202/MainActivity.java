package space.frogurtik.class1202;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    ListView bookList;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new Dialog(MainActivity.this);

        dialog.setContentView(R.layout.dialog_view);
        TextView text = dialog.findViewById(R.id.dialogTextView);
        TextView title_dialog_window = dialog.findViewById(R.id.title_dialog_window);

        bookList = findViewById(R.id.book_list);
        //TODO подготовка данных
        LinkedList<Book> bookLinkedList = new LinkedList<>();
        bookLinkedList.add(new Book("Основание", "А.Азимова", 2005, R.drawable.osnovanie));
        bookLinkedList.add(new Book("Преступление и наказание", "Ф. Достоевкий", 1972, R.drawable.prestuplenie));
        bookLinkedList.add(new Book("Шинель", "Н.Гоголь", 1998, R.drawable.shinel));
        bookLinkedList.add(new Book("Роковые яйца", "М. Булгаков", 1881, R.drawable.book));
        bookLinkedList.add(new Book("Колобок", "народ", 998, R.drawable.book));
        //TODO создать массив с ключами и индетефикаторами
        String[] keyArray = {"title", "author", "year", "cover"};
        int[] idArray = {R.id.title_book, R.id.author_book, R.id.year_book, R.id.cover_book};
        //TODO создание списка map для адаптера
        LinkedList<HashMap<String, Object>> listForAdapter = new LinkedList<>();
        for (int i = 0; i < bookLinkedList.size(); i++) {
            HashMap<String, Object> bookMap = new HashMap<>();
            bookMap.put(keyArray[0], bookLinkedList.get(i).title);
            bookMap.put(keyArray[1], bookLinkedList.get(i).author);
            bookMap.put(keyArray[2], bookLinkedList.get(i).year);
            bookMap.put(keyArray[3], bookLinkedList.get(i).coveredID);
            listForAdapter.add(bookMap);
        }
        //TODO создание адаптера
        //ArrayAdapter<Book> adapter = new ArrayAdapter<>(this,R.layout.list_items, bookLinkedList);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                listForAdapter, R.layout.list_items, keyArray, idArray);
        bookList.setAdapter(simpleAdapter);
        bookList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long l) {
                dialog.show();
                title_dialog_window.setText("Аннотация к книге \"" + bookLinkedList.get(i).title +"\" автора "+ bookLinkedList.get(i).author);
                switch (i){
                    case 0: {
                        text.setText("Действие первой части трилогии \"Основание\" разворачивается " +
                                "в далеком будущем, когда заселены планеты миллионов звездных систем " +
                                "Галактики. Математик и психоисторик Хэри Сэлдон предсказывает крах и " +
                                "возрождение через много лет несокрушимой Галактической Империи. Чтобы " +
                                "смягчить последствия катастрофы он разрабатывает проект создания " +
                                "Основания, которое должно стать центром зарождения новой Империи…\n");
                    }break;
                    case 1: {
                        text.setText("\"Преступление и наказание\" (1866) Фёдора Михайловича Достоевского " +
                                "(1821–1881) – это социально-психологический роман с ярко выраженным" +
                                " философским подтекстом. Критик и публицист Василий Розанов писал: " +
                                "\"Преступление и наказание\" – самое законченное в своей форме и " +
                                "глубокое по содержанию произведение Достоевского, в котором он выразил " +
                                "свой взгляд на природу человека, его назначение и законы, которым он подчинён как личность...\"");
                    }break;
                    case 2: {
                        text.setText("Данное произведение представляет собой описание жизни бедного " +
                                "чиновника, Акакия Акакиевича Башмачкина. Маленький человек, замкнувшийся " +
                                "в собственном мирке идей и мыслей, беспрекословно терпящий издевательства" +
                                " сослуживцев и тяжёлые условия жизни, преподнесённые ему судьбой, " +
                                "одержим одной целью — покупкой новой шинели.");
                    }break;
                    case 3: {
                        text.setText("Повесть «Роковые яйца» - произведение фантастическое и, " +
                                "вместе с тем, ужасающе реалистичное. Вы насладитесь атмосферой " +
                                "и духом повести, воплощенными в емком, многогранном «булгаковском»" +
                                " языке, яркой игре аллегорий и смысла, горьковатом и беспощадном юморе.");
                    }break;
                    case 4: {
                        text.setText("По мотивам русской народной сказки в обработке К. Д. Ушинского\": " +
                                "Русская народная сказка о Колобке, который ушел и от дедушки, и от бабушки, " +
                                "но не смог уйти от хитрой лисы, — одна из самых популярных сказок для " +
                                "малышей. Книжка-гармошка с яркими, веселыми иллюстрациями прекрасно " +
                                "подойдет для совместного чтения и игры с ребенком.");
                    }
                }
            }
        });
    }
}
//TODO дз: в презентации. Или диалоговое окно для аннотаций для каждой книги