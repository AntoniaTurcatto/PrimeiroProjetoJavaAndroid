package com.example.primeiroprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textViewIdade, textViewNome, textViewAltura;
    EditText editTextIdade, editTextNome, editTextAltura;
    Button btnSalvar, btnCancelar, btnVisualizar;
    RadioButton radioButtonMasculino, radioButtonFeminino, radioButtonOutro;
    RadioGroup radioGroupSexo;

    ArrayList<Pessoa> listaPessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewIdade = findViewById(R.id.textViewIdade);
        textViewNome = findViewById(R.id.textViewNome);
        textViewAltura = findViewById(R.id.textViewAltura);

        editTextIdade = findViewById(R.id.editTextIdade);
        editTextNome = findViewById(R.id.editTextNome);
        editTextAltura = findViewById(R.id.editTextAltura);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnCancelar = findViewById(R.id.btnLimpar);
        btnVisualizar = findViewById(R.id.btnVisualizar);

        radioButtonMasculino = findViewById(R.id.radioButtonMasculino);
        radioButtonFeminino = findViewById(R.id.radioButtonFeminino);
        radioButtonOutro = findViewById(R.id.radioButtonOutro);

        radioGroupSexo = findViewById(R.id.radioGroupSexo);

        listaPessoas = new ArrayList();

        btnSalvar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(!editTextAltura.getText().toString().equals("")){
                    if(!editTextIdade.getText().toString().equals("")){
                        if(!editTextNome.getText().toString().equals("")){
                            if(radioButtonFeminino.isChecked()){
                                int sexo= 0;
                                adicionarNaListaEExibirPessoa(sexo);
                            } else if(radioButtonMasculino.isChecked()){
                                int sexo= 1;
                                adicionarNaListaEExibirPessoa(sexo);
                            } else if(radioButtonOutro.isChecked()){
                                int sexo= 2;
                                adicionarNaListaEExibirPessoa(sexo);
                                //se não for selecionado nenhum radioButton
                            } else if(!radioButtonOutro.isChecked() && !radioButtonFeminino.isChecked() && !radioButtonMasculino.isChecked()){
                                radioGroupSexo.requestFocus();
                                Toast.makeText(MainActivity.this, "Selecione um sexo", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            editTextNome.setError("Informe o nome");
                            editTextNome.requestFocus();
                        }

                    } else {
                        editTextIdade.setError("Informe a idade");
                        editTextIdade.requestFocus();
                    }
                } else {
                    editTextAltura.setError("Informe a altura");
                    editTextAltura.requestFocus();
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });

        btnVisualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(listaPessoas.size()>0){
                    int somaIdades=0;
                    float menorAltura = Float.MAX_VALUE;
                    float maiorAltura = 0.0f;
                    Pessoa pessoaMaisAlta = null;

                    for (Pessoa pessoa : listaPessoas){
                        //Toast.makeText(MainActivity.this, pessoa.toString(), Toast.LENGTH_SHORT).show();
                        somaIdades+=pessoa.getIdade();

                        //se for a menor altura
                        if(pessoa.getAltura() < menorAltura){
                            menorAltura = pessoa.getAltura();
                        }
                        //se for a maior altura
                        if(pessoa.getAltura() > maiorAltura){
                            pessoaMaisAlta = pessoa;
                            maiorAltura = pessoa.getAltura();
                        }

                    }

                    float mediaIdades = somaIdades/listaPessoas.size();
                    Toast.makeText(MainActivity.this, "Média das idades: " + mediaIdades, Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Pessoa mais alta: \n" + pessoaMaisAlta.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Nenhum registro salvo", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void limparCampos(){
        editTextAltura.setText("");
        editTextNome.setText("");
        editTextIdade.setText("");
        radioButtonOutro.setChecked(false);
        radioButtonFeminino.setChecked(false);
        radioButtonMasculino.setChecked(false);
    }

    public void adicionarNaListaEExibirPessoa(int sexo){
        String nome = editTextNome.getText().toString();
        int idade = Integer.parseInt(editTextIdade.getText().toString());
        float altura = Float.parseFloat(editTextAltura.getText().toString());

        Pessoa pessoa = new Pessoa(nome, idade,altura,sexo);
        listaPessoas.add(pessoa);

        Toast.makeText(MainActivity.this, pessoa.toString(), Toast.LENGTH_SHORT).show();
    }
}
