package com.example.turist.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.turist.Adapters.CategoryAdapter;
import com.example.turist.Adapters.PopularAdapter;
import com.example.turist.Domains.CategoryDomain;
import com.example.turist.Domains.PopularDomain;
import com.example.turist.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterPopular, adapterCat;
    private RecyclerView recyclerViewPopular, recyclerViewCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Kolsay Nomads","Көлсай",
                        "Көлсай көлдері – Күнгей-Алатау мен Іле Алатауы жоталары түйіскен жердегі Көлсай " +
                                "шатқалында орналасқан көлдер жүйесі. Көлдер суының түсі қою көктен " +
                                "изумрудты жасылға дейін күніне бірнеше рет өзгеретіндігмен танымал."
                ,2,true, 4.8, "hotel1",true,10000));
        items.add(new PopularDomain("Sharyn Panorama Resort","Шарын",
                "Шарын каньонында орналасқан қонақ үй табиғи ескерткіштің панорамалық көрінісін тамашалауға " +
                        "бірегей мүмкіндік береді. Заманауи қонақ үй ғимараты айналадағы ландшафтпен үйлесімді үйлеседі, " +
                        "қонақтарға қала шуынан тыныштық атмосферасында жайлы демалуды ұсынады."
                        ,1,false, 5, "hotel2",false,90000));
        items.add(new PopularDomain("Shymbulak Resort Hotel & Spa","Шымбулак",
                "Іле Алатауы ұлттық паркінің Іле Алатауы шатқалында теңіз деңгейінен 2260 метр биіктікте, " +
                        "Алматы қаласының орталығынан 25 км қашықтықта орналасқан. Shymbulak Resort қонақ үйі тау шаңғысы " +
                        "көтергіштерінен – Медеу-Шымбұлақ арқан жолынан 100 метр қашықтықта орналасқан. "
                ,3,true, 4.3, "hotel3",true,130000));
    recyclerViewPopular=findViewById(R.id.view_pop);
    recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
    adapterPopular=new PopularAdapter(items);
    recyclerViewPopular.setAdapter(adapterPopular);


    ArrayList<CategoryDomain> catsList=new ArrayList<>();
        catsList.add(new CategoryDomain("Beaches","cat1"));
        catsList.add(new CategoryDomain("Camps","cat2"));
        catsList.add(new CategoryDomain("Forest","cat3"));
        catsList.add(new CategoryDomain("Desert","cat4"));
        catsList.add(new CategoryDomain("Mountain","cat5"));


        recyclerViewCategory=findViewById(R.id.view_cat);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterCat = new CategoryAdapter(catsList);
        recyclerViewCategory.setAdapter(adapterCat);

    }
}