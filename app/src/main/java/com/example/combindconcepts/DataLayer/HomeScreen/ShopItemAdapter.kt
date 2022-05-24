package com.example.combindconcepts.DataLayer.HomeScreen

import android.content.Context
import android.content.Intent
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.combindconcepts.DataLayer.ShopItems
import com.example.combindconcepts.DataLayer.Shopper
import com.example.combindconcepts.R
import com.example.combindconcepts.ViewsLayer.HomeScreenActivity
import com.example.combindconcepts.databinding.ItemAdapterBinding
import com.example.combindconcepts.databinding.ItemDetailDialogBinding
import com.example.combindconcepts.databinding.RegisterDialogBinding

class ShopItemAdapter(private var itemList: ArrayList<ShopItems>): RecyclerView.Adapter<ShopItemAdapter.ViewHolder>() {
private lateinit var binding: ItemAdapterBinding
    override fun getItemCount(): Int = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemAdapter.ViewHolder{
            binding = ItemAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding.root)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }
//    private fun openItemDialog(){
//        val dialogBinding: ItemDetailDialogBinding = ItemDetailDialogBinding.inflate(LayoutInflater.from(parent.context)
//        val builder = AlertDialog.Builder(this).apply {
//            setView(dialogBinding.root)
//            setCancelable(false)
//        }
//
//        val dialog = builder.create()
//        dialog.window?.setGravity(Gravity.BOTTOM)
//        dialogBinding.cancleDialogBtn.setOnClickListener {
//            dialog.dismiss()
//        }
//
//        dialogBinding.apply {
//            registerBtn.setOnClickListener {
//                val intent = Intent(this@MainActivity, HomeScreenActivity::class.java)
//                startActivity(intent)
//                present.registerUser(
//                    Shopper(
//                        username.text.toString(),
//                        phone.text.toString(),
//                        email.text.toString(),
//                        password.text.toString()
//                    )
//                )
//                Toast.makeText(
//                    this@MainActivity,
//                    getString(R.string.sucess),
//                    Toast.LENGTH_SHORT
//                ).show()
//                dialog.dismiss()
//            }
//        }
//        dialog.show()
//
//        val params = dialog.window?.attributes
//        params?.height = WindowManager.LayoutParams.MATCH_PARENT
//        params?.width = WindowManager.LayoutParams.MATCH_PARENT
//        dialog.window?.attributes = params
//    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        fun bind(item: ShopItems){
            binding.apply {
                shopItemListName.text = item.itemName
                //storeItemListImg = item.itemNum
            }
        }
    }
    companion object{
        const val SENDER_VIEW = 1
    }

}
