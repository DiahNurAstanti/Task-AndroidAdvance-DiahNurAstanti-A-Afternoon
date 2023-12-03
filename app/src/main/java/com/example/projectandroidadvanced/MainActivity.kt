package com.example.projectandroidadvanced

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    lateinit var action: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title ="Android Development"
        toolbar.subtitle ="Infinite Learning"

        setSupportActionBar(toolbar)


        val bottom: BottomNavigationView= findViewById(R.id.bottom)
        bottom.setOnItemSelectedListener(this)
        replaceFragment(HomeFragment())

        val drawer: DrawerLayout= findViewById(R.id.drawer)
        action=ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(action)
        action.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navigation: NavigationView= findViewById(R.id.navigation)
        navigation.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.trending -> {
                    Toast.makeText(this@MainActivity, "menu trending di-klik", Toast.LENGTH_SHORT).show()
                }
                R.id.gallery -> {
                    Toast.makeText(this@MainActivity, "menu gallery di-klik", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.share -> {
                Toast.makeText(this, "Aplikasi telah dibagikan", Toast.LENGTH_SHORT).show()
            }
            R.id.menuAbout -> {
                Toast.makeText(this, "menu about di-klik", Toast.LENGTH_SHORT).show()
            }
            R.id.menuSettings -> {
                Toast.makeText(this, "menu setting di-klik", Toast.LENGTH_SHORT).show()
            }
            R.id.menuLogout -> {
                val builder = AlertDialog.Builder(this)

                // build alert dialog
                builder.setTitle("logout")
                builder.setMessage("Anda yakin ingin logout?")

                builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                    Toast.makeText(this,"Anda telah logout", Toast.LENGTH_SHORT).show()
                }
                builder.setNegativeButton(android.R.string.no) { dialog, which ->
                    Toast.makeText(this, "Logout dibatalkan", Toast.LENGTH_LONG).show()
                }

                builder.show()
                }
        }
        if(action.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home-> {
                replaceFragment(HomeFragment())
                return true
            }
            R.id.berita-> {
                replaceFragment(BeritaFragment())
                return true
            }
            R.id.profile-> {
                replaceFragment(ProfileFragment())
                return true
            }
            else-> return false
        }
    }
    private fun replaceFragment(fragment :Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.commit()
    }

}