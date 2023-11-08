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
                "Музей Московской железной дороги",
                "Музей Московской железной дороги — московский музей-павильон, расположенный около Павелецкого вокзала. До 1992 года — филиал Центрального музея В. И. Ленина «Траурный поезд В. И. Ленина», получивший своё название из-за расположенного в нём траурного поезда, который в 1924 году доставил тело Ленина в Москву.",
                "8 (499) 623 39-78",
                "http://www.museum.ru/M1725",
                "Кожевническая ул., 2, Москва, 115114",
                R.drawable.railway
        ));
        dbManager.save(new Museum(
                "Национальный центр современного искусства",
                "Госуда́рственный це́нтр совреме́нного иску́сства — музейно-выставочный и научно-исследовательский центр в Москве, занимающийся развитием современного российского искусства и популяризацией знания.",
                "8 (499) 505 12-43",
                "http://ncsm.by/",
                "Зоологическая ул., 13, стр. 2, Москва, 123242",
                R.drawable.iskusstvo_museum
        ));
        dbManager.save(new Museum(
                "Останкинский дворец",
                "Государственный дворцово-парковый музей-заповедник «Останкино и Кусково» – это музейный комплекс, объединяющий две единственные в своем роде московские усадьбы. Русская усадьба – феномен нашей истории и культуры. В ней синтезировались традиции семьи и рода, культуры дворянская и крестьянская, города и провинции, России и Запада.",
                "8 (495) 602 18-52",
                "https://ostankino-museum.ru/",
                "1-я Останкинская ул., 5, стр. 1, Москва",
                R.drawable.ostan_palace
        ));
        dbManager.save(new Museum(
                "Поклонная гора",
                "Покло́нная гора́ — срытый пологий холм в Западном административном округе Москвы, находится между реками Сетунь и Филька.",
                "8 (495) 233 55-44",
                "https://www.kp.ru/russia/moskva/mesta/poklonnaya-gora/",
                "Москва, 121096, Парк Победы, Славянский бульвар, Кутузовская, Фили",
                R.drawable.poklon_gora
        ));
        dbManager.save(new Museum(
                "Политехнический музей",
                "Политехнический — один из старейших в мире музеев науки и технологий. Он всегда стремился делать доступными для всех идеи и открытия, определяющие путь научно-технического прогресса. Сейчас историческое здание музея, построенное полтора века назад в центре Москвы, закрыто на реконструкцию.",
                "8 (495) 012 32-99",
                "https://polymus.ru/museum/",
                "Новая пл., 3/4, Москва, 101000",
                R.drawable.politech_museum
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
                "Музей Пушкина",
                "Государственный музей А.С. Пушкина сегодня – один из признанных культурных центров Москвы и России. Помимо головного музея, ГМП включает ещё пять филиалов: Мемориальную квартиру А.С. Пушкина на Арбате, Мемориальную квартиру А. Белого на Арбате, Дом-музей И.С. Тургенева на Остоженке, Дом-музей В.Л. Пушкина на Старой Басманной и Выставочные залы в Денежном переулке. Основной музейный комплекс располагается в замечательном архитектурном памятнике начала XIX века – городской дворянской усадьбе Хрущёвых-Селезнёвых на ул. Пречистенка, 12/2.",
                "8 (495) 043 90-51",
                "http://www.pushkinmuseum.ru/",
                "ул. Волхонка, 12, Москва, 119019",
                R.drawable.pushkin
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
                "Музей РКК \"Энергия\"",
                "Это единственный в нашей стране музей, где можно встретить столько космических аппаратов, побывавших в космосе! Здесь представлен космический аппарат, на котором были доставлены на орбиту и впервые живыми возвращены на Землю собаки Белка и Стрелка. Своими глазами вы увидите и прикоснетесь к уникальному экспонату – спускаемому аппарату корабля «Восток»",
                "8 (495) 078 74-11",
                "https://www.energia.ru/ru/corporation/museum.html",
                "Ярославское ш., 1, Мытищи, Московская обл., 141070",
                R.drawable.rkk
        ));
        dbManager.save(new Museum(
                "Музей археологии Москвы",
                "Музей, посвящённый археологическим раскопкам на территории Москвы. Открытие состоялось в 1997 году, однако из-за плохого технического состояния здания в 2011-м была проведена масштабная реконструкция, продлившаяся до 2015 года. По состоянию на 2018 г. экспозиция состоит из более чем двух тысяч экспонатов и включает в себя предметы от эпохи палеолита до Нового времени, найденные во время археологических экспедиций на территории Москвы и Подмосковья.",
                "+7 (495) 692-00-20",
                "https://mosmuseum.ru/association/archeology/",
                "Россия, Москва, Манежная площадь, 1А",
                R.drawable.archeolog
        ));
        dbManager.save(new Museum(
                "Кутузовская изба",
                "Военно-исторический музей в Москве, посвящённый памяти военного совета в Филях. Отдел музея-панорамы «Бородинская битва». Здание музея представляет собой воссозданную крестьянскую избу, в которой 13 сентября 1812 года во время Отечественной войны состоялся военный совет русских генералов и было принято решение оставить Москву, а в самом музее восстановлена исторически достоверная обстановка этого события.",
                "+7 (499) 148-19-27",
                "https://www.tripadvisor.ru/Attraction_Review-g298484-d11867655-Reviews-Kutuzovskaya_Izba-Moscow_Central_Russia.html",
                "Россия, Москва, Кутузовский проспект, 38, стр. 2",
                R.drawable.kutuz_izba
        ));
        dbManager.save(new Museum(
                "Музей Отечественной войны 1812 года",
                "Музей в Москве, посвящённый событиям Отечественной войны 1812 года. Расположен в специально построенном павильоне во дворе бывшего здания Городской думы. Является филиалом Государственного Исторического музея. Открытие состоялось в 2012-м - к 200-летию войны с Францией. По состоянию на 2018 год, экспозиция включает в себя более 2000 предметов: медали и ордена, подлинное оружие, архивные документы и художественные произведения.",
                "+7 (495) 698-24-97",
                "https://shm.ru/museum/mov/",
                "Россия, Москва, площадь Революции, 2/3",
                R.drawable.mov
        ));
    }
}