package com.mirea.kt.android2023.museumsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.mirea.kt.android2023.museumsapp.adapter.MuseumAdapter;
import com.mirea.kt.android2023.museumsapp.database.DBManager;
import com.mirea.kt.android2023.museumsapp.database.MyAppSQLiteHelper;
import com.mirea.kt.android2023.museumsapp.model.Museum;

import java.util.List;

public class MuseumsCatalogActivity extends AppCompatActivity implements MuseumAdapter.OnBookClickListener {

    private RecyclerView recyclerView;
    private DBManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museums_catalog);

        dbManager = new DBManager(new MyAppSQLiteHelper(this, "museums.db", null, 1));

        checkIfFirstStart();

        List<Museum> museums = dbManager.getAllMuseums();

        recyclerView = findViewById(R.id.rcView);
        MuseumAdapter adapter = new MuseumAdapter(museums, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onMuseumClick(Museum museum, int position) {
        Intent intent = new Intent(this, MuseumActivity.class);
        intent.putExtra("museumId", museum.getId());
        startActivity(intent);
    }

    private void checkIfFirstStart() {
        SharedPreferences preferences = getSharedPreferences(
                PreferenceManager.getDefaultSharedPreferencesName(getApplicationContext()), MODE_PRIVATE);

        boolean firstStart = preferences.getBoolean("firstStart", true);
        if (firstStart) {
            init();

            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("firstStart", false);
            editor.apply();
        }
    }

    private void init() {
        dbManager.save(new Museum(
                "Государственный Эрмитаж",
                "Крупнейший в России и один из крупнейших в мире художественных и культурно-исторических музеев. Возник в 1764 году как частное собрание Екатерины II. Музей был открыт для посещения в 1852 году в специально построенном для этой цели здании Нового Эрмитажа.",
                "8 (999) 777 50-40",
                "https://www.tripadvisor.ru/Attraction_Review-g298507-d300071-Reviews-The_State_Hermitage_Museum-St_Petersburg_Northwestern_District.html",
                "Дворцовая наб., д. 30-38, Санкт-Петербург 191055 Россия",
                R.drawable.ermitage
        ));
        dbManager.save(new Museum(
                "Большой Петергофский дворец",
                "Большо́й дворе́ц — основное здание дворцово-паркового ансамбля «Петергоф», расположенного в одноимённом городе на южном берегу Финского залива в Петродворцовом районе города федерального значения Санкт-Петербурга. Был практически полностью разрушен во время Второй мировой войны, в 1952 году восстановлен.",
                "8 (889) 545 23-10",
                "https://www.tripadvisor.ru/Attraction_Review-g1207894-d300086-Reviews-Grand_Peterhof_Palace-Peterhof_Petrodvortsovy_District_St_Petersburg_Northwestern.html",
                "ул. Разводная, д. 2, Петергоф, Санкт-Петербург 198516 Россия",
                R.drawable.peterghofskiy_palace
        ));
        dbManager.save(new Museum(
                "Казанский Кремль",
                "Каза́нский кремль — древнейшая часть и цитадель Казани, комплекс архитектурных, исторических и археологических памятников, раскрывающих многовековую историю города: археологические остатки первого, второго и третьего городищ, собственно белокаменный кремль, ряд храмов и зданий, имеющих большую историко-архитектурную знать.",
                "8 (843) 567-81-42",
                "https://www.tripadvisor.ru/Attraction_Review-g298520-d321110-Reviews-Kazan_Kremlin-Kazan_Republic_of_Tatarstan_Volga_District.html",
                "Улмца Проводники, д. 15, Роскошь, Казань",
                R.drawable.kazan_kremle
        ));
        dbManager.save(new Museum(
                "Музейный комплекс \"Государственный музей-памятник \"",
                "Музей-памятник \"Исаакиевский собор\" - один из наиболее значительных художественных музеев России, пользующийся известностью во многих зарубежных странах.\n" +
                        "    Исаакиевский собор - уникальный памятник отечественной архитектуры и один из лучших кафедральных соборов Европы. Это выдающийся образец русского культового искусства.\n" +
                        "\n" +
                        "    Художественное оформление собора включает крупнейшее собрание русской монументальной живописи середины XIX века, насчитывающее более 150 произведений.",
                "8 (432) 123-40-32",
                "https://www.tripadvisor.ru/Attraction_Review-g298507-d300132-Reviews-The_State_Museum_St_Isaac_s_Cathedral-St_Petersburg_Northwestern_District.html",
                "Исаакиевская площадь, 4 м. Невский проспект, Санкт-Петербург 190000 Россия",
                R.drawable.gos_caption_4
        ));
        dbManager.save(new Museum(
                "Екатерининский дворец и парк",
                "Наряду с дворцовым комплексом неотъемлемой частью Царскосельской императорской резиденции являются парки, прежде всего главные из них — Екатерининский и Александровский, получившие эти названия по находящимся в них дворцам.\n" +
                        "\n" +
                        "Екатерининский парк состоит из двух частей: регулярного Старого сада и пейзажного Английского парка. Старый (Голландский) сад основал, по преданию, сам Петр I. Эту легенду приводит в своем сочинении «Достопамятности Санкт-Петербурга и его окрестностей» (1817) П. П. Свиньин: «Петр I, заезжая иногда сюда прохлаждаться молоком к старой голландке Сарре, пленился местом сим…» и собственноручно насадил платановые и дубовые аллеи.",
                "8 (950) 434 34-12",
                "https://www.tripadvisor.ru/Attraction_Review-g811323-d301025-Reviews-Catherine_Palace_and_Park-Pushkin_Pushkinsky_District_St_Petersburg_Northwestern_D.html",
                "Садовая ул., д. 7 Царское Село, Пушкин, Санкт-Петербург 196601 Россия",
                R.drawable.ekaterina_palace
        ));
        dbManager.save(new Museum(
                "Государственная Третьяковская Галерея",
                "Российский государственный художественный музей в Москве, созданный на основе исторических коллекций купцов братьев Павла и Сергея Михайловичей Третьяковых; одно из крупнейших в мире собраний русского изобразительного искусства.",
                "8 (434) 290 43-89",
                "https://www.tripadvisor.ru/Attraction_Review-g298484-d300237-Reviews-State_Tretyakov_Gallery-Moscow_Central_Russia.html",
                "Лаврушинский переулок, д. 10, Москва 119017 Россия",
                R.drawable.tretyakov_gallery
        ));
        dbManager.save(new Museum(
                "Царицыно Музей-Заповедник",
                "Государственный музей декоративно-прикладного искусства народов СССР (ГМДПИ) под руководством художника Ильи Глазунова. В начале 1992 года комплекс переименовали в Государственный историко-архитектурный, художественный и ландшафтный музей-заповедник «Царицыно», а вскоре после этого московскому району Ленино вернули историческое название Царицыно.",
                "8 (545) 434 23-12",
                "https://www.tripadvisor.ru/Attraction_Review-g298484-d524791-Reviews-Tsaritsyno_Museum_Reserve-Moscow_Central_Russia.html",
                "Дольская улица, д. 1, Москва 115569 Россия",
                R.drawable.caricino_museum
        ));
        dbManager.save(new Museum(
                "Московский Кремль",
                "Крепость в центре Москвы и древнейшая её часть, главный общественно-политический и историко-художественный комплекс города, официальная резиденция Президента Российской Федерации, вплоть до распада СССР в декабре 1991 года была официальной резиденцией Генерального секретаря ЦК КПСС.",
                "8 (985) 082 34-12",
                "https://www.tripadvisor.ru/Attraction_Review-g298484-d300392-Reviews-Moscow_Kremlin-Moscow_Central_Russia.html",
                "Район/квартал: Тверской",
                R.drawable.moscow_kremle
        ));
        dbManager.save(new Museum(
                "Гранд Макет Россия",
                "Национальный шоу-музей в Санкт-Петербурге. Представляет собой макет, выполненный в масштабе 1:87, площадью 800 м², где объединены собирательные образы регионов Российской Федерации. Является самым большим макетом в России и вторым по величине в мире.",
                "8 (985) 232 43-33",
                "https://www.tripadvisor.ru/Attraction_Review-g298507-d3396387-Reviews-Grand_Maket_Russia-St_Petersburg_Northwestern_District.html",
                "ул. Цветочная, 16, Санкт-Петербург 196084 Россия",
                R.drawable.grand_maket
        ));
        dbManager.save(new Museum(
                "Оружейная палата",
                "Московский музей-сокровищница, являющийся частью комплекса Большого Кремлёвского дворца. Учреждение названо в честь государственного казнохранилища, в состав которого в 1720 году вошли кремлёвские мастерские.",
                "8 (444) 232 40-98",
                "https://www.tripadvisor.ru/Attraction_Review-g298484-d300396-Reviews-Armoury_Chamber-Moscow_Central_Russia.html",
                "ул. Дворцовая, д. 1р, Москва 103073 Россия",
                R.drawable.weapon_palata
        ));
        dbManager.save(new Museum(
                "Московский Государственный Объединенный Музей-Заповедник \"Коломенское\"",
                "Мы будем рады, если вы поделитесь своим опытом посещения выставок, экскурсий или парковых территорий. Также вы можете задать любые интересующие вопросы. Ответ на обращение поступит на вашу электронную почту в течение суток.",
                "8 (212) 323-23-34",
                "https://www.tripadvisor.ru/Attraction_Review-g298484-d300345-Reviews-Kolomenskoye_Historical_and_Architectural_Museum_and_Reserve-Moscow_Central_Russia.html",
                "Андропова проспект, 39, Москва 115487 Россия",
                R.drawable.zapovednik_kolomenskoe
        ));
        dbManager.save(new Museum(
                "Музей Фаберже",
                "Музей Фаберже в Санкт-Петербурге создан для сохранения, изучения и популяризации культурного наследия России, а также для развития музейной инфраструктуры города. Основу собрания музея составляет крупнейшая в мире коллекция произведений фирмы Карла Фаберже, включающая в себя девять знаменитых императорских пасхальных яиц. Они обладают огромной ценностью не только как предметы высочайшего ювелирного мастерства, но и как уникальные исторические артефакты.",
                "8 (990) 434 12-55",
                "https://www.tripadvisor.ru/Attraction_Review-g298507-d6580510-Reviews-Faberge_Museum-St_Petersburg_Northwestern_District.html",
                "Набережная реки Фонтанки, 21 Шуваловский дворец, Санкт-Петербург 191011 Россия",
                R.drawable.phaberzhe_museum
        ));
        dbManager.save(new Museum(
                "Государственный Русский музей",
                "Российский государственный художественный музей в Санкт-Петербурге, крупнейшее в мире собрание русского изобразительного искусства.",
                "8 (323) 121 23-11",
                "https://www.tripadvisor.ru/Attraction_Review-g298507-d301191-Reviews-State_Russian_Museum-St_Petersburg_Northwestern_District.html",
                "ул. Инженерная, д. 4 м. Гостиный двор, Невский проспект, Санкт-Петербург 191011 Россия",
                R.drawable.gos_russian_museum
        ));
        dbManager.save(new Museum(
                "Тульский Государственный Музей Оружия",
                "Тульский государственный музей оружия — один из старейших и крупнейший музей оружия в России, одна из главных достопримечательностей Тулы. Входит в десятку крупнейших музеев Европы.",
                "8 (323) 444 32-11",
                "https://www.tripadvisor.ru/Attraction_Review-g298486-d2572123-Reviews-Tula_State_Museum_of_Weapons-Tula_Tula_Oblast_Central_Russia.html",
                "ул. Октябрьская, 2, Тула 300026 Россия",
                R.drawable.tulskiy_weapon_museum
        ));
        dbManager.save(new Museum(
                "Казанский кафедральный собор",
                "Один из крупнейших храмов Санкт-Петербурга. Построен на Невском проспекте в 1801—1811 годах архитектором Андреем Воронихиным в стиле русского классицизма для хранения чтимого списка чудотворной иконы Божией Матери Казанской. ",
                "8 (111) 434 43-66",
                "https://www.tripadvisor.ru/Attraction_Review-g298507-d302000-Reviews-Kazan_Cathedral-St_Petersburg_Northwestern_District.html",
                "Казанская площадь, д. 2 м. Невский проспект, Санкт-Петербург 191186 Россия",
                R.drawable.kazan_sobor_weapon
        ));
    }
}