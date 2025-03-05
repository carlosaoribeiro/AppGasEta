package devandroid.maddo.appgaseta.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.maddo.appgaseta.model.Pessoa;
import devandroid.maddo.appgaseta.view.MainActivity;

public class PessoaController {
    public static final String NOME_PREFERENCES = "pref_listavip";  // Corrigido o nome
    SharedPreferences preferences;
    SharedPreferences.Editor listavip;

    // Construtor para inicializar SharedPreferences
    public PessoaController(MainActivity activity) {
        preferences = activity.getPreferences(MainActivity.MODE_PRIVATE); // Definido modo private corretamente
        listavip = preferences.edit();
    }

    // Método para salvar os dados da pessoa
    public void salvar(Pessoa pessoa) {
        Log.d("MVC Controller", "salvo: " + pessoa.toString());

        // Salvando os dados de pessoa no SharedPreferences
        listavip.putString("primeiro_nome", pessoa.getPrimeiroNome());  // Corrigindo a chave
        listavip.putString("sobrenome", pessoa.getSobreNome());
        listavip.putString("telefone_contato", pessoa.getTelefoneContato());
        listavip.putString("curso", pessoa.getCursoDesejado());
        listavip.apply();  // Salva as alterações
    }

    // Método para buscar os dados da pessoa
    public Pessoa buscar(Pessoa pessoa) {
        pessoa.setPrimeiroNome(preferences.getString("primeiro_nome", "NA"));
        pessoa.setSobreNome(preferences.getString("sobrenome", "NA"));
        pessoa.setCursoDesejado(preferences.getString("curso", "NA"));
        pessoa.setTelefoneContato(preferences.getString("telefone_contato", "NA"));

        return pessoa;
    }

    // Método para limpar os dados no SharedPreferences
    public void limpar() {
        listavip.clear();
        listavip.apply();  // Aplica as mudanças
    }

    // Método toString para debugar
    @NonNull
    @Override
    public String toString() {
        Log.d("MVC Controller", "MVC Controller iniciada..");
        return super.toString();
    }
}
