package com.example.combindconcepts.ViewsLayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.combindconcepts.DataLayer.HomeScreen.ShopItemAdapter
import com.example.combindconcepts.DataLayer.ShopItems
import com.example.combindconcepts.DataLayer.Shopper
import com.example.combindconcepts.R
import com.example.combindconcepts.databinding.ActivityHomeScreenBinding
import com.example.combindconcepts.databinding.ContentMainBinding
import com.example.combindconcepts.databinding.RegisterDialogBinding

class HomeScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeScreenBinding
    private lateinit var includeLayoutBind: ContentMainBinding
    private lateinit var itemList: ArrayList<ShopItems>
    private lateinit var shopAdapter: ShopItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemList = ArrayList<ShopItems>()

        itemList.add(ShopItems("Frozen0 Goods", R.drawable.ic_baseline_severe_cold_24))
        itemList.add(ShopItems("Frozen1 Goods", R.drawable.ic_baseline_severe_cold_24))
        itemList.add(ShopItems("Frozen2 Goods", R.drawable.ic_baseline_severe_cold_24))
        itemList.add(ShopItems("Frozen3 Goods", R.drawable.ic_baseline_severe_cold_24))
        itemList.add(ShopItems("Frozen4 Goods", R.drawable.ic_baseline_severe_cold_24))
        itemList.add(ShopItems("Frozen1 Goods", R.drawable.ic_baseline_severe_cold_24))
        itemList.add(ShopItems("Frozen2 Goods", R.drawable.ic_baseline_severe_cold_24))
        itemList.add(ShopItems("Frozen3 Goods", R.drawable.ic_baseline_severe_cold_24))
        itemList.add(ShopItems("Frozen4 Goods", R.drawable.ic_baseline_severe_cold_24))
        binding.includeLayout.shopItemRecyclerView.layoutManager = GridLayoutManager(this,2)
        shopAdapter = ShopItemAdapter(itemList)
        binding.includeLayout.shopItemRecyclerView.adapter = shopAdapter
        Log.i("Working", itemList.size.toString())

           views()

    }
    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu.setHeaderTitle("Profile")
        menu.add(getString(R.string.shopper_profile))
        menu.add(getString(R.string.shopper_order_history))
        menu.add(getString(R.string.shopper_settings))
        menu.add(getString(R.string.deals))
        menu.add(getString(R.string.shopper_logout))
    }

    private fun views(){
        binding.apply {
            homeMenuBtn.setOnClickListener {
                val popUp = PopupMenu(this@HomeScreenActivity,homeMenuBtn)
                popUp.menuInflater.inflate(R.menu.popup_menu, popUp.menu)
                shopperNavView.setNavigationItemSelectedListener { items ->
                    items.isChecked = true
                   rootLayout.closeDrawers()

                    when (items.itemId) {
                        R.id.profile -> openFrag(ProfileFragment())
                        R.id.orderHistory -> Toast.makeText(this@HomeScreenActivity, "wallet", Toast.LENGTH_SHORT)
                            .show()
                        R.id.settings -> Toast.makeText(this@HomeScreenActivity, "settings", Toast.LENGTH_SHORT).show()
                        R.id.nav_offers -> Toast.makeText(this@HomeScreenActivity, "Offers", Toast.LENGTH_SHORT).show()
                        R.id.log_out -> Toast.makeText(this@HomeScreenActivity, "Logout", Toast.LENGTH_SHORT).show()
                    }

                    true
                }
                popUp.show()
            }

        }

    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                binding.rootLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (binding.rootLayout.isDrawerOpen(GravityCompat.START)) {
            binding.rootLayout.closeDrawers()
        } else {
            super.onBackPressed()
        }
    }

    private fun openFrag(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container1,fragment).commit()
    }




}