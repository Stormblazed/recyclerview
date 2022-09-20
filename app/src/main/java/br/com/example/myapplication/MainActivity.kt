package br.com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.example.myapplication.Adapter.CategoriaAdapter
import br.com.example.myapplication.Adapter.DescricaoAdapter
import br.com.example.myapplication.Model.CategoriaModel
import br.com.example.myapplication.Model.ProgramaModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listMenu = categorias()

        RvMenu.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        RvMenu.itemAnimator = DefaultItemAnimator()
        RvMenu.adapter = CategoriaAdapter(this,listMenu) {
            val descricao = getDescricao(it.Nome)
            RvList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
            RvList.itemAnimator = DefaultItemAnimator()
            RvList.adapter = DescricaoAdapter(this, descricao)
        }
        }


    }

    fun categorias():ArrayList<CategoriaModel>{
        val categorias = ArrayList<CategoriaModel>()

            categorias.add(CategoriaModel("Peças"))
            categorias.add(CategoriaModel("Programas"))
            categorias.add(CategoriaModel("Sites"))
            categorias.add(CategoriaModel("Sistemas"))

        return categorias
    }

    fun getDescricao(categoria: String): ArrayList<ProgramaModel>{
        val list = ArrayList<ProgramaModel>()

        when(categoria){
            "Peças"-> {
                list.add(ProgramaModel("Placa Mãe", "Asus"))
                list.add(ProgramaModel("Placa de Video", "Asus"))

            }
            "Programas"-> {
                list.add(ProgramaModel("Visual Code", "Microsoft"))
                list.add(ProgramaModel("Android", "JetBrains"))

            }
            "Sites"-> {
                list.add(ProgramaModel("Google.com", "Google"))
                list.add(ProgramaModel("Android", "Google"))

            }
            "Sistemas"-> {
                list.add(ProgramaModel("Windows", "Microsoft"))
                list.add(ProgramaModel("MacOS", "Apple"))

            }
        }
        return  list

    }


