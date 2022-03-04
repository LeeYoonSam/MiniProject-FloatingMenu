package com.ys.mini.floatingmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.btnOpenMenu

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		registerForContextMenu(btnOpenMenu)
	}

	// 이 뷰에 대한 컨텍스트 메뉴가 빌드될 때 호출됩니다.
	override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenuInfo?) {
		super.onCreateContextMenu(menu, v, menuInfo)
		menuInflater.inflate(R.menu.floating_context_menu, menu)
	}

	override fun onContextItemSelected(item: MenuItem): Boolean {
		clickMenuItem(item)
		return super.onContextItemSelected(item)
	}

	// 팝업 메뉴 처리
	fun showPopup(v: View) {
		val popup = PopupMenu(this, v)
		val inflater: MenuInflater = popup.menuInflater
		inflater.inflate(R.menu.floating_context_menu, popup.menu)
		popup.setOnMenuItemClickListener { item ->
			clickMenuItem(item)
			false
		}
		popup.show()
	}

	private fun clickMenuItem(item: MenuItem) {
		when(item.itemId) {
			// 같은 작업을 하면 한번에 처리할수 있지만 구분되어 보이게 따로 처리했습니다.
			R.id.item1 -> showToast(item.title)
			R.id.item2 -> showToast(item.title)
			R.id.item3 -> showToast(item.title)
			R.id.item4 -> showToast(item.title)
		}
	}

	private fun showToast(message: CharSequence) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
	}
}