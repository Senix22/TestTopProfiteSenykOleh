package com.senix22.testtopprofite.ui.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.senix22.testtopprofite.R
import com.senix22.testtopprofite.ui.App
import com.senix22.testtopprofite.ui.model.ProductData
import com.senix22.testtopprofite.ui.repository.ProductModel
import com.senix22.testtopprofite.ui.view.UserAdapter
import com.senix22.testtopprofite.ui.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.add_item.view.*
import javax.inject.Inject


class ProductrActivity : AppCompatActivity() {
    private lateinit var addBtn: FloatingActionButton
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: UserAdapter

    @Inject
    lateinit var viewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_activity)
        addBtn = findViewById(R.id.addingBtn)
        recycler = findViewById(R.id.mRecycler)

        (application as App).appComponent.inject(this)

        addBtn.setOnClickListener {
            addInfo()
        }

        adapter = UserAdapter()
        recycler.adapter = this.adapter
        recycler.layoutManager = LinearLayoutManager(this)
    }

    override fun onStart() {
        super.onStart()
        viewModel.liveData.observe(this) {
            adapter.submitList(
                it
            )
        }
    }

    private fun addInfo() {
        val addDialog = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.add_item, null)
        addDialog.setView(view)

        addDialog.setPositiveButton("Ok") { dialog, _ ->
            val productUrl = view.item_product_url?.text?.toString() ?: ""
            val productTitle = view.item_product_title?.text?.toString() ?: ""
            val userData = ProductModel(productUrl, productTitle)

            viewModel.add(userData)

            Toast.makeText(this, "Adding User Information Success", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()

        }
        addDialog.create()
        addDialog.show()
    }
}