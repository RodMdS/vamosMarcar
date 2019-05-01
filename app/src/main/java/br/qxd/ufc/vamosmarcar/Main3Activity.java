package br.qxd.ufc.vamosmarcar;

import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Date;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    // private TextView txtTeste;
    int eventSelected;

    private User user;
    private List<Event> eventList;

    private ArrayAdapter adapter;
    private ListView listViewEvents;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // txtTeste = (TextView) findViewById(R.id.teste);

        eventSelected = -1;
        eventList = user.getEvents();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, eventList );
        listViewEvents = (ListView) findViewById(R.id.listViewEvents);
        listViewEvents.setAdapter(this.adapter);
        listViewEvents.setSelector(android.R.color.holo_blue_light);

        listViewEvents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main3Activity.this,
                        "" + eventList.get(position).getName(),
                        Toast.LENGTH_SHORT).show();
                eventSelected = position;
            }
        });

        progressBar = findViewById( R.id.progressBar );
        progressBar.setIndeterminate( true );
        progressBar.setVisibility( View.VISIBLE );

        Intent fromLastActivity = getIntent();
        String newUsername = fromLastActivity.getStringExtra("newUsername");
        String newPhone = fromLastActivity.getStringExtra("newPhone");
        user = new User(newUsername, newPhone);

        // txtTeste.setText("Bem vindo, " + user.getUsername());
    }

    public void updateListaContatos(User user){
        progressBar.setVisibility(View.INVISIBLE);

        List<Event> events = user.getEvents();
        for(Event event: events) eventList.add(event);

        adapter.notifyDataSetChanged();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.add:
                addNewEvent();
                break;
            //case R.id.edit:
                //editEvent();
            //    break;
            //case R.id.delete:
                //deleteEvent();
            //    break;
            case R.id.settings:
                break;
            case R.id.about:
                break;
        }
        return true;
    }

    private void deleteEvent() {
        if(eventList.size() > 0) {
            eventList.remove(eventSelected);
            adapter.notifyDataSetChanged();
        } else {
            eventSelected = -1;
        }
    }

    public void editEvent(){
        Intent intent = new Intent(this, Main4Activity.class);
        //Intent intent2 = new Intent( this, "br.ufc.quixada.dadm.variastelas.ContactActivity" );

        Event event = eventList.get(eventSelected);

        intent.putExtra("id", event.getId());
        intent.putExtra("name", event.getName());
        intent.putExtra("datetime", event.getDatetime().toString());
        intent.putExtra("local", event.getLocal().toString());
        intent.putExtra("isOpen", event.getStageEvent());

        startActivityForResult(intent, Constrants.REQUEST_EDIT);
    }

    @Override
    protected void onActivityResult( int requestCode, int resultCode, @Nullable Intent data ) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Constrants.REQUEST_ADD && resultCode == Constrants.RESULT_ADD){
            String name = (String) data.getExtras().get("nome");
            Local local = new Gson().fromJson((String) data.getExtras().get("local"), Local.class);
            Datetime datetime = new Gson().fromJson((String) data.getExtras().get("datetime"), Datetime.class);

            Event event = new Event(name, local);
            event.setDatetime(datetime);

            eventList.add(event);
            adapter.notifyDataSetChanged();
        } else if( requestCode == Constrants.REQUEST_EDIT && resultCode == Constrants.RESULT_ADD){
            String name = (String) data.getExtras().get("nome");
            Local local = new Gson().fromJson((String) data.getExtras().get("local"), Local.class);
            Datetime datetime = new Gson().fromJson((String) data.getExtras().get("datetime"), Datetime.class);
            int idEditar = (int) data.getExtras().get("id");

            for(Event event: eventList){
               if(event.getId() == idEditar){
                   event.setName(name);
                   event.setDatetime(datetime);
                   event.setLocal(local);
                }
            }

            adapter.notifyDataSetChanged();

        } //Retorno da tela de contatos com um conteudo para ser adicionado
        //Na segunda tela, o usuario clicou no botão ADD
        else if( resultCode == Constrants.RESULT_CANCEL){
            Toast.makeText( this,"Cancelado",
                    Toast.LENGTH_SHORT).show();
        }

    }


    public void addNewEvent() {
        Intent intent = new Intent( this, Main4Activity.class );
        startActivityForResult(intent, Constrants.REQUEST_ADD);
    }

    /*public void proximaPagina(View v) {
        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
    }*/
}
